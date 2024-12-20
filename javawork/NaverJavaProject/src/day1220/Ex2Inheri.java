package day1220;

class SuperObj2
{
	private String schoolName;
	
	public SuperObj2()
	{
		// TODO Auto-generated constructor stub
		schoolName = "양재고";
	}
	
	SuperObj2(String schoolName)
	{
		this.schoolName = schoolName;
	}
	
	public void write()
	{
		System.out.println("학교명: " + schoolName);
	}
}
////////////////////////////////////////////////////
class SubObj2 extends SuperObj2
{
	private String studentName;
	
	SubObj2()
	{
		studentName = "xxx";
	}
	
	SubObj2(String schoolName, String studentName)
	{
		super(schoolName); //부모 클래스에서 학교명을 받아오는 
		this.studentName = studentName;
	}
	
	@Override //부모의 메서드를 재정의 했다는 의미
	public void write()
	{
		// TODO Auto-generated method stub
		super.write(); //부모가 철한 로직 실행 - 호출 위치는 상관없음
		System.out.println("학생명: " + studentName);
	}
}
////////////////////////////////////////////////////
class SubObj22 extends SuperObj2
{
	private String teacherName;
	
	SubObj22()
	{
		teacherName = "yyy";
	}
	
	SubObj22(String schoolName, String teacherName)
	{
		super(schoolName); //부모 클래스에서 학교명을 받아오는 
		this.teacherName = teacherName;
	}
	
	@Override //부모의 메서드를 재정의 했다는 의미
	public void write()
	{
		// TODO Auto-generated method stub
		System.out.println("교사명: " + teacherName);
		super.write(); //부모가 철한 로직 실행 - 호출 위치는 상관없음
	}
}

////////////////////////////////////////////
public class Ex2Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj2 s1 = new SubObj2();
		SubObj2 s2 = new SubObj2("양재고등학교", "채원석");
		SubObj22 s3 = new SubObj22("양재고등학교", "윤영");
		
		s1.write();
		s2.write();
		s3.write();
	}

}