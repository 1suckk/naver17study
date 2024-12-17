package day1217;

public class Ex3Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1;
		arr1  =new int[5];
		arr1[0] = 23;
		arr1[3] = 50;
		for (int i = 0; i < arr1.length; i++)
			System.out.println("arr[" + i + "] = " + arr1[i]);
		System.out.println();
		
		int[] arr2 = new int[5];
		arr2 = new int[] {1, 1, 1, 1, 1};
		for (int i = 0; i < arr2.length; i++)
			System.out.println("arr[" + i + "] = " + arr2[i]);
		System.out.println();
		
		int[] arr3 = {100, 100, 100, 100, 100};
		for (int i = 0; i < arr3.length; i++)
			System.out.println("arr[" + i + "] = " + arr3[i]);
	}

}
