package day1223;
/*
 * jdk8 에서 추가된 기능
 * 디폴트 인스턴스 메서드를 통해서 기능 구현이 가능하다
 */
interface RemoteControl
{
	//상수 선언
	int MAX_VOLUMN = 10;
	int MIN_VOLUMN = 0;
	
	//추상 메서드
	public void turnOn();
	public void turnOff();
	public void setVolumn(int volumn);
	
	//인터페이스에서는 디폴트로 구현
	default void setMode(boolean mute)
	{
		if (mute)
		{
			System.out.println("무음 처리");
			setVolumn(MIN_VOLUMN);
		}
		else
		{
			System.out.println("무음 해제");
		}
	}

}

class Television implements RemoteControl
{
	int volumn;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV 작동");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV 전원 해제");
	}

	@Override
	public void setVolumn(int volumn) {
		// TODO Auto-generated method stub
		this.volumn = volumn;
		System.out.println("현재 볼륨은 " + this.volumn + "입니다.");
	}
	
}

public class Ex5DefaultInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc1 = null;
		//rc1.setMute(false); //nullPointerException 발생
		rc1 = new Television();
		rc1.turnOn();
		rc1.turnOff();
		rc1.setMode(false);
		rc1.setMode(true);
	}

}