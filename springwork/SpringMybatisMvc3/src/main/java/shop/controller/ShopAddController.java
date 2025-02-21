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

@Controller
public class ShopAddController {
	@Autowired
	ShopService shopService;

	@GetMapping("/shop/addform")
	public String addForm()
	{
		return "shop/addform";
	}
	
	@PostMapping("/shop/insert")
	public String insert(HttpServletRequest request,
							@ModelAttribute ShopDto dto,
							@RequestParam("upload") List<MultipartFile> uploadList)
	{
		//업로드할 경로 구하기
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		
		//dto에 저장할 변수명
		String sphoto="";
		for(MultipartFile upload:uploadList)
		{
			//파일명을 랜덤값.확장자 형식으로 만들기
			String uploadFilename = UUID.randomUUID()+"."+(upload.getOriginalFilename().split("\\.")[1]);
			sphoto+=uploadFilename+",";
			
			//업로드
			try
			{
				upload.transferTo(new File(uploadFolder+"/"+uploadFilename));
			}
			catch (IllegalStateException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//sphoto에서 컴마는 제거
		sphoto = sphoto.substring(0, sphoto.length() - 1);
		//dto에 저장
		dto.setSphoto(sphoto);
		//db insert
		shopService.insertShop(dto);
		
		//insert 후 num 값을 얻는 sql문 추가 후 상세보기 페이지로 이동할 수 있다
		System.out.println("num="+dto.getNum());
		
		//글의 상세보기 페이지로 바로 이동
		return "redirect:./detail?num="+dto.getNum();
	}
}
