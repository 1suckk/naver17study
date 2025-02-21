package json.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.dto.TestDto;

@Controller
public class JsonRestController2 {
	@GetMapping("/test")
	@ResponseBody public TestDto test1()
	{
		TestDto dto = new TestDto("이영자", "서울시", "여성");
		return dto;
	}
}
