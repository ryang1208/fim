package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.UserProductFollow;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EntityClass(entityClass = UserProductFollow.class)
public interface UserProductFollowRepository extends CrudRepository<UserProductFollow, Long> {
	
	@Query(value ="SELECT COUNT(t.login_id) FROM t_user_product_follow t LEFT JOIN t_product p ON t.product_id = p.id "
			+ "WHERE t.login_id= :loginID AND p.product_status <>'3'",nativeQuery=true)
	public int findUserProductFollowTotalByLoginID(@Param("loginID") String loginID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete UserProductFollow u "
			+ "where u.productID=:productID and (u.loginID=:loginID)")
	public void delByProductIDAndLoginID(@Param("productID") Integer productID, @Param("loginID") String loginID);


	@Query("select count(*) from UserProductFollow u where u.loginID = :loginID and (u.productID=:productID)")
	public int findUserProductFollowTotalByLoginIDAndProductID(@Param("loginID") String loginID, @Param("productID") Integer productID);
}
	