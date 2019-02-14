package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.UserProductDataAuthority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品指数周期
 */
@Repository("userProductDataAuthorityRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = UserProductDataAuthority.class)
public interface UserProductDataAuthorityRepository extends CrudRepository<UserProductDataAuthority, Long> {
	
	/**
	 * 根据用户+类别+名称获取用户产品关系
	 * @param userId
	 * @param itemId
	 * @return
	 */
	public List<UserProductDataAuthority> findByUserIdAndCategoryAndItemId(String userId, String category, String itemId);

	/**
	 * 根据用户Id获取白名单中配置类别为用户的数据列表
	 * @param userId
	 * @param category
	 * @param authority
	 * @return
	 */
	@Query(value="select item_id from t_user_product_data_authority where user_id = :userId and category = :category and authority like concat('%',:authority,'%')",nativeQuery=true)
	public List<String> getDataListByUserIdAndCategoryAndAuthority(@Param("userId") String userId, @Param("category") String category, @Param("authority") String authority);
}
	