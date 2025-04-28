package bit.day0417.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bit.day0417.data.UserEntity;

public class CustomUserDetail implements UserDetails {
	
	private UserEntity userEntity;
	
	public CustomUserDetail() {
		// TODO Auto-generated constructor stub
		this.userEntity=userEntity;
	}
	
	//사용자의 권한에 대해서 리턴해주는 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 컬렉션 형태로 반환
		Collection<GrantedAuthority> collection = new ArrayList<>();
		
		collection.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return userEntity.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
