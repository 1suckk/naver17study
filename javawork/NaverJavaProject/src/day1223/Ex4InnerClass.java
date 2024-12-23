package day1223;

abstract class AbstSawon
{
	abstract public void addSawon();
	abstract public void removeSawon();
}

interface Intersales 
{
	public void insertSangpum();
	public void selectSangpum();
}

public class Ex4InnerClass {
	
	Intersales sales = new Intersales() {
		
		@Override
		public void selectSangpum() {
			// TODO Auto-generated method stub
			System.out.println("상품을 목록에서 선택");
		}
		
		@Override
		public void insertSangpum() {
			// TODO Auto-generated method stub
			System.out.println("상품을 목록에 추가");
		}
	};
	
	AbstSawon sawon = new AbstSawon() {
		
		@Override
		public void removeSawon() {
			// TODO Auto-generated method stub
			System.out.println("사원을 목록에서 제거");
		}
		
		@Override
		public void addSawon() {
			// TODO Auto-generated method stub
			System.out.println("사원을 목록에 추가");
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4InnerClass ex4 = new Ex4InnerClass();
		ex4.sawon.addSawon();
		ex4.sawon.removeSawon();
		System.out.println();
		ex4.sales.insertSangpum();
		ex4.sales.selectSangpum();
	}
}