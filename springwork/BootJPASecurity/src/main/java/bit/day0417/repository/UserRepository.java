package bit.day0417.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.day0417.data.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public boolean existsByUsername(String username);
}
