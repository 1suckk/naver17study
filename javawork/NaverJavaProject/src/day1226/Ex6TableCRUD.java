package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame {
	JTable table;
	DefaultTableModel tableModel; //추가, 삭제 등의 메서드를 가지고 있는 클래스 모델
	List<Student> studentList = new ArrayList<Student>();
	static final String FILENAME = "D:\\naver17study\\javawork\\NaverJavaProject\\src\\day1226\\student.txt";
	JTextField tfName, tfKor, tfEng; //이름, 국어성적, 영어성적
	JButton btnAdd; //추가 버튼만
	
	public Ex6TableCRUD() {
		// TODO Auto-generated constructor stub
		super("학생관리");
		this.setBounds(300, 100, 400, 300);
		
		this.initDesign();
		this.setVisible(true);
		
		//상단 우측의 x 버튼 클릭시 콘솔 종료라는 이벤트 발생 파일 저장
		this.addWindowListener(new WindowAdapter() {
			//종료라는 이벤트를 구현하는 익명 내부 클래스
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//list 의 내용을 파일에 저장한다
				saveFile();
				//프로그램 종료
				System.exit(0);
				
				super.windowClosing(e);
			}
		});
	}
	
	public void studentFileRead() {
		//파일을 읽어서 list 변수에 담기
		//Reader 초기화 
		FileReader fr = null;
		BufferedReader br = null;
		
		//파일을 읽고 버퍼에 넣을 Reader 가 열리지 않았는지 확인
		try {
			 	fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split("\\|"); //data의 열을 구분하는 "|"
	                /*
	                 * 이름, 국어성적, 영어성적을 받고나면 (data.length >= 3)
	                 * studentList의 각 부분에 배열처럼 집어넣기 
	                 */
	                if (data.length >= 3) {
	                    Student student = new Student();
	                    student.setName(data[0]);
	                    student.setKor(Integer.parseInt(data[1]));
	                    student.setEng(Integer.parseInt(data[2]));
	                    studentList.add(student);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	//List 의 데이터를 테이블에 출력해주는 메서드
	public void writeTableData() {
		// 기존의 테이블에 출력된 데이터를 삭제 후 다시 추가
		tableModel.setRowCount(0);
		
		for (Student stu:studentList)
		{	
			Vector<String> data = new Vector<String>();
			
			int kor = stu.getKor();
			int eng = stu.getEng();
			int sum = kor + eng;
			double avg = sum/2.0;
			
			data.add(stu.getName());
			data.add(String.valueOf(kor));
			data.add(String.valueOf(eng));
			data.add(String.valueOf(sum));
			data.add(String.valueOf(avg));
			
			// table에 추가 
			tableModel.addRow(data);
		}
	}
	
	public void initDesign() {
		//파일을 읽어온다
		this.studentFileRead();
		
		//테이블을 생성해서 center에 추가
		String[] title = {"이름", "국어", "영어", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		
		//table에 데이터 추가
		this.writeTableData();
		
		//frame에 추가
		this.add("Center", new JScrollPane(table));
		
		//입력부분 디자인
		JPanel panel = new JPanel();
		tfName = new JTextField(5);
		tfKor = new JTextField(4);
		tfEng = new JTextField(4);
		
		btnAdd = new JButton("추가");
		
		//버튼 클릭 시 이벤트 발생
		//익명 내부 클래스로 만들어진다
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 입력한 데이터를 읽어서 Student 에 넣은 후 다시 list에 추가
				String name = tfName.getText();
				int kor = Integer.parseInt(tfKor.getText());
				int eng = Integer.parseInt(tfEng.getText());
				
				Student stu = new Student(name, kor, eng);
				studentList.add(stu);
				
				// table 다시 출력
				writeTableData();
				
				// 입력데이터는 지우기
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
			}
		});
		
		// panel에 각 컴포넌트 추가
		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(btnAdd);
		
		//frame에 panel을 south(하단) 에 추가하자
		this.add("South", panel);
	}
	
	public void saveFile() {
		//List 의 내용을 파일에 저장한다
		FileWriter fw  =null;
		try {
			fw = new FileWriter(FILENAME);
			
			for (Student stu:studentList)
			{
				String s = stu.getName() + "|" + stu.getKor() +
				"|" + stu.getEng() + "\n";
				fw.write(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6TableCRUD(); //main에서 생성자 호출
	}

}
