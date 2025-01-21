package test_data;

public class FoodDto {
	private String foodName;
	private String foodPhoto;
	private int foodPrice;
	private String FoodDay;
	private int su;
	
	public FoodDto() {
		
	}

	public FoodDto(String foodName, String foodPhoto, int foodPrice, String foodDay, int su) {
		super();
		this.foodName = foodName;
		this.foodPhoto = foodPhoto;
		this.foodPrice = foodPrice;
		FoodDay = foodDay;
		this.su = su;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodPhoto() {
		return foodPhoto;
	}

	public void setFoodPhoto(String foodPhoto) {
		this.foodPhoto = foodPhoto;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodDay() {
		return FoodDay;
	}

	public void setFoodDay(String foodDay) {
		FoodDay = foodDay;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}
	
	
}
