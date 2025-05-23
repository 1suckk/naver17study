package day1220;

interface InterB
{
	int SPEED = 100; //final 상수; 굳이 final 을 붙일 필요 없음
	
	public void speedWrite();
	public void speedUp(int speed);
	public void speedDown(int speed);
}

class Car implements InterB
{
	int curSpeed = SPEED;
	
	@Override
	public void speedWrite() {
		// TODO Auto-generated method stub
		System.out.println("현재 스피드는 " + curSpeed);
	}

	@Override
	public void speedUp(int speed) {
		// TODO Auto-generated method stub
		curSpeed += speed;
		System.out.println("스피드를 " + speed +"만큼 올립니다.");
		System.out.println("현재 스피드는 " + curSpeed);
	}

	@Override
	public void speedDown(int speed) {
		// TODO Auto-generated method stub
		curSpeed -= speed;
		System.out.println("스피드를 " + speed +"만큼 내립니다.");
		System.out.println("현재 스피드는 " + curSpeed);
	}
	
}

public class Ex10Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	InterB interB = new Car();
	interB.speedWrite();
	interB.speedUp(10);
	interB.speedUp(20);
	}

}
