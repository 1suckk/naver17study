package day1223;

interface InterA
{
	public void study();
}

//인터페이스끼리의 상속은 extends
interface InterB extends InterA
{
	//study() 도 함께 상속잗았다.
	public void play();
}

class MyInter implements InterB
{
	public void study() {
		System.out.println("그룹 스터디를 합니다.");
	}
	public void play() {
		System.out.println("그룹 모임을 합니다.");
	}
	
	public void job() {
		System.out.println("밀린 일처리를 합니다.");
	}
}

public class Ex1InterfaceInheri {
	public static void main(String[] args) {
		InterA interA = new MyInter();
		interA.study();
		System.out.println("=".repeat(20));
		
		InterB interB = new MyInter();
		interB.play();
		interB.study();
		
		/*
		 * (주의) 다운캐스팅 하는 방법
		 * (MyInter)(interB) X 
		 * (MyInter)interB X
		 * 
		 * 조부가 손자에게 상속하는 것도 가능
		 * ((MyInter) interA)
		 */
		((MyInter)interB).job();
		System.out.println("=".repeat(20));
		
		MyInter my = new MyInter();
		my.study();
		my.play();
		my.job();
	}
}
