package bitcamp.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component //mycar 라는 이름으로 등록이 된다
@Data
public class Mycar {
	@Value("비야디 아토3")
	private String mycarName;
	@Value("청색")
	private String mycarColor;
}
