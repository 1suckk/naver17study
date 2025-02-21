package lombok.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data //getter, setter, tostring 합친 기능
@AllArgsConstructor
public class TestDto {
	
	public TestDto() {
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String addr;
	private String hp;
}
