package json.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRestController {
	
	@GetMapping("/bit")
	public String test1()
	{
		return "bitcamp";
	}
}
