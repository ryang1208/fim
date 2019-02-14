package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.UserInvestmentDataAuthority;
import com.huaxin.fim.entity.entity.UserProductDataAuthority;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = UserInvestmentDataAuthority.class)
@Named("userInvestmentDataAuthorityRepository")
public interface UserInvestmentDataAuthorityRepository extends CrudRepository<UserInvestmentDataAuthority, Long>{
	
	@Query(value="SELECT t.item_id,i.company_name FROM t_user_investment_data_authority t "
			+ "LEFT JOIN t_investment_manager i ON t.item_id = i.id WHERE t.category ='1' ",nativeQuery = true)
	public List<Object[]> findAllInvestment();
	
	@Query(value="Select u from UserInvestmentDataAuthority u where u.userId=:userId and u.category=:category and u.itemId=:itemId ")
	public UserInvestmentDataAuthority findUserInvestmentByUserIdAndItemId(@Param("userId") String userId, @Param("category") String category, @Param("itemId") String itemId);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from UserInvestmentDataAuthority where userId=:userId and category=:category and itemId=:itemId ")
	public void deleteUserInvestmentDataAuthority(@Param("userId") String userId, @Param("category") String category, @Param("itemId") String itemId);

	/**
	 * 根据用户Id获取白名单中配置类别为用户的数据列表
	 * @param userId
	 * @param category
	 * @return
	 */
	public List<UserProductDataAuthority> findByUserIdAndCategory(String userId, String category);

	/**
	 *
	 * @param userId
	 * @param category
	 * @return
	 */
	@Query(value="select item_id from t_user_investment_data_authority where user_id = :userId and category = :category and authority like concat('%',:authority,'%')",nativeQuery=true)
	public List<String> findUserIdByUserIdAndCategory(@Param("userId") String userId, @Param("category") String category, @Param("authority") String authority);
} 
