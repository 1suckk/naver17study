package day1218;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
	
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(sdf1.format(date));	
		
		int num1 = 20000;
		int num2 = 34567;
		
		NumberFormat nf1 = NumberFormat.getInstance();
		System.out.println("num1=" + nf1.format(num1));
		System.out.println("num2=" + nf1.format(num2));
		
		NumberFormat nf2 = NumberFormat.getCurrencyInstance();
		System.out.println("num1= $" + nf1.format(num1));
		System.out.println("num2= $" + nf1.format(num2));
	}

}
