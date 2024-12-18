package day1218;

class Car {
	static String carCompany = "Toyota";
	
	private String carName;
	private int carPrice;
	
	//setter method
	public static void setCarCompany(String carCompany) {
		//static 메서드에서는 static 변수만이 접근가능
		Car.carCompany = carCompany;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public void setCarprice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	//getter method
	public String getCarName() {
		return carName; //this는 생략가능
	}
	
	public int getCarPrice() {
		return carPrice;
	}
	
	public void setData(String carName, int carPrice) {
		this.setCarName(carName);
		this.setCarprice(carPrice);
	}
}

public class Ex9Object {
	
	//외부 클래스를 그대로 받아오려면 함수 앞에 static을 붙여야 한다
	public static void writeCarInfo(Car myCar) {
		System.out.println("자동차명=" + myCar.getCarName());
		System.out.println("가격=" + myCar.getCarPrice());
		System.out.println("=".repeat(30));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("기존 회사명 = " + Car.carCompany);
		Car.setCarCompany("Honda");
		System.out.println("변경된 회사명 = " + Car.carCompany);
		
		Car car1 = new Car();
		car1.setCarName("Camry");
		car1.setCarprice(8900);
		
		Car car2 = new Car();
		car2.setData("guabang", 7600);
		
		Car car3 = new Car();
		car2.setData("K9", 9000);
		
		System.out.println("car1 자동차명=" + car1.getCarName());
		System.out.println("Car1 가격=" + car1.getCarPrice());
		
		System.out.println("car2 자동차명=" + car2.getCarName());
		System.out.println("Car2 가격=" + car2.getCarPrice());
	
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
	}

}
