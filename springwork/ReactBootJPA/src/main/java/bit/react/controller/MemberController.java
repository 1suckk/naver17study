package bit.react.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.react.repository.JoinService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:3000")

@RequestMapping("/auth/member")
public class MemberController {
	private final JoinService joinService;
	
	@DeleteMapping("/delete")
	public String deleteMember(@RequestParam("id") int id)
	{
		joinService.deleteMember(id);
		return "member delete ok!";
	}
}
