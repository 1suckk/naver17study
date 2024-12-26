package day1226;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame {
	
	JTable table;
	List<Student> studentList = new ArrayList<Student>();
	static final String FILENAME = "d:/naver17study/student.txt";
	
	//생성자 부분
	public Ex5TableStudent() {
		super("학생성적관리");
		this.setBounds(300, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
		System.out.println(studentList);
		System.out.println(Student.class);
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
	
	public void initDesign() {
		this.studentFileRead(); //파일을 읽어서 list 변수에 담는다
		
		//list 의 데이터를 읽어서 테이블에 입력 후
		//프레임에 출력하시오
		//제목은 이름, 국어, 영어, 총점, 평균
		Vector<String> title = new Vector<String>();
		title.add("이름");
		title.add("국어");
		title.add("영어");
		title.add("총점");
		title.add("평균");
		
		//테이블 내의 데이터 부분
		Vector<Vector<String>> data = new Vector<Vector<String>>();
				
				for (Student s: studentList)
				{
					Vector<String> student = new Vector<String>();
					student.add(s.getName());
					student.add(String.valueOf(s.getKor()));
					student.add(String.valueOf(s.getEng()));
					student.add(String.valueOf(s.getTotal())); // static 메서드
			        student.add(String.format("%.1f", s.getAverage())); // static 메서드
					
					data.add(student);
				}
				
				//table 생성
				table = new JTable(new Vector<Vector<String>>(data), title);
				this.add("Center", new JScrollPane(table));
	}
	
	public static void main(String[] args) {
		new Ex5TableStudent();
	}
}