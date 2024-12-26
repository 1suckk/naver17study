package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1SawonArrayList {
	
	List<Sawon> sawonList = new ArrayList<Sawon>();
	static final String SAWONFILE = "d:/naver17study/mysawon.txt";
	
	public Ex1SawonArrayList() {
		//생성시 파일 불러오기
		try {
			this.sawonFileRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("읽기 오류 발생");
		}
	}
	
	public void sawonFileRead() throws IOException {
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
	
	//파일 저장 -> 그래야 끝나도 영속적으로 파일에 저장됨
	public void sawonFileSave() {
		//사원 리스트의 정보를 파일에 저장하자
		FileWriter fw = null;
		try {
			fw = new FileWriter(SAWONFILE);
			
			//사원의 네 가지 인적정보를 파일에 정보
			for (Sawon sawon:sawonList)
			{
				String s = sawon.getSawonName() + "|" + sawon.getAge() +
						"|" + sawon.getHp() + "|" + sawon.getAddress() +
						"\n";
				//파일에 추가
				fw.write(s);
			}
			
		} catch (IOException e) {
			// 파일에 쓰기를 실패할 경우
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// 파일라이터를 닫음에 실패할 경우
				e.printStackTrace();
			}
		}
	}
	
	//사원 추가
	public void addSawon(Sawon sawon) {
		sawonList.add(sawon);
		System.out.println(sawon.getSawonName() + "님의 정보를 추가");
	}
	
	//이름입력시 인덱스반환
	public int getSearchName(String name) {
		for (int i = 0; i < sawonList.size(); i++) {
	        if (sawonList.get(i).getSawonName().equals(name)) {
	            return i;
	        }
	    }
		//조회에서 실패하면 -1 리턴
	    return -1;
	}
	
	//사원삭제
	public void deleteSawon(String name) {
		int index = getSearchName(name);
		if (index != -1) {
			Sawon removedSawon = sawonList.remove(index);
			System.out.println(removedSawon.getSawonName() + " 사원이 삭제");
		}
		else {
			System.out.println(name + " 사원 조회 불가");
		}
	}
	
	//사원 검색
	public void searchSawon(String name) {
		int index = getSearchName(name);
		if(index == -1) {
			System.out.println(name + " 님은 사원명단에 없습니다.");
		}
		else {
			//get()을 통해서 sawon 객체에 리스트에 포함된 이름을 할당한다
			Sawon sawon = sawonList.get(index);
			System.out.println("** " + name + "님의 개인정보 **");
			System.out.println("나이: " + sawon.getAge());
			System.out.println("핸드폰: " + sawon.getHp());
			System.out.println("주 소: " + sawon.getAddress());
		}
	}
	
	//사원목록 출력
	public void writeSawonList() {
		System.out.println("\t\t[전체 사원 정보]\n");
		System.out.println("번호\t사원명\t나이\t핸드폰\t\t주소");
		System.out.println("=".repeat(60));
		
		int n = 0;
		for (Sawon s:sawonList)
		{
			System.out.println(++n + "\t" + s.getSawonName() +
					"\t" + s.getAge() + "\t" + s.getHp() + "\t\t" +
					s.getAddress());
		}
	}
	
	public static void main(String[] args) {
		// 공통적으로 사용할 객체 선언
		Ex1SawonArrayList ex1 = new Ex1SawonArrayList();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		while(true)
		{
			System.out.println("***사원관리 메뉴***");
			System.out.println("1.사원정보추가");
			System.out.println("2.사원정보검색");
			System.out.println("3.사원삭제");
			System.out.println("4.전체사원출력");
			System.out.println("5.저장후종료");
			System.out.println("번호를 선택하세요");
			
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				// 잘못 입력하면(1 ~ 5 이외의 값) 4번 전체출력으로 가도록 설정
				menu = 4;
			}
			
			//break 생략 가능
			switch(menu)
			{
			case 1 -> {
				//사원추가
				System.out.println("사원명은?");
				String name =sc.nextLine();
				System.out.println("나이는?");
				int age =Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰은?");
				String hp =sc.nextLine();
				System.out.println("주소는?");
				String addr =sc.nextLine();
				
				Sawon sawon = new Sawon(name, age, hp, addr);
				ex1.addSawon(sawon);
			}
			case 2 -> {
				//사원정보검색
				System.out.println("정보를 조회할 사원의 이름을 입력하세요:");
				String nameToSearch = sc.nextLine();
				ex1.searchSawon(nameToSearch);
			}
			case 3 -> {
				//사원삭제
				System.out.println("삭제할 사원의 이름을 입력하세요:");
				String nameToDelete = sc.nextLine();
			    ex1.deleteSawon(nameToDelete);
			}
			case 4 -> {
				//사원정보출력
				ex1.writeSawonList();
			}
			default -> {
				ex1.sawonFileSave();
				System.out.println("사원정보를 파일에 저장후 종료합니다.");
				System.exit(0);
			}
			}
			
			System.out.println("-".repeat(60));
		}
	}
}