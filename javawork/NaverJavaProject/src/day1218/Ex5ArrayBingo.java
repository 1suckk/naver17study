


package day1218;

import java.util.Scanner;

public class Ex5ArrayBingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] puzzle = new int[3][3];
		int binggo;
		
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				puzzle[i][j] = sc.nextInt();
			}
		}
		
		while (true)
		{
			//행렬 출력 부분
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j< puzzle[i].length; j++) {
					System.out.printf("%3d", puzzle[i][j]);
				}
				System.out.println();
			}
			
			binggo = 0;
			
			//빙고 수 계산 로직
			//같은 행에서 가로로 찾기, 같은 열에서 세로로 찾기, 대각선에서 찾기
			//(0,0)(1,1)(2,2)이거나 (0,2)(1,1)(2,0)의 수가 동일해야 함
			for (int i = 0; i < puzzle.length; i++) {
				
				//가로
				if(puzzle[i][0] == puzzle[i][1] && puzzle[i][1] == puzzle[i][2])
					binggo++;
				
				//세로
				if(puzzle[0][i] == puzzle[1][i] && puzzle[1][i] == puzzle[2][i])
					binggo++;
				
				//대각선
				if(puzzle[0][0] == puzzle[1][1] && puzzle[1][1] == puzzle[2][2])
					binggo++;
				if(puzzle[0][2] == puzzle[1][1] && puzzle[1][1] == puzzle[2][0])
					binggo++;
				
				//출력 부분
				if (binggo == 0)
					System.out.println("\t꽝!!");
				else
					System.out.println("\t\t빙고 " + binggo + "개");
				
				if (sc.nextLine().equals("q"))
					System.out.println("종료");
			} 
		} 
	}
}
