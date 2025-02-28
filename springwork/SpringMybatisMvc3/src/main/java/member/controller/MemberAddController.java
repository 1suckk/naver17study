package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@Controller
@RequestMapping("/member")
public class MemberAddController {
	
	@Autowired
	MemberService memberService;
	
	//NCP 버킷 이름
	private String bucketName="bitcamp-bucket-140";
	
	@Autowired
	NcpObjectStorageService storageService;
	
	@GetMapping("/form")
	public String form()
	{
		return "member/memberform";
	}
	
	//아이디가 존재하면 result에 fail을, 존재하지 않으면 success를 보내기
	@GetMapping("/idcheck")
	@ResponseBody
	public Map<String, String> idCheck(@RequestParam String myid)
	{
		Map<String, String> map = new HashMap<>();
		
		if(memberService.isMyidCheck(myid))
			map.put("result", "fail"); //중복되는 경우
		else
			map.put("result", "success"); //중복되지 않는 경우
		
		return map;
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MemberDto dto,
							@RequestParam("upload") MultipartFile upload)
	{
		if(upload.getOriginalFilename().equals(""))
		{
			dto.setMphoto("no");
		}
		else
		{
			// 네이버 스토리지에 회원 등록 사진 저장하기
			String uploadFileName = storageService.uploadFile(bucketName, "member", upload); //두번째 파라미터는 디렉토리 이름
			dto.setMphoto(uploadFileName);
		}
		
		// 회원 정보 저장
	    memberService.insertMember(dto);
	    
		//선택을 안했다면 upload 하지말고 mphoto 
		return "redirect:/"; //일단은 홈으로 이동
	}
}
