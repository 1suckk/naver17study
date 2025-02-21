package controller.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;

@Controller
public class ShopFormController {
	@GetMapping("/form1")
	public String form1()
	{
		return "shop/form1";
	}
	
	@GetMapping("/form2")
	public String form2()
	{
		return "shop/form2";
	}
	
	@GetMapping("/form3")
	public String form3()
	{
		return "shop/form3";
	}
	
	@GetMapping("/process1")
	public String list1(Model model,
			String myid, 
			String mypass,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum)
	{
		String result="";
		if(mypass.equals("12345"))
		{
			result = myid + " 님이 로그인했습니다.";
		}
		else
		{
			result = "비밀번호가 맞지 않습니다.";
		}
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "shop/list1";
	}
	
	@PostMapping("/process2")
	//dto로 통째로 읽어서 모델에 저장 (저장 시 ShopDto 로 저장)
	public String list2(@ModelAttribute ShopDto dto)
	{
		return "shop/list2";
	}
	
	@PostMapping("/process3")
	public String list3(Model model,
			@RequestParam Map<String, String> map)
	{
		model.addAttribute("name", map.get("name"));
		model.addAttribute("age", map.get("age"));
		model.addAttribute("addr", map.get("addr"));
		model.addAttribute("gender", map.get("gender"));
		
		return "shop/list3";
	}
}