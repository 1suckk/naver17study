package test.controller;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.data.ProfileDto;

@Controller
public class TestController {
	
	@GetMapping("/")
	public String home()
	{
		return "profile/home";
	}
	
	@GetMapping("/hello")
	public String home(Model model)
	{
		model.addAttribute("message", "have a nice day");
		model.addAttribute("myprofile", "aiprofile1.jpeg");
		return "profile/hello";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model, @RequestParam(value = "name") String name, @RequestParam(value = "pay") int pay)
	{
		model.addAttribute("name", name);
		model.addAttribute("pay", pay);
		return "profile/hello2";
	}
	
	@GetMapping("/hello3")
	public String hello3(Model model)
	{
		ProfileDto dto = ProfileDto.builder()
							.name("김선혜")
							.pay(120000)
							.photo("aiprofile2.jpeg")
							.build();
		
		model.addAttribute("dto", dto);
		model.addAttribute("bgcolor", "#00ff7f");
		model.addAttribute("today", new Date());
		
		return "profile/hello3";
	}
	
	@GetMapping("/hello4")
	public String hello4(Model model)
	{
		List<ProfileDto> list = new Vector<>();
		list.add(new ProfileDto("김선혜", 150000, "aiprofile2.jpeg"));
		list.add(new ProfileDto("박소미", 200000, "aiprofile5.jpeg"));
		list.add(new ProfileDto("박채연", 250000, "aiprofile4.jpeg"));
		list.add(new ProfileDto("서현진", 150000, "aiprofile3.jpeg"));
		list.add(new ProfileDto("임지혜", 200000, "aiprofile1.jpeg"));
		
		model.addAttribute("list", list);
		
		return "profile/hello4";
	}
	
	@GetMapping("/hello5")
	public String hello5(Model model, @RequestParam(value = "myid") String myid,
							HttpSession session)
	{
		session.setAttribute("loginid", myid);
		return "profile/hello5";
	}
}