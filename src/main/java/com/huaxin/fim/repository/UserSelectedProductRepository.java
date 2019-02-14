package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.UserSelectedProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = UserSelectedProduct.class)
@Named("userSelectedProductRepository")
public interface UserSelectedProductRepository extends CrudRepository<UserSelectedProduct, Long> {
	
	
	/**
	 * 根据产品代码及用户ID查询选中产品列表
	 * @param productId
	 * @param userId
	 * @return
	 */
	public UserSelectedProduct findByProductIdAndUserId(@Param("productId") String productId, @Param("userId") String userId);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete UserSelectedProduct u "
			+ "where u.userId=:userId")
	public void delProducts(@Param("userId") String userId);
}	
