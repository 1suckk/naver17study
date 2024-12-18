package day1218;

import java.util.Scanner;

public class Ex3Array2Cha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 행과 열을 할당한다 == 열 갯수는 행마다 다를 수 있다
		int[][] arr1 = new int[2][3]; 
		
		arr1[0] = new int[3];
		arr1[1] = new int[4];
				
		System.out.println("행의 갯수: " + arr1.length);
		System.out.println("0번 행의 갯수: " + arr1[0].length);
		System.out.println("1번 행의 갯수: " + arr1[1].length);
		
		arr1[0][0] = 100; 
		arr1[0][1] = 90;
		arr1[0][2] = 95;		
				
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.printf("%d, %d: %d\t", i, j, arr1[i][j]);
			}
			System.out.println();
		}
	}

}
