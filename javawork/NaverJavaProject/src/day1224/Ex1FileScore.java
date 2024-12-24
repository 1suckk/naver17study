package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileScore {
	public static void scoreRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		int count = 0, sum = 0;
		double avg;
		try {
			fr = new FileReader("c:/Users/cwsgc/score.txt");
			System.out.println("파일존재함");
			br = new BufferedReader(fr); //br 말고도 fr 쓸수 있음 다형성의 원리
			
			while(true) 
			{
				//파일에서 한 줄씩 읽기
				String s = br.readLine();
				//null일 경우 갯수에도 포함안되고 while문을 빠져나간다
				if (s ==  null) 
					break;
				try {
					int score = Integer.parseInt(s);
					
					count++;
					sum += score;
					System.out.println(count+"=>"+score+"점");
				} catch (NumberFormatException e) {
					System.out.println("\t문자가 포함됨");
				}
			}
			
			//평균
			avg = (double)sum/count;
			System.out.println("점수개수:" + count);
			System.out.println("총점: " + sum);
			System.out.println("평균: " + avg);
			
		} catch (FileNotFoundException e) {
			System.out.println("존재하지 않음" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scoreRead();
		System.out.println("정상 종료");
	}
}
