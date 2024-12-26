package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex4JTableSawon extends JFrame {

	JTable table;
	List<Sawon> sawonList = new Vector<Sawon>();
	static final String SAWONFILE = "d:/naver17study/mysawon.txt";
	
	public Ex4JTableSawon() {
		super("사원파일 읽기");
		this.setBounds(300, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			this.initDesign();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //컴포넌트를 추가
		this.setVisible(true);	
	}
	
	public void initDesign() throws IOException {
		//파일 정보 읽어오기
		this.sawonFileRead();
		String[] title = {"사원명", "나이", "핸드폰", "주소"};
		
		//테이블 내의 데이터 부분
		String[][] data = new String[sawonList.size()][4];
		
		int i = 0;
		for (Sawon s: sawonList)
		{
			data[i][0] = s.getSawonName();
			data[i][1] = String.valueOf(s.getAge());
			data[i][2] = s.getHp();
			data[i][3] = s.getAddress();
		}
		
		//table 생성 == 배열로 읽기도 가능함
		table = new JTable(data, title);
		this.add("Center", new JScrollPane(table));
	}
	
	public void sawonFileRead() throws IOException
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(SAWONFILE);
			br = new BufferedReader(fr);
			
			while(true)
			{
				String sawonInfo = br.readLine();
				if(sawonInfo==null)
					break;
			
				String[] s = sawonInfo.split("\\|");
				Sawon sawon = new Sawon();
				sawon.setSawonName(s[0]);
				sawon.setAge(Integer.parseInt(s[1]));
				sawon.setHp(s[2]);
				sawon.setAddress(s[3]);
			
				sawonList.add(sawon);
			}
			//콘솔을 실행하면 맨 앞에 나옮
			System.out.println("총 " + sawonList.size() + "명 읽음");
		} catch (FileNotFoundException e) {
			System.out.println("저장된 사원정보가 없습니다.");
		} finally {
			if (br != null) br.close();
			if (fr != null) fr.close();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3JTableSawon();
	}
}