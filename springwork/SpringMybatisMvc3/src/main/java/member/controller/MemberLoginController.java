package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberLoginController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public String login()
	{
		return "member/memberlogin";
	}
	
	//로그인 처리
	@PostMapping(value = "/login", produces = "application/json")
	@ResponseBody
	public Map<String, Object> loginProcess(@RequestParam String myid,
											@RequestParam String mpass,
											HttpSession session)
	{
		Map<String, Object> response = new HashMap<>();
	    MemberDto dto = memberService.login(myid, mpass);
	    
	    if(dto != null)
	    {
	        session.setAttribute("loginUser", dto);
	        session.setAttribute("loginstatus", "success"); // 로그인 세션 set
	        session.setAttribute("loginid", dto.getMyid());
	        session.setMaxInactiveInterval(30*60); //세션 시간 30분 지정
	        response.put("result", "success");
	    }
	    else
	    {
	        response.put("result", "fail");
	    }
	    return response;
	}
		
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
	    session.removeAttribute("loginUser"); // 세션에서 로그인 정보 제거
	    session.removeAttribute("loginstatus"); // 로그인 상태 제거
	    session.invalidate(); // 세션 완전히 무효화
	    return "redirect:/";
	}
}
