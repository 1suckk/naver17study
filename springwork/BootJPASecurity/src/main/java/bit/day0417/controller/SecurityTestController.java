package bit.day0417.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bit.day0417.repository.JoinService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SecurityTestController {
	
	final JoinService joinService;
	
	@GetMapping("/")
	public String main()
	{
		return "main";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model)
	{
		//session 현재 사용자 id
		String username = SecurityContextHolder.getContext().toString();
		
		return "mypage";
	}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/join")
	public String join()
	{
		return "join";
	}
}
