package shop.controller;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@RestController
//포워드 없다
public class ShopRepleController {
	//서비스 연결
	@Autowired
	ShopRepleService repleService;
	@Autowired
	NcpObjectStorageService storageService;
	
	//NCP 버킷 이름
	private String bucketName="bitcamp-bucket-140";
	
	//1.댓글 추가
	@PostMapping("/shop/addreple")
	public void insertReple(HttpServletRequest request,
							@RequestParam int num,
							@RequestParam String message,
							@RequestParam("upload") MultipartFile upload)
	{
		System.out.println(upload.getOriginalFilename()+","+message);
		
		//네이버 스토리지에 사진 업로드
		String uploadFilename = storageService.uploadFile(bucketName, "shop", upload);
		
		//dto 생성
		ShopRepleDto dto = new ShopRepleDto();
		
		dto.setNum(num);
		dto.setMessage(message);
		dto.setPhoto(uploadFilename);
		
		//db insert
		repleService.insertShopReple(dto);
	}
	
	//2.댓글 조회
	@GetMapping("/shop/replelist")
	public List<ShopRepleDto> repleList(@RequestParam int num)
	{
		List<ShopRepleDto> list = null;
		list = repleService.getRepleByNum(num);
		return list;
	}
	
	//2.댓글 삭제
	@GetMapping("/shop/repledel")
	public void repleDelete(@RequestParam int idx, HttpServletRequest request)
	{
	 	String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
	 	//삭제할 사진명
	 	String photo = repleService.getPhoto(idx);
	 	//사진 삭제
	 	File file = new File(uploadFolder+"/"+photo);
	 	if(file.exists())
	 		file.delete();
	 	repleService.deleteShopReple(idx);
	}
	
	@GetMapping("/shop/likes")
	public Map<String, Integer> getLikes(@RequestParam int idx)
	{
		//like 1 추가
		repleService.updateLikes(idx);
		//최종 likes 받기
		int likes = repleService.getLikes(idx);
		//Map
		Map<String, Integer> map = new HashMap<>();
		map.put("likes", likes);
		return map;
	}
}
