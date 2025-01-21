package test.day0121;

import java.util.ArrayList;
import java.util.List;

import test_data.FoodDto;

public class FoodDataList {
	
	private List<FoodDto> list = new ArrayList<FoodDto>();
	
	public FoodDataList() {
		list.add(new FoodDto("망고빙수", "11.jpg", 20000, "2025-01-01", 2));
		list.add(new FoodDto("순두부", "12.jpg", 9000, "2025-01-10", 1));
		list.add(new FoodDto("스팸마요덮밥", "10.jpg", 5000, "2025-01-03", 3));
		list.add(new FoodDto("콘치즈", "5.jpg", 6000, "2025-01-08", 2));
		list.add(new FoodDto("수제버거", "8.jpg", 20000, "2025-01-21", 1));
		list.add(new FoodDto("장칼국수", "3.jpg", 9000, "2025-01-11", 4));
	}
	
	public List<FoodDto> getAllDatas()
	{
		return list;
	}
	
	public static void main(String[] args) {
		
	}
}
