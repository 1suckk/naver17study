package bit.react.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import bit.react.data.UserEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {
	private final UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) {
		//db에서 조회
		UserEntity userData = userRepository.findByUsername(username);
		//db에 존재할 경우 user 정보 보관
		if(userData!=null)
		{
			return new CustomUserDeails(userData);
		}
		System.out.println("user 정보 반환에 실패");
		return null;
	}
}
