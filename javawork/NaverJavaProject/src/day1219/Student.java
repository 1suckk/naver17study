package day1219;

import java.util.Calendar;

public class Student {
	private String stuName;
	private String stuAddr;
	private String stuBlood;
	private int stuBirthYear;
	private int stuScore;
	
	//getter setter 만들어서 Ex1ObjectArray에서 활용이 가능하도록 
	//getter와 setter는 public으로 설정해야
	//stuName
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	//stuAddr
	public String getStuAddr() {
		return stuAddr;
	}
	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}
	//stuBlood
	public String getStuBlood() {
		return stuBlood;
	}
	public void setStuBlood(String stuBlood) {
		this.stuBlood = stuBlood;
	}
	//stuBirthYear
	public int getStuBirthYear() {
		return stuBirthYear;
	}
	public void setStuBirthYear(int stuBirthYear) {
		this.stuBirthYear = stuBirthYear;
	}
	//stuScore
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}
	
	//한꺼번에 변경
	public void changeStudent(String stuName, String stuAddr, String stuBlood) {
		this.setStuName(stuName);
		this.setStuAddr(stuAddr);
		this.setStuBlood(stuBlood);
	}
	
	//학점 부여 로직
	public char getScoreGrade()
	{
		char grade = switch(stuScore/10)
				{
					case 10, 9 -> 'A';
					case 8 -> 'B';
					case 7 -> 'C';
					case 6 -> 'D';
					default-> 'F';
				};
		return grade;
	}
	
	//stuYearBirth로 나이를 구해서 반환
	public int getAge()
	{
		//현재 년도 기준으로 차를 구해서 나이를 구한다
		Calendar cal = Calendar.getInstance();
		int curYear = cal.get(Calendar.YEAR);
		
		//현재 년도 - 출생년도
		return curYear-stuBirthYear;
	}
	
	
}

