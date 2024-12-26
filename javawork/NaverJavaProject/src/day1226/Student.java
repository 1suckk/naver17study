package day1226;

public class Student {
	private String name;
	private int kor;
	private int eng;
	
	public Student() {
		
	}

	public Student(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}	
	
	//총점 부분
	public int getTotal() {
        return this.kor + this.eng;
    }
	
	//평균 부분
    public double getAverage() {
        return this.getTotal() / 2.0;
    }
}
