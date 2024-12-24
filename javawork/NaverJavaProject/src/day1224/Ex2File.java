package day1224;

import java.io.File;

public class Ex2File {
	public static void main(String[] args) {
		File file1 = new File("c:/Users/cwsgc/score.txt");
		File file2 = new File("c:/Users/cwsgc");
		
		System.out.println("파일의 크기");
		System.out.println(file1.length() + "바이트, 즉 " + file1.length() * 8 + "비트이다.");
		System.out.println("=".repeat(30));
		
		System.out.println("파일을 읽고쓰고 실행할 수 있는가? rwx");
		System.out.println("file1을 실행할 수 있는가?" + file1.canExecute());
		System.out.println("file1을 읽을 수 있는가?" + file1.canRead());
		System.out.println("file1을 쓸 수 있는가?" + file1.canWrite());
		System.out.println("=".repeat(30));
		
		System.out.println("file1이 파일인가 디렉토리인가");
		System.out.println("file1은 존재하는가?" + file1.exists());
		System.out.println("file1은 디렉토리인가?" + file1.isDirectory());
		System.out.println("file2는 디렉토리인가?" + file2.isDirectory());
		System.out.println("file1은 파일인가?" + file1.isFile());
		System.out.println("file2는 파일인가?" + file2.isFile());
		System.out.println("=".repeat(30));
		
		//file1이 디렉토리라면 목록을 출력하라
		if (file1.isDirectory())
		{
			String[] list = file1.list();
			for (String s:list)
				System.out.println(s);
		}
		else
		{
			System.out.println("file1은 파일입니다");
		}
		System.out.println("=".repeat(30));
		//file2가 디렉토리라면 목록을 출력하라
		if (file2.isDirectory())
		{
			System.out.println("파일2 목록");
			String[] list = file2.list();
			int n = 0;
			for (String s:list)
				System.out.println(++n  + ":" + s);
		}
		else
		{
			System.out.println("file2는 파일입니다");
		}
		System.out.println("=".repeat(30));
		System.out.println("절대경로, 이름, 경로를 확인합니다.");
		System.out.println("file1의 절대경로는 " + file1.getAbsolutePath());
		System.out.println("file1의 이름은 " + file1.getName());
		System.out.println("file1의 경로는 " + file1.getPath());
	}
}