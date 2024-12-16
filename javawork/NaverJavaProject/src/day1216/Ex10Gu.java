package day1216;

public class Ex10Gu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i <= 9; i++)
			System.out.print(i + "단" + "\t");
		System.out.println();
		System.out.print("=".repeat(65));
		
		for (int i = 1; i <= 9; i++) { 
			System.out.println("");
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + "=" + i*j + "\t");
			}
		}	
	}	
}
