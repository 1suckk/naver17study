

package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@Controller
public class ShopAddController {
	@Autowired
	ShopService shopService;
	
	@Autowired
	NcpObjectStorageService storageService;
	
	//NCP 버킷 이름
	private String bucketName="bitcamp-bucket-140";

	@GetMapping("/shop/addform")
	public String addForm()
	{
		return "shop/addform";
	}
	
	@PostMapping("/shop/insert")
	public String insert(@ModelAttribute ShopDto dto,
							@RequestParam("upload") List<MultipartFile> uploadList)
	{
		String sphoto="";
		
		for(MultipartFile file:uploadList)
		{
			String uploadFilename = storageService.uploadFile(bucketName, "shop", file);
			sphoto+=uploadFilename+",";
		}
		
		//sphoto에서 컴마는 제거
		sphoto = sphoto.substring(0, sphoto.length() - 1);
		//dto에 저장
		dto.setSphoto(sphoto);
		
		//db insert
		shopService.insertShop(dto);
		
		//글의 상세보기 페이지로 바로 이동
		return "redirect:./detail?num="+dto.getNum();
	}
}
