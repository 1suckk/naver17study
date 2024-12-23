package day1223;

abstract class AbstEx
{
	abstract public void show();
}

interface MyDB
{
	public void list();
	public void insert();
}

//익명 내부 클래스로 하지 않는다면 아래와 같이 하면 된다
class SubMyDB implements MyDB 
{
	@Override
	public void list()
	{
		// TODO Auto-generated method stub
		System.out.println("목록출력 2");
	}
	
	@Override
	public void insert()
	{
		// TODO Auto-generated method stub
		System.out.println("추가 2");
	}
}

public class Ex3InnerClass
{
	//익명 내부 클래스 형태로 구현
	AbstEx abst1 = new AbstEx()
	{		
		@Override
		public void show()
		{
			// TODO Auto-generated method stub
			System.out.println("show 호출");
		}
	};
	
	MyDB myDB = new MyDB()
	{
		
		@Override
		public void list()
		{
			// TODO Auto-generated method stub
			System.out.print("DB 목록을 출력");
		}
		
		@Override
		public void insert()
		{
			// TODO Auto-generated method stub
			System.out.println("DB 목록을 추가");
		}
	};

	MyDB myDB2 = new SubMyDB();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3InnerClass ex3 = new Ex3InnerClass();
		ex3.abst1.show();
		System.out.println();
		ex3.myDB.insert();
		ex3.myDB.list();
		System.out.println();
		ex3.myDB2.insert();
		ex3.myDB2.list();
	}
}