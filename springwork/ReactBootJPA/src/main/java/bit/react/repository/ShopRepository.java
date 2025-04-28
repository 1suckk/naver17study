package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.react.data.ShopEntity;
import jakarta.transaction.Transactional;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {
	@Query(value="""
			update jpashop set sangpum=:#{#entity.sangpum},
			price=:#{#entity.price}, color=:#{#entity.color},
			sangguip=:#{#entity.sangguip}
			where num=:#{#entuty.num} 
			""",nativeQuery=true)
	@Modifying //DDL 구문을 사용할 때도 표기를 해줘야 함
	@Transactional //update, delete 표기해줘야 한다
	public void updateShopNoPhoto(@Param("entity") ShopEntity entitiy);
}
