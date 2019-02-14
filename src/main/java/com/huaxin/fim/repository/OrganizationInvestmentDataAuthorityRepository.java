package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.OrganizationInvestmentDataAuthority;
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
@EntityClass(entityClass = OrganizationInvestmentDataAuthority.class)
@Named("organizationInvestmentDataAuthorityRepository")
public interface OrganizationInvestmentDataAuthorityRepository extends CrudRepository<OrganizationInvestmentDataAuthority, Long>{
	
	@Query(value="SELECT t.investment_id investmentId,i.company_name companyName, t.organization_id organizationId,o.organization_name organizationName,t.organization_type organizationType "
			+ "FROM t_organization_investment_data_authority t  "
			+ "LEFT JOIN t_organization o ON o.id = t.organization_id "
			+ "LEFT JOIN t_investment_manager i ON i.id = t.investment_id "
			+ "WHERE (i.company_name like  CONCAT('%',:companyName, '%') or :companyName IS NULL) "
			+ "AND (o.organization_name like  CONCAT('%',:organizationName, '%') or :organizationName IS NULL) "
			+ "AND t.organization_type <> 1 "
			+ "ORDER BY t.investment_id ",nativeQuery = true)
	public List<Object []> findAllOrganizationInvestment(@Param("companyName") String companyName, @Param("organizationName") String organizationName);

	@Query(value="SELECT t.id investmentId,t.company_name companyName,t.organization_id organizationId,"
			+ "o.organization_name organizationName,'0' organizationType "
			+ "FROM t_investment_manager t Right JOIN t_organization o ON o.id = t.organization_id "
			+ "WHERE t.organization_id is not null "
			+ "AND (t.company_name like  CONCAT('%',:companyName, '%') or :companyName IS NULL) "
			+ "AND (o.organization_name like  CONCAT('%',:organizationName, '%') or :organizationName IS NULL) " ,nativeQuery=true)
	public List<Object []> getMainOrganization(@Param("companyName") String companyName, @Param("organizationName") String organizationName);

	@Query(value="Select u from OrganizationInvestmentDataAuthority u where u.investmentId=:investmentId and u.organizationId=:organizationId and u.organizationType=:organizationType ")
	public OrganizationInvestmentDataAuthority findOrganizationInvestmentByInvestmentId(@Param("investmentId") String investmentId, @Param("organizationId") String organizationId,
                                                                                        @Param("organizationType") String organizationType);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from OrganizationInvestmentDataAuthority where investmentId = :investmentId and organizationId = :organizationId ")
	public void deleteOrganizationInvestmentByInvestmentId(@Param("investmentId") String investmentId, @Param("organizationId") String organizationId);
	
}
