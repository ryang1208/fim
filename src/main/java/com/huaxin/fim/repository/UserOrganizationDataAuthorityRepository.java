package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.UserOrganizationDataAuthority;
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
@Named("userOrganizationDataAuthorityRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = UserOrganizationDataAuthority.class)
public interface UserOrganizationDataAuthorityRepository extends CrudRepository<UserOrganizationDataAuthority, Long> {
	
	/**
	 * 根据用户获取其机构设置
	 * @param userId
	 * @return
	 */
	public List<UserOrganizationDataAuthority> findByUserId(String userId);
	
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from UserOrganizationDataAuthority where userId = :userId")
	public void delByUserId(@Param("userId") String userId);

	/**
	 * 根据机构获取关联用户列表
	 * @param organizationId
	 * @return
	 */
	public List<UserOrganizationDataAuthority> findByOrganizationId(String organizationId);
	
	/**
	 * 根据用户获取主机构
	 * @param userId
	 * @return
	 */
	@Query(value="Select u from UserOrganizationDataAuthority u where u.userId =:userId and u.organizationType =:organizationType  ")
	public UserOrganizationDataAuthority findByUserIdAndType(@Param("userId") String userId, @Param("organizationType") String organizationType);


	/**
	 * 根据用户获取机构
	 * @param userId
	 * @return
	 */
	@Query(value="Select distinct u.organizationId from UserOrganizationDataAuthority u where u.userId =:userId  or :userId is null ")
	public List<String> findOrganizationIdListByUserId(@Param("userId") String userId);

	/**
	 * 根据用户获取用户
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT DISTINCT user_id FROM t_user_organization_data_authority WHERE "
			+ "organization_id IN(SELECT DISTINCT u.organization_id FROM t_user_organization_data_authority u "
			+ "WHERE 1=1 "
			+ "and(u.user_id =:userId or :userId is null)) ",nativeQuery = true)
	public List<String> findUserIdListByUserId(@Param("userId") String userId);
	
	/**
	 * 根据用户获取用户
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT login_id FROM sso.t_user WHERE user_state = '1' ",nativeQuery = true)
	public List<String> findAllUser();
		
}	
