package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.ProductInvesterRelationship;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "productInvesterRelationshipRepository")
@EntityClass(entityClass = ProductInvesterRelationship.class)
public interface ProductInvesterRelationshipRepository extends CrudRepository<ProductInvesterRelationship, Long> {
	
	@Query("select p from ProductInvesterRelationship p,iWinProduct product where "
			+" p.investerID=:investerID AND (product.id = p.productID) AND (product.productStatus != 3)")
	public List<ProductInvesterRelationship> findByInvesterID(@Param("investerID") String investerID);
	
	public List<ProductInvesterRelationship> findByProductID(@Param("productID") int productID);

	public ProductInvesterRelationship findByInvesterIDAndBrokerID(@Param("investerId") String investerId, @Param("brokerId") int brokerId);


	public List<ProductInvesterRelationship> findByProductIDAndInvesterType(@Param("productID") int productID, @Param("investerType") String investerType);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ProductInvesterRelationship p where p.productID=:productID ")
	public void deleteByProductID(@Param("productID") int productID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ProductInvesterRelationship p where p.productID=:productID and p.investerType=:investerType")
	public void deleteByProductIDAndInvesterType(@Param("productID") int productID, @Param("investerType") String investerType);

	@Query(value = "select i from ProductInvesterRelationship i "
			+ "where i.investerID = :investerID and i.investerType = :investerType and i.brokerID = :brokerID")
	public List<ProductInvesterRelationship> findByInvesterIDInfo(@Param("investerID") String investerID,
                                                                  @Param("investerType") String investerType, @Param("brokerID") int brokerID);

	public List<ProductInvesterRelationship> findByProductIDAndBrokerID(@Param("productID") int productID, @Param("brokerID") int brokerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="update ProductInvesterRelationship p set p.brokerID = :brokerID  where p.investerID = :investerID")
	public void updateByInvesterID(@Param("investerID") String investerID, @Param("brokerID") int brokerID);

	@Query(value="SELECT COUNT(id) FROM t_product_invester_relationship WHERE invester_type =:investerType and broker_id =:brokerID and invester_id = :investerId",nativeQuery=true)
	public int getProductInvesterRelationshipList(@Param("investerType") String investerType, @Param("brokerID") String brokerID, @Param("investerId") String investerId);

	@Query(value="select count(id)from t_product_invester_relationship where invester_id = :investerId and (case when :productId is not null then product_id <>:productId else :productId is null end)",nativeQuery=true)
	public int getInvesterRelationShipCount(@Param("investerId") String investerId, @Param("productId") String productId);

	/**
	 * 获取最新一天需要计算成交额的产品代码列表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT                                 "
				+"    CONCAT(product_id,'')                         "
				+" FROM                                   "
				+"   t_product_invester_relationship      "
				+" WHERE invester_id IN                   "
				+"   (SELECT                              "
				+"     t.invester_id                      "
				+"   FROM                                 "
				+"     t_transaction_summary t            "
				+"   WHERE t.date = :date              "
				+"   GROUP BY t.invester_id)              "
				+" GROUP BY product_id   ",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);
}
