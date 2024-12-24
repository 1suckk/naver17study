package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

//파일 경로는 각자의 H/W에 맞게 조정
public class Ex4FileReadWrite {
	static final String FILENAME = "c:/Users/cwsgc/hello.txt";
	
	public static void fileRead() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			System.out.println("\t전체 멤버 명단");
			System.out.println();
			System.out.println("번호\t이름\t나이\t주거지");
			System.out.println("=".repeat(30));
			
			int n = 0;
			while (true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				String[] m =line.split(",");
				System.out.println(++n + "\t" + m[0] + "\t"
				+ m[1] + "세\t" + m[2]);
			}
			System.out.println(); //개행
			
		}catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		} finally {
			if (br != null) br.close();
			if (fr!=null) fr.close();
		}
	}
	
	public static void fileSave() throws IOException
	{
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		String name, age, addr;
		
		System.out.println("추가할 이음은?");
		name = sc.nextLine();
		System.out.println("추가할 나이는?");
		age = sc.nextLine();
		System.out.println("추가할 주거지는?");
		addr = sc.nextLine();
		
		fw = new FileWriter(FILENAME, true); //추가 모드로 생성
		
		if(fw!=null) fw.close();
		System.out.println();
	}
	
	public static void fileDelete()
	{
		File file = new File(FILENAME);
		if(file.exists())
		{
			System.out.println("파일을 삭제합니다.");
			if (file.delete())
			{
				System.out.println("성공적 삭제");
			}
			else
			{
				System.out.println("삭제에 실패");
				// 재시도 로직
                for (int i = 0; i < 3; i++)
                {
                    try
                    {
                        Thread.sleep(1000); // 1초 대기
                        if (file.delete())
                        {
                            System.out.println("재시도 후 파일이 삭제되었습니다.");
                            return;
                        }
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("여러 번의 시도 후에도 파일 삭제에 실패했습니다.");
			}
		}
		else
		{
			System.out.println("삭제할 파일이 없습니다.");
		}
		System.out.println();
	}
	
	public static int getMenu()
	{
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.멤버추가  2.전체출력  3.정체멤버삭제  4.종료");
		try
		{
			menu = Integer.parseInt(sc.nextLine());
		}
		catch (NumberFormatException e)
		{
			menu = 2; //메뉴에 문자 입력 시 전체출력으로 설정
		}
		return menu;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		while(true)
		{
			switch (getMenu())
			{
				case 1 -> fileSave(); //->쓰면 브레이크문 추가하지 않아도 된다
				case 2 -> fileRead();
				case 3 -> fileDelete();
				default -> {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0); //시스템 정상 종료
				}
			}
		}
	}
}