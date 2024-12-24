package day1223;
/*
 * public class는 소스 코드 내에서 하나만 존재한다
 */
//class Vehicle
//{
//	public void run()
//	{
//		System.out.println("차량이 달립니다.");
//	}
//}

//abstract 클래스에는 일반메서드도 올 수 잇고, 추상메서드도 올 수 있다.
//이 예제에서는 인터페이스로 할 수도 있다.
interface Vehicle
{
	public void run();
}

//class Bus extends Vehicle {
class Bus implements Vehicle
{
	@Override
	public void run()
	{
		System.out.println("버스가 달립니다.");
	}
}

class Taxi implements Vehicle 
{
	@Override
	public void run()
	{
		System.out.println("택시가 달립니다.");
	}
}

class Driver
{
	// 매개변수 다형성
	public void drive(Vehicle vehicle) 
	{
		vehicle.run();
	}
}

public class Book322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		driver.drive(bus); //매개변수가 Vehicle이 아닌 자식 객체인 Bus bus
		
		Taxi taxi = new Taxi();
		driver.drive(taxi);
	}
}