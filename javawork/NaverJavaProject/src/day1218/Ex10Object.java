package day1218;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class Ex10Object {

	public static void showTitle() {
		System.out.println("자동차명\t가격");
		System.out.println("=".repeat(30));
	}
	
	public static void writeCar(int num, Car myCar) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(num+"\t"+myCar.getCarName()+"\t"+nf.format(myCar.getCarPrice())+"만원");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체 배열
		Car[] cars = new Car[5];
		
		//Car 객체는 따로 생성해줘야 한다
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
		}
	
		cars[0].setData("그랜져", 5000); //객체는 메모리 할당 시 무조건 초기값이 Null
		cars[1].setData("K3", 4000);
		cars[2].setData("아반떼", 3000);
		cars[3].setData("라보", 2000);
		cars[4].setData("모닝", 1000);
	
		//제목부터 출력
		showTitle();
		for (int i = 0; i < cars.length; i++) {
			writeCar(i+1, cars[i]);
		}
		System.out.println();
	}

}
