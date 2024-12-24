package day1223;

interface Tire
{
	public void roll();
}

class HankookTire implements Tire {
	@Override
	public void roll() {
		System.out.println("한국 타이어가 회전합니다.");
	}
}

class KumhoTire implements Tire {
	@Override
	public void roll() {
		System.out.println("금호 타이어가 회전합니다.");
	}
}

class Car {	
	public void run(Tire tire) {
		tire.roll();
	}
}

public class Book318 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		KumhoTire kumhoTire = new KumhoTire();
		myCar.run(kumhoTire);
		
		HankookTire hankookTire = new HankookTire();
		myCar.run(hankookTire);
	}
}