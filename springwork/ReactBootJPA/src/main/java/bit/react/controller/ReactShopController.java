package bit.react.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.react.data.ShopDto;
import bit.react.data.ShopEntity;
import bit.react.repository.ShopDao;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/react")
public class ReactShopController {
	
	private final ShopDao shopDao;
	private final NcpObjectStorageService storageService;
	
	private String uploadFilename;
	
	//네이버 클라우드 버켓네임
	private String bucketName = "bitcamp-bucket-140";
	//스토리지의 폴더명
	private String folderName = "jpashop";
	
	@PostMapping(value="/addshop")
	public String addShop(@RequestBody ShopDto dto)
	{
		ShopEntity shopEntity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.Price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.color(dto.getColor())
				.photo(dto.getPhoto())
				.build();
		
		//db에 저장
		shopDao.insertShop(shopEntity);
		//업로드한 파일명은 초기화
		uploadFilename=null;
		return "insert OK!";
	}
	
	//사진은 별도로 업로드
	@PostMapping(value="/upload", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadPhoto(@RequestParam("upload") MultipartFile upload)
	{
		System.out.println("업로드한 파일명: "+upload.getOriginalFilename());
		if(uploadFilename!=null)
			storageService.deleteFile(bucketName, folderName, uploadFilename); //이전에 업로드한 사진 지우기
		//네이버 클라우드에 업로드하기
		uploadFilename=storageService.uploadFile(bucketName, bucketName, upload);
		return uploadFilename;
	}
	
	//일부 데이터 조회
	@GetMapping("/detail")
	public ShopEntity getSelectData(@RequestParam("num") int num)
	{
		return shopDao.getData(num);
	}
	
	//전체 리스트 조회
	@GetMapping("/shoplist")
	public List<ShopEntity> selectAll()
	{
		return shopDao.getAllShops();
	}
	
	//삭제
	@DeleteMapping("/shopdelete")
	public String deleteShop(@RequestParam("num") int num)
	{
		//1. 스토리지에서 사진 지우기
		String photoName = shopDao.getData(num).getPhoto();
		storageService.deleteFile(photoName, photoName, photoName);
		
		//2.db 삭제
		shopDao.deleteShop(num);
		return "delete ok!";
	}
	
	@PostMapping("/shopupdate")
	public String updateShop(@RequestParam("dto") ShopDto dto)
	{
		ShopEntity entity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.color(dto.getColor())
				.Price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.num(dto.getNum())
				.photo(dto.getPhoto())
				.build();
		
		shopDao.updateShop(entity);
		uploadFilename=null;
		return "update ok";
	}
}
