package day1219;

public class Sawon {
	/*
	 * 멤버변수 사원명 saWonName, 직급 position, 가족수 famSu
	 */
	String sawonName;
	String position;
	int famSu;
	
	
	/*
	 * 1. 디폴트 생성자
	 * 2. 사원명, 직급, 가족수당을 인자로 받는 생성자 
	 */
	public Sawon() 
	{
		System.out.println();
	}
	
	public Sawon(String sawonName, String position, int famSu)
	{
		this.sawonName = sawonName;
		this.position = position;
		this.famSu = famSu;
	}
	
	/* setter & getter 전부 만들어*/
	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamSu() {
		return famSu;
	}

	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	
	public void changeSawon(String sawonName, String position, int famSu) {
		this.setSawonName(sawonName);
		this.setPosition(position);
		this.setFamSu(famSu);
	}
	
	/*
	 * 직급에 따라 기본급을 구하는데 부장 450 과장 300 대리 250 사원 150
	 * getGibonPay()
	 */
	int getGibonPay() {
		 if (this.position == null) 
		        return 0; 
		 
	    switch(this.position) {
	        case "부장": return 450;
	        case "과장": return 300;
	        case "대리": return 250;
	        case "사원": return 150;
	        default: return 0;
	    }
	}

	
	/*
	 * switch 직급에 따라 수당 구하는데 부/과장 70 대리 사원 50
	 * getSudang()
	 */
	int getSudang() {
		if (this.position == null)
			return 0;
		
	    switch(this.position) {
	        case "부장":
	        case "과장": return 70;
	        case "대리":
	        case "사원": return 50;
	        default: return 0;
	    }
	}

	
	/*
	 * getGibonPay() 값을 반환받아서 세금 5프로를 구해서 반환하는 getTax()
	 */
	double getTax() {
	    return 0.05 * (getGibonPay() + getSudang());
	}


	/*
	 * 가족수당이 5인 이상이면 30 반환 
	 * 5인 미만 2인 이상은 10 반환
	 * 나머지는 0
	 * getFamSudang()
	 */
	int getFamSudang(int famSu) {
		int FamSudang = 0;
		
		if (famSu >= 5)
			FamSudang = 30;
		else if (2 <= famSu && famSu < 5) 
			FamSudang = 10;
		else
			FamSudang = 0;
		
		return FamSudang;
	}	
	
	/*
	 * 실수령액을 구해서 반환
	 * 기본급 + 수당 - 세금 + 가족수당 반환
	 * getNetpay()
	 */
	int getNetpay() {
	    return getGibonPay() + getSudang() - (int)getTax() + getFamSudang(this.famSu);
	}


}
