package day1223;

class UserException extends Exception 
{
	public UserException(String message) {
		super(message);
	}
}

public class Ex12UserException {
	
	public static void inputName(String name) throws UserException
	{
		if (name.equals("김태희") || name.equals("송혜교"))
			throw new UserException("거짓이름이네요");
		else
			System.out.println("내 이름은 " + name + "입니다.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inputName("성시경");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			inputName("김태희");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("정상종료");
	}
}
