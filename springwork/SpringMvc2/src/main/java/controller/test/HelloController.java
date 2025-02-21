package controller.test;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@GetMapping("/")
//	public ModelAndView hello1()
//	{
//		ModelAndView mview = new ModelAndView();
//		mview.addObject("message", "오늘은 월요일입니다");
//		mview.setViewName("hello"); //WEB-INF/hello.jsp
//		return mview;
//	}
	
	public String hello1(Model model)
	{
		model.addAttribute("message", "오늘은 월요일입니다");
		model.addAttribute("today", new Date());
		return "hello";
	}
}
