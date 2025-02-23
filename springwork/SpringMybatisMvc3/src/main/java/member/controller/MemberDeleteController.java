package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.service.MemberService;

@Controller
public class MemberDeleteController {
	@Autowired
	MemberService memberService;
	
	@PostMapping("/member/deleteSelected")
	public String deleteSelected(@RequestParam("selected") List<Integer> selected)
	{
		memberService.deleteSelected(selected);
		return "redirect:/member/list";
	}
}
