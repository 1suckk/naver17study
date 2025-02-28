package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import naver.storage.NcpObjectStorageService;

@Controller
public class MemberDeleteController {
	@Autowired
	MemberService memberService;
	@Autowired
	NcpObjectStorageService storageService;
	
	//버켓 이름
	private String bucketName = "bitcamp-bucket-140";
	
	//관리자가 회원목록 페이지에서 체크박스에 포함된 멤버를 모두 한꺼번에 삭제처리하는 방법
	@PostMapping("/member/deleteSelected")
	public String deleteSelected(@RequestParam("selected") List<Integer> selected)
	{
		memberService.deleteSelected(selected);
		return "redirect:/member/list";
	}
	
	//관리자가 한 사람씩 삭제하는 방법
	@PostMapping("/member/delete")
	public String deleteMember(@RequestParam int num)
	{
		memberService.deleteMember(num);
		return "redirect:/member/list";
	}
	
	//마이페이지로 들어가서 삭제하는 방법
	@GetMapping("/member/mypagedel")
	public void mypageDelete(@RequestParam int num, HttpSession session)
	{
		memberService.deleteMember(num);
		
		//모든 세션 제거
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		session.removeAttribute("loginphoto");
	}
}
