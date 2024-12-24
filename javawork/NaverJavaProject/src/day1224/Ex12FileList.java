package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class Ex12FileList {
	static final String FILENAME = "c:/Users/cwsgc/sawon.txt";
	
	List<String> sawonList = new Vector<String>();
	
	public Ex12FileList() throws IOException {
		//파일에서 이름을 읽어서 sawonList에 추가
		//초기화하는 코드
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null)
				sawonList.add(line); //add 메서드 : 더해주는 역할
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) br.close();
			if (fr != null) fr.close();
		}
	}
	
	public void sawonMemberList() {
		//사원 이름을 번호와 함께 출력하는 메서드
		for (int i = 0; i < sawonList.size(); i++)
		{
			//get(int index) => 값을 가져오는 메서드 
			System.out.println((i + 1) + "\t" + sawonList.get(i));
		}	
	}
	
	public static void main(String[] args) {
		try {
            Ex12FileList fileList = new Ex12FileList();
            fileList.sawonMemberList();
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
	
	}

}
