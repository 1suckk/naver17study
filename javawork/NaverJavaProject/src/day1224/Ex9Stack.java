package day1224;
/*
 * 스택은 Last In First Out
 * push(), pop() 이용
 */
import java.util.Stack;

public class Ex9Stack {
	public static void main(String[] args) {
		Stack<String> stack1 = new Stack<String>();
		
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("사과");
		stack1.push("키위");
		stack1.push("딸기");
		
		System.out.println("stack의 갯수: " + stack1.size());
	
		while (!stack1.isEmpty())
		{
			System.out.println(stack1.pop());
		}
	}
}