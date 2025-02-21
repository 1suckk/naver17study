package controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.MyCloudProps;
import data.dto.MyPropDto;
import lombok.AllArgsConstructor;

@Controller
//@AllArgsConstructor //모든 멤버변수에 생성자 주입
//모든 파라미터를 모아서 생성자에 총합하는데 port, addr 는 설정 파일에 있으므로
//AllArgsConstructor 어노테이션을 주석 처리해줘야 에러 방지
public class MyPropController {
	@Autowired
	MyPropDto propDto;
	
	@Autowired
	MyCloudProps props;
	
	@Value("${server.port}")
	int port;
	
	@Value("${emp.addr}")
	String addr;
	
	@GetMapping("/prop1")
	public String prop1(Model model)
	{
		model.addAttribute("addr", propDto.getAddr());
		model.addAttribute("hp", propDto.getHp());
		model.addAttribute("msg", "서버포트는 "+port+" 이고 지역은 "+addr+"입니다");
		return "result3";
	}
	
	@GetMapping("/prop2")
	public String prop2(Model model)
	{
		model.addAttribute("db", props.getDb());
		model.addAttribute("username", props.getUsername());
		model.addAttribute("password", props.getPassword());
		return "result4";
	}
}
