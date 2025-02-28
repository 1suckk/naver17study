package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import data.dto.MemberDto;
import data.service.MemberService;
import naver.storage.NcpObjectStorageService;

@Controller
public class MemberListController {
	@Autowired
	MemberService memberService;
	@Autowired
	NcpObjectStorageService storageService;
	
	//NCP 버킷 이름
	private String bucketName="bitcamp-bucket-140";
	
	@GetMapping("/member/list")
	public String memberList(Model model)
	{
		//전체 회원 정보 
		List<MemberDto> list = memberService.getAllMember();
		
		//모델에 저장
		model.addAttribute("list", list);
		model.addAttribute("fronturl", "https://jhmafcod8738.edge.naverncp.com/mBHgqdbMYT");
		model.addAttribute("backurl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
		//포워드
		return "member/memberlist";
	}
}
