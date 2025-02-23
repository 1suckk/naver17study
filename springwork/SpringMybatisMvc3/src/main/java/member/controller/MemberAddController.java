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

@Controller
@RequestMapping("/member")
public class MemberAddController {
	
	@Autowired
	MemberService memberService;
	
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
	public String insert(HttpServletRequest request,
							@ModelAttribute MemberDto dto,
							@RequestParam("upload") MultipartFile upload)
	{
		//업로드할 경로 구하기
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		
		//dto에 저장할 변수명
		String mphoto = "";
		String uploadFilename = UUID.randomUUID()+"."+(upload.getOriginalFilename().split("\\.")[1]);
		mphoto+=uploadFilename;
		
		try
		{
			upload.transferTo(new File(uploadFolder+"/"+uploadFilename));
		}
		catch (IllegalStateException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dto에 저장
		dto.setMphoto(mphoto);
		// 회원 정보 저장
	    memberService.insertMember(dto);
		
	    //insert 후 회원의 num값을 얻는 확인
	    System.out.println("num="+dto.getNum());
	    
		//선택을 안했다면 upload 하지말고 mphoto 
		return "redirect:/"; //일단은 홈으로 이동
	}
}
