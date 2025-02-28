package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import data.dto.ShopDto;
import data.service.ShopRepleService;
import data.service.ShopService;
import naver.storage.NcpObjectStorageService;

@Controller
public class ShopListController {
	@Autowired
	ShopService shopService;
	@Autowired
	ShopRepleService repleService;
	@Autowired
	NcpObjectStorageService storageService;
	
	//버켓 이름
	private String bucketName = "bitcamp-bucket-140";
	
	@GetMapping("/shop/list")
	public String shopList(Model model)
	{
		//총 상품 갯수
		int totalCount = shopService.getTotalCount();
		//전체 상품
		List<ShopDto> list = shopService.getAllSangpum();
		//메인 사진 등록
		for(int i=0; i<list.size();i++)
		{
			ShopDto dto = list.get(i);
			String mainPhoto = dto.getSphoto().split(",")[0];
			dto.setMainPhoto(mainPhoto);
			
			//댓글수 저장
			int replecount = repleService.getRepleByNum(dto.getNum()).size();
		}
		//모델에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("fronturl", "https://jhmafcod8738.edge.naverncp.com/mBHgqdbMYT");
		model.addAttribute("backurl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
		//포워드
		return "shop/shoplist";
	}
}
