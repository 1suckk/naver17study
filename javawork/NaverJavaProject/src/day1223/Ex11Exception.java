package day1223;

import java.io.FileWriter;
import java.io.IOException;

public class Ex11Exception {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * 일단 Exception은 선택이 아니라 필수로 처리해야 한다
		 * 메서드 자체가 throw로 던지는 Exception 처리하면 된다
		 * 
		 */
		
		System.out.println("3초만 기다리세요");
		try {
		Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("오래 기다리셨어요");
		
		//파일에 이름과 주소를 저장해보자
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:/Users/cwsgc/hello.txt");
			fw.write("이름: 이영자\n");
			fw.write("주소: 서초구\n");
			fw.write("==========\n");
			System.out.println("탐색기로 파일을 확인하세요.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fw.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("정상 종료");
	}
}