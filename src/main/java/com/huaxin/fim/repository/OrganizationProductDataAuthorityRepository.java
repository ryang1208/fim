package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.OrganizationProductDataAuthority;
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
@Forbid(forbiddenMethods="deleteAll")
@EntityClass(entityClass = OrganizationProductDataAuthority.class)
@Named("organizationProductDataAuthorityRepository")
public interface OrganizationProductDataAuthorityRepository extends CrudRepository<OrganizationProductDataAuthority, Long>{

	//获取产品机构
	@Query(value="SELECT p.id,p.product_name,t.organization_id,o.organization_name,t.organization_type "
			+ "FROM t_organization_product_data_authority t "
			+"LEFT JOIN t_organization o ON o.id = t.organization_id  "
			+"LEFT JOIN t_product p ON t.product_id = p.id            "
			+"LEFT JOIN t_investment_manager i ON i.id = p.investment_id "
			+"WHERE 1=1 "
			+"AND (o.organization_name like  CONCAT('%',:organizationName, '%') or :organizationName IS NULL) "
			+"AND (p.product_name like %:productName%  or  :productName is null)       		   "
			+"AND (i.company_name like  CONCAT('%',:companyName, '%') or :companyName IS NULL) "        
			+"AND (p.is_independent = :isIndependent or :isIndependent is null)        		   "
			+"AND (p.is_parent_product = :isPortfolios or :isPortfolios is null)      		   "
			+"AND t.organization_type <> 1 "
			+"order by t.product_id ",nativeQuery = true)
	public List<Object[]> getAllOrganizationProductDataAuthority(@Param("organizationName") String organizationName, @Param("productName") String productName,
                                                                 @Param("companyName") String companyName, @Param("isIndependent") String isIndependent, @Param("isPortfolios") String isPortfolios);


	// 获取主机构
	@Query(value="SELECT t.id,t.product_name,t.organization_id,o.organization_name,'0' "
			+"FROM t_product t "
			+"LEFT JOIN t_investment_manager i ON i.id = t.investment_id 			  "
			+"Right JOIN t_organization o ON o.id = t.organization_id 				  "
			+"WHERE 1=1 "
			+"AND t.organization_id is not null 									   "
			+"AND (o.organization_name like  CONCAT('%',:organizationName, '%') or :organizationName IS NULL) "
			+"AND (t.product_name like %:productName%  or  :productName is null)       "
			+"AND (i.company_name like  CONCAT('%',:companyName, '%') or :companyName IS NULL) "
			+"AND (t.is_independent = :isIndependent or :isIndependent is null)        "
			+"AND (t.is_parent_product = :isPortfolios or :isPortfolios is null)       "
			+"AND t.product_status <> 3 ",nativeQuery=true)
	public List<Object []> getMainOrganization(@Param("organizationName") String organizationName, @Param("productName") String productName,
                                               @Param("companyName") String companyName, @Param("isIndependent") String isIndependent, @Param("isPortfolios") String isPortfolios);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from OrganizationProductDataAuthority where organizationId = :organizationId and productId =:productId ")
	public void deleteOrganizationProductDataAuthority(@Param("organizationId") String organizationId, @Param("productId") String productId);

	@Query(value="Select o from OrganizationProductDataAuthority o where o.organizationId = :organizationId and o.productId =:productId and o.organizationType =:organizationType  ")
	public OrganizationProductDataAuthority getOrganizationProductByProductIdAndOrganizationId(@Param("organizationId") String organizationId, @Param("productId") String productId,
                                                                                               @Param("organizationType") String organizationType);
	
	
}
