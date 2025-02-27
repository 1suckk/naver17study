package day1227;

@FunctionalInterface
interface MySawon
{
	public void sawonAdd(String name);
}

@FunctionalInterface
interface Sales
{
	public void sangpumAdd(String sangpum, int su, int dan);
}

public class Ex3Lambda {
	MySawon sawon1 = (name) -> System.out.println(name + "사원 추가함!!");
	
	Sales sa = (sang, su, dan) -> {
		System.out.println(sang + "상품 등록");
		System.out.println("수량: " + su + "개");
		System.out.println("총금액: " + su*dan + "원");
		System.out.println("=".repeat(20));
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3Lambda ex3 = new Ex3Lambda();
		ex3.sawon1.sawonAdd("홍길동");
		ex3.sawon1.sawonAdd("이영자");
		
		ex3.sa.sangpumAdd("딸기", 5, 9000);
		ex3.sa.sangpumAdd("오렌지", 3, 2000);
	}

}
