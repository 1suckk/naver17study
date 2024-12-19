package day1219;

import java.util.Scanner;

public class Ex12SawonArray {
	
	public static void dataInput(Sawon s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사원명: ");
		String name = sc.nextLine();
		System.out.println("직급: ");
		String position = sc.nextLine();
		while (position.trim().isEmpty()) {
	        System.out.print("직급을 반드시 입력해야 합니다. 다시 입력하세요: ");
	        position = sc.nextLine();
	    }
		System.out.println("가족수: ");
		int famSu = Integer.parseInt(sc.nextLine());
	
		s.changeSawon(name, position, famSu);
		System.out.println();
	}
	
	/*
	 * showTitle 제목 출력 사원명 직급 기본급 수당 가족수당 세금 실수령액
	 */
	public static void showInfo() {
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
	}
	
	/*
	 * writeSawon(Sawon sawon) 한 개의 사원 데이터 출력
	 */
	public static void writeSawon(Sawon sawon) {
	    System.out.printf("%s\t%s\t%d\t%d\t%d\t%.2f\t%d\n",
	        sawon.getSawonName(),
	        sawon.getPosition(),
	        sawon.getGibonPay(),
	        sawon.getSudang(),
	        sawon.getFamSudang(sawon.getFamSu()),
	        sawon.getTax(),
	        sawon.getNetpay());
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inwon;
		Sawon[] mySawon;
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 인원수를 구한 뒤 인원수만큼 배열 메모리 할당
		 */
		System.out.print("사원의 인원은 몇명입니까: ");
		inwon = Integer.parseInt(sc.nextLine());
		mySawon = new Sawon[inwon];
		
		/* 
		 * 배열에 데이터 입력 후 생성 자동해서 데이타 저장하기 
		 */
		for (int i = 0; i < mySawon.length; i++) {
			mySawon[i] = new Sawon();
			dataInput(mySawon[i]);
		}
				
		/*
		 * 제목 출력
		 */
		showInfo();

		/*
		 * 반복문 통해서 데이터 출력하는 메서드 호출
		 */
		for (int i=0; i < mySawon.length; i++)
			writeSawon(mySawon[i]);
	}

}
