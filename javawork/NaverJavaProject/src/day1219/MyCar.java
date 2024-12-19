package day1219;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCar {
	private String carName;
	private int carPrice;
	private String guipDay;
	private String carColor;
	
	//디폴트 생성자
	public MyCar() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy=MM-dd HH:mm");
		guipDay = sdf.format(new Date());
		
		carColor = "흰색";
	}
	
	public MyCar(String carName, int carPrice, String carColor) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy=MM-dd HH:mm");
		guipDay = sdf.format(new Date());
		
		this.carName = carName;
		this.carPrice = carPrice;
		this.carColor = carColor;
	}

	@Override
	public String toString() {
		return "MyCar [carName=" + carName + ", carPrice=" + carPrice +
				", \n\tguipDay=" + guipDay + ", carColor="
				+ carColor + "]";
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getGuipDay() {
		return guipDay;
	}

	public void setGuipDay(String guipDay) {
		this.guipDay = guipDay;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	
	
}
