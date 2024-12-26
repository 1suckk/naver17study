package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex12FileList {
	static final String FILENAME = "D:\\naver17study\\javawork\\NaverJavaProject\\src\\day1224\\sawon.txt";
	
	List<String> sawonList = new Vector<String>();
	
	public Ex12FileList() throws IOException {
		//여기서는 영속적인 파일 저장이 안됨
		//파일에서 이름을 읽어서 sawonList에 추가
		//초기화하는 코드
		FileReader fr = null;
		BufferedReader br = null; //줄단위 데이터를 받는 유일한 Reader
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) //더하기 전에 널체크를 선행해야 한다
				sawonList.add(line); //add 메서드 : 더해주는 역할
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) br.close(); //역순으로 br부터 닫아야 한다
			if (fr != null) fr.close(); //마찬가지로 여는 것의 역순으로 fr은 이후에 닫는다
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
	
	//이름 인덱스 조회 (없으면 -1 리턴)
	public int getSearchname(String name) 
	{
		int idx = -1; //초기값은 -1로 지정
		for (int i = 0; i <sawonList.size(); i++)
		{
			String listName = sawonList.get(i);
			if (listName.equals(name))
			{
				idx = i;
				break; //없으면 다시 for 문으로, 있으면 for 밖으로
			}
		}
		return idx;
	}
	
	//이름입력 시 삭제
	public void deleteSawon(String name)
	{
		int idx = getSearchname(name);
		if (idx == -1)
			System.out.println(name + "님은 사원 명단에 없습니다.");
		else
		{
			sawonList.remove(idx);
			System.out.println(name = "님을 사원명단에서 제거했습니다.");
		}
	}
	
	//이름 조회 (몇번째에 있는지 출력)
	public void searchName(String name) {
		int idx = this.getSearchname(name);
		if (idx == -1)
			System.out.println(name + "님은 사원 명단에 없습니다.");
		else
			System.out.println(name + "님은 " + (idx + 1) + "번째에 있습니다.");
	}
	
	//파일에 저장하는 메서드
	public void sawonFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME); //실패할 일이 없음
			for (String name:sawonList)
			{
				fw.write(name + "\n"); //메모장에 이름쓰고 개행 반복
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
	
	//사원명 추가
	public void addSawon(String name) {
		//이미 존재할 경우 추가 못함
		int idx = this.getSearchname(name);
		if (idx != -1)
			System.out.println(name + "님은 이미 존재합니다.");
		else
		{
			sawonList.add(name);
			System.out.println("추가되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		try {
            Ex12FileList fileList = new Ex12FileList();
            Scanner sc = new Scanner(System.in);
            int menu = 0;
            
            //아래와 같이 쓰면 각 case 문에서 break를 쓰지 않아도 된다
            while(true)
            {
            	System.out.println("1.사원추가  2. 사원삭제  3.사원검색  4.전체목록"
            			+ "  5.저장후종료");
            	System.out.println("=".repeat(40));
            	try {
            	menu = Integer.parseInt(sc.nextLine());
            	} catch(NumberFormatException e) {
            		menu=4;
            	}
            	switch(menu)
            	{
            	case 1 -> {
            		System.out.println("추가할 사원명을 입력하세요.");
            		String name = sc.nextLine();
            		fileList.addSawon(name);
            	}
            	case 2 -> {
            		System.out.println("삭제할 사원명을 입력하세요.");
            		String name = sc.nextLine();
            		fileList.deleteSawon(name);
            	}
            	case 3 -> {
            		System.out.println("검색할 사원명을 입력하세요.");
            		String name = sc.nextLine();
            		fileList.searchName(name);
            	}
            	case 4 -> fileList.sawonMemberList();
            	default -> {
            		System.out.println("**저장후 종료**");
            		fileList.sawonFileSave();
            		System.exit(0);
            	}
            	}
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
	}
}
