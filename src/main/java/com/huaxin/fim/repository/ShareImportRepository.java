package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ShareImport;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基金份额数据持久接口
 */
@Repository("shareImportRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ShareImport.class)
public interface ShareImportRepository extends CrudRepository<ShareImport, Long> {
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="UPDATE t_share_import a, t_product b SET a.product_id = b.id WHERE a.product_name = b.product_name AND a.update_date=:updateDate AND a.create_user=:createUser",nativeQuery=true)
	public void updateProuctId(@Param("updateDate") String updateDate, @Param("createUser") String createUser);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="UPDATE t_share_import a, t_product b SET a.client_product_id = b.id WHERE a.client_name = b.product_name AND a.update_date=:updateDate AND a.create_user=:createUser",nativeQuery=true)
	public void updateClientProuctId(@Param("updateDate") String updateDate, @Param("createUser") String createUser);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="DELETE FROM t_share_import WHERE product_name=:productName AND confirm_date BETWEEN :beginDate AND :endDate ",nativeQuery=true)
	public void deleteByProductNameAndConfimeDate(@Param("productName") String productName, @Param("beginDate") String beginDate,
                                                  @Param("endDate") String endDate);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="DELETE FROM t_share_import WHERE client_product_id=:clientProductId and product_id=:productID",nativeQuery=true)
	public void deleteByParentProductIDAndproductID(@Param("clientProductId") String clientProductId, @Param("productID") String productID);

	/**
	 * 保存之前验证
	 * @param clientName
	 * @param productName
	 * @param businessType
	 * @param confirmDate
	 * @return
	 */
	public ShareImport findByClientNameAndProductNameAndBusinessTypeAndConfirmDate(String clientName, String productName, String businessType, String confirmDate);

	@Query(value="select t from ShareImport t WHERE t.productId=:productId AND t.confirmDate >=:beginDate order by t.confirmDate asc ")
	public List<ShareImport> queryByProductIdAndDate(@Param("productId") String productId, @Param("beginDate") String beginDate);

	@Query(value="select t from ShareImport t WHERE t.productName=:productName AND t.confirmDate >=:beginDate AND t.confirmDate <=:endDate ")
	public List<ShareImport> queryByProductNameAndConfirmDate(@Param("productName") String productName, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	@Query(value="select * from t_share_import a "
			+ "where a.client_product_id = :clientProductId "
			+ "and a.update_date = :updateDate "
			+ "AND a.create_user=:createUser "
			+ "order by a.confirm_date",nativeQuery=true)
	public List<ShareImport> findByClientProductIdAndUpdateDateAndCreateUser(@Param("clientProductId") String clientProductId, @Param("updateDate") String updateDate, @Param("createUser") String createUser);
	
	@Query(value="select p from ShareImport p where p.productId in(:productIds)  order by p.confirmDate asc")
	public List<ShareImport> queryByProductId(@Param("productIds") List<String> productIds);
}
	