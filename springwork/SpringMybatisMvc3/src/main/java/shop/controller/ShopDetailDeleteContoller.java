package shop.controller;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopDetailDeleteContoller {
	@Autowired
	ShopService shopService;
	
	//세부 페이지 컨트롤러
	@GetMapping("/shop/detail")
	public String detail(@RequestParam int num, Model model)
	{
		ShopDto dto = shopService.getDetail(num);
		String mainPhoto = dto.getSphoto().split(",")[0];
		dto.setMainPhoto(mainPhoto);
		
		model.addAttribute("dto", dto);
		return "shop/detail";
	}
	
	//삭제 기능 컨트롤러
	@GetMapping("/shop/delete")
	public String delete(HttpServletRequest request,
							@RequestParam int num)
	{
		//배포된 프로젝트의 save 위치 구하기
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		//삭제전에 사진명들을 얻어야한다
		String photos = shopService.getDetail(num).getSphoto();
		//,로 분리
		String[] photo = photos.split(",");
		
		//실제 경로에서 파일을 찾아서 삭제
		for (String f:photo)
		{
			File file = new File(uploadFolder + "." + f);
			//save 폴더에 파일이 존재할 경우
			if(file.exists())
				file.delete();
		}
		
		//db 데이터도 함께 삭제
		shopService.deleteShop(num);
		
		return "redirect:./list";
	}
	
	@GetMapping("/shop/photos")
	public String shopPhotos(@RequestParam int num, Model model)
	{
		//num에 해당하는 사진 얻기
		String sphoto = shopService.getDetail(num).getSphoto();
		model.addAttribute("sphoto", sphoto);
		model.addAttribute("num", num);
		return "shop/photos";
	}
	
	@GetMapping("/shop/delphoto")
	@ResponseBody
	public void delePhoto(@RequestParam int num, @RequestParam String pname)
	{
		//num에 해당하는 sphoto를 db에서 얻는다
		String sphoto = shopService.getDetail(num).getSphoto();
		//sphoto에서 pname 부분을 삭제하는데 중간일 경우 뒤에 컴마도 삭제
		String changephoto = "";
		//마지막 사진이면 컴마 안주고 끝내기
		//마지막 사진이 아니면 파일 이름 뒤에 컴마 주고
		if(sphoto.endsWith(pname))
			changephoto = sphoto.replace(pname, "");
		else
			changephoto = sphoto.replace(pname+",", "");
		//그 변경된 changephoto를 updatePhoto를 통해서 보낸다
		shopService.updatePhoto(num, changephoto);
	}
	
	@PostMapping("/shop/addphoto")
	@ResponseBody
	public void addPhoto(@RequestParam int num,
							@RequestParam("upload") List<MultipartFile> uploadList,
							HttpServletRequest request)
	{
		//처음이면 컴마 넣지 말고 파일명 넣고 컴마 찍기
		//컴마 넣고 다음 파일명을 추가
		
		//업로드 경로 구하기
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		//새로 업로드할 파일면 구할 변수
		String photos = "";
		for(MultipartFile f:uploadList)
		{
			//업로드할 파일명
			String uploadFileName = UUID.randomUUID()+"."+f.getOriginalFilename().split("\\.")[1];
			photos+=uploadFileName+",";
			//업로드
			try {
				f.transferTo(new File(uploadFolder+"/"+uploadFileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//마지막 컴마 제거
		photos = photos.substring(0, photos.length() - 1);
		//db 에서의 sphoto 값 얻기
		String sphoto = shopService.getDetail(num).getSphoto();
		//sphoto 가 값이 없을 경우(if절) photos를 대입하고 이미 있을 경우(else절) ,를 추가 후 photos 추가
		if(sphoto.length()==0)
			sphoto=photos;
		else
			sphoto=sphoto+","+photos;
		//db에서 sphoto 수정
		shopService.updatePhoto(num, sphoto);
	}
}
