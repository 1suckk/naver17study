package bitcamp.study;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class BitController {
	@GetMapping("/hello")
	public List<TestDto> list()
	{
		List<TestDto> list = new Vector<>();
		list.add(new TestDto("이미자", "서울", "4468"));
		list.add(new TestDto("이미자", "서울", "4468"));
		list.add(new TestDto("이미자", "서울", "4468"));
		return list;
	}
}
