package day1223;

class Tire {
	public void roll() {
		System.out.println("회전합니다.");
	}
}

class HankookTire extends Tire {
	@Override
	public void roll() {
		System.out.println("한국 타이어가 회전합니다.");
	}
}

class kumhoTire extends Tire {
	@Override
	public void roll() {
		System.out.println("금호 타이어가 회전합니다.");
	}
}

class Car {
	public Tire tire;
	
	public void run() {
		tire.roll();
	}
}

public class Book318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		myCar.tire = new Tire();
		myCar.run();
		
		myCar.tire = new HankookTire();
		myCar.run();
		
		myCar.tire = new kumhoTire();
		myCar.run();
	}

}
