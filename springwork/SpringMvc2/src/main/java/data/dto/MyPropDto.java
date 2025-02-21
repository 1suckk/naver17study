package data.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource("classpath:/application.properties") //.properties 파일이 이거 하나면 있으면 생략 가능
@ConfigurationProperties(prefix="emp") //properties 설정파일에서 emp로 시작하는 값을 읽어온다
@Data
public class MyPropDto {
	private String addr;
	private String hp;
}
