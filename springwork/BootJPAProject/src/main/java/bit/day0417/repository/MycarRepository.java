package bit.day0417.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.day0417.data.MycarDto;

public interface MycarRepository extends JpaRepository<MycarDto, Long>{

}
