package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Organization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 机构管理数据库持久处理接口
 * @author liumd
 *
 */
@Repository(value = "organizationRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = Organization.class)
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
	
	@Query(value = "select o from Organization o")
	public List<Organization> getOrganizationList();
	
	public Organization findByOrganizationName(@Param("organizationName") String organizationName);
	
	@Query(value = "select CONCAT(id,'') from t_organization ",nativeQuery= true)
	public List<String> getAllOrganizationList();
}	
