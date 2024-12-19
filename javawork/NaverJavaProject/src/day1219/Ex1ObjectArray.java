package day1219;

import java.util.Scanner;

import day1218.Ex10Object;

public class Ex1ObjectArray {
	Student[] stuArray = new Student[3];
	
	private void inputData() {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("inputData");
		for (int i = 0; i<stuArray.length; i++) {
			
			//생성
			stuArray[i] = new Student();
			
			System.out.println("학생이름:");
			String name = sc.nextLine();
			System.out.println("혈액형:");
			String blood = sc.nextLine();
			System.out.println("출생연도:");
			int birthYear = Integer.parseInt(sc.nextLine());
			System.out.println("점수는:");
			int score = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			stuArray[i].setStuName(name);
			stuArray[i].setStuBlood(blood);
			stuArray[i].setStuBirthYear(birthYear);
			stuArray[i].setStuScore(score);
		}
	}
	
	private static void showTitle() {
		//System.out.println("showTitle");
		System.out.println("이름\t혈액형\t나이\t점수\t학점");
		System.out.println("=".repeat(60));
	}
	
	private void writeDataArray() {
		//System.out.println("write");
		for (Student s:stuArray)
		{
			System.out.println(s.getStuName() + "\t" + s.getStuBlood().toUpperCase() + "형" + "\t"
					 + s.getAge() + "\t" + s.getStuScore() + "\t" + s.getScoreGrade());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1ObjectArray ex1 = new Ex1ObjectArray();
		//데이터 입력
		ex1.inputData();
		//제목 출력
		showTitle();
		//데이터 출력
		ex1.writeDataArray();
	}

}
