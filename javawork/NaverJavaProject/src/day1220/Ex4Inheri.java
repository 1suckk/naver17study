package day1220;

import day1220_2.Apple;

////////////////////////////////////////////
class Orange extends Apple
{
	public void play()
	{
		this.job(); //public
		this.study(); //protected
//		this.draw(); //오류발생, 패키지가 다를 경우 상속관계라도 protected가 아니면 접근불가
		this.process();
	}
	
	@Override
	protected void process() { //private, default 오류 발생 || public 오류 X
		super.process();
		System.out.println("oracle, mysql 공부");
	}
}
////////////////////////////////////////////
public class Ex4Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange or = new Orange();
		or.play();
		or.process();
		
	}

}
