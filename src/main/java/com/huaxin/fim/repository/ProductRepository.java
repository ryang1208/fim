package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.iWinProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository(value = "productRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = iWinProduct.class)
public interface ProductRepository extends CrudRepository<iWinProduct, Long> {
	
	@Query("select new map(p.id as id,p.productName as productName) from iWinProduct p where p.productStatus <>'3' ")
	public List<Map<String, Object>> findAllProductName();
	
	public iWinProduct findByProductCodeAndIsParentProduct(String productCode, String isParentProduct);

	@Query("select i from iWinProduct i "
			+ "where i.productCode =:productCode "
			+ "and (i.isParentProduct = :isParentProduct or :isParentProduct is null) "
			+ "and (i.productStatus <> :productStatus OR i.productStatus is null )")
	public List<iWinProduct> findByProductCodeAndIsParentProductAndProductStatus(@Param("productCode") String productCode,
                                                                                 @Param("isParentProduct") String isParentProduct, @Param("productStatus") String productStatus);

	public List<iWinProduct> findByProductCodeAndProductStatus(String productCode, String productStatus);

	@Query("select count(*) from iWinProduct p where p.productStatus <>'3' "
			+ "and (p.organizationId in (:organizationIdList)) ")
	public int getFundTotal(@Param("organizationIdList") List<String> organizationIdList);

	@Query("select count(*) from iWinProduct p where p.productCode =:productCode and p.id <>:id ")
	public int getProductCode(@Param("productCode") String productCode, @Param("id") Long id);

	@Query(value="select count(*) from iWinProduct p where p.serviceManagerId=:loginID "
			+ "and (p.organizationId in (:organizationIdList)) ")
	public int getManageFundTotal(@Param("loginID") String loginID, @Param("organizationIdList") List<String> organizationIdList);

	@Query(value = "select i from iWinProduct i where i.productName like %:productFullName% ")
	public List<iWinProduct> queryByLikeProductName(@Param("productFullName") String fullName);

	@Query("select i from iWinProduct i where i.investmentID =:investmentID and i.productStatus !='3'")
	public List<iWinProduct> findByInvestmentID(@Param("investmentID") String investmentID);

	long deleteByInvestmentID(String investmentID);

	public iWinProduct findByProductName(String productName);

	public void deleteByProductName(String productName);

	@Query("select i from iWinProduct i where i.portfolioFund =:portfolioFund and i.productStatus !='3'")
	public List<iWinProduct> findByPortfolioFund(@Param("portfolioFund") String portfolioFund);

	@Query("select i from iWinProduct i where i.productStatus !='3' and i.isParentProduct='1'")
	public List<iWinProduct> findAllFOF();

	@Query("select i from iWinProduct i where i.productStatus !='3' and i.productStatus != '2' and i.isParentProduct='1' and i.productName=:productName")
	public iWinProduct findFOFByProductName(@Param("productName") String productName);

	@Query("select new com.quantdo.iwin.entity.iWinProduct(i.id,i.productName,p.id,p.startDate,p.endDate,p.productRatio,p.type) "
			+ "from iWinProduct i,ProductsRelationship p where i.id=p.parent_ProductID and p.productID=:productID and p.type<>'2' order by p.startDate asc")
	public List<iWinProduct> findParentFund(@Param("productID") int productID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("update iWinProduct i set i.productStatus = 3 where i.investmentID = :investmentID ")
	public void updateByInvestmentID(@Param("investmentID") String investmentID);

	@Query(value="select p from iWinProduct p where p.productName = :productName and p.productStatus !=3")
	public iWinProduct findByProductNameAndStatus(@Param("productName") String productName);

	@Query(value = "select p from iWinProduct p where p.productName = :productName and p.productStatus <> 3")
	public List<iWinProduct> findActiveByProductName(@Param("productName") String productName);

	@Query(value = "select p from iWinProduct p where p.productName = :productName and p.productStatus <> 3 and p.id <> :id")
	public List<iWinProduct> findActiveNotSelfByProductName(@Param("productName") String productName, @Param("id") Long id);

	@Query(value = "SELECT tb.broker_name brokerName FROM t_product_invester_relationship tr "
			+ "LEFT JOIN t_broker tb ON  tr.broker_id=tb.id  WHERE tr.product_id=:id "
			+ "ORDER BY tr.invester_type", nativeQuery = true)
	public Object[] findInvesterAndBrokerIDByID(@Param("id") Long id);

	@Query(value="select p from iWinProduct p where p.productName like :productName% and p.productStatus !=3 and  isParentProduct=1")
	public iWinProduct findLikeProductNameAndStatus(@Param("productName") String productName);

	@Query(value="SELECT                                                 "
				+"  CASE                                                 "
				+"    WHEN COUNT(temp.market_type) > 1                   "
				+"    THEN '全部'                                        "
				+"    ELSE                                               "
				+"    CASE                                               "
				+"      WHEN temp.market_type = 1                        "
				+"      THEN '期货'                                      "
				+"      WHEN temp.market_type = 2                        "
				+"      THEN '证券'                                      "
				+"      ELSE '无'                                        "
				+"    END                                                "
				+"  END productType                                      "
				+"FROM                                                   "
				+"  (SELECT                                              "
				+"    tps.market_type                                    "
				+"  FROM                                                 "
				+"    t_product p                                        "
				+"    LEFT JOIN t_product_invester_relationship tp       "
				+"      ON p.id = tp.product_id                          "
				+"    LEFT JOIN t_position_summary tps                   "
				+"      ON tp.broker_id = tps.broker_id                  "
				+"      AND tp.invester_id = tps.invester_id              "
				+"  WHERE p.id = :productId  AND tps.market_type IS NOT  NULL                                 "
				+"  GROUP BY tps.market_type) temp                       ",nativeQuery=true)
	public String getProductMarketType(@Param("productId") String productId);

	/**
	 * 获取需要计算净值的产品列表
	 * @param isCalculateNetValue
	 * @return
	 */

	@Query(value="select t from iWinProduct t where t.isCalculateNetValue=:isCalculateNetValue and (t.id=:id or :id is null)")
	public List<iWinProduct> findByIsCalculateNetValueAndId(@Param("isCalculateNetValue") String isCalculateNetValue, @Param("id") Long id);

	/**
	 * 获取母基金对应的子基金
	 * @return
	 */
	@Query("select new com.quantdo.iwin.entity.iWinProduct(i.id,i.productName,p.id,p.startDate,p.endDate,p.productRatio,p.type) "
			+ "from iWinProduct i,ProductsRelationship p where i.id=p.productID and p.parent_ProductID=:parentProductID and p.type<>'2' order by p.startDate asc")
	public List<iWinProduct> findSonFund(@Param("parentProductID") int parentProductID);

	/**
	 * 获取子基金
	 * @return
	 */
	@Query("select i from iWinProduct i where i.productStatus !='3' and i.isParentProduct <>'1' " )
	public List<iWinProduct> findAllProductExceptParent();

	/**
	 * 更新产品最新数据
	 * @param newestNetValueUpdateDate
	 * @param newestNetValueDate
	 * @param newestNetValueDataSource
	 * @param newestSettlementSheetUpdateDate
	 * @param newestSettlementSheetDate
	 * @param newestSettlementSheetDataSource
	 * @param productID
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("update iWinProduct i set i.newestNetValue = :newestNetValue,"
			+ "i.newestNetValueUpdateDate = :newestNetValueUpdateDate, "
			+ "i.newestNetValueDate = :newestNetValueDate,"
			+ "i.newestNetValueDataSource = :newestNetValueDataSource,"
			+ "i.newestSettlementSheetUpdateDate = :newestSettlementSheetUpdateDate,"
			+ "i.newestSettlementSheetDate = :newestSettlementSheetDate,"
			+ "i.newestSettlementSheetDataSource = :newestSettlementSheetDataSource"
			+ " where i.id = :productID ")
	public void updateByProductID(@Param("newestNetValueUpdateDate") String newestNetValueUpdateDate, @Param("newestNetValueDate") String newestNetValueDate,
                                  @Param("newestNetValueDataSource") String newestNetValueDataSource, @Param("newestSettlementSheetUpdateDate") String newestSettlementSheetUpdateDate,
                                  @Param("newestSettlementSheetDate") String newestSettlementSheetDate, @Param("newestSettlementSheetDataSource") String newestSettlementSheetDataSource,
                                  @Param("newestNetValue") BigDecimal newestNetValue, @Param("productID") Long productID);

	/**
	 * 获取基金净值数据
	 * @return
	 */
	@Query(value="SELECT DATE,update_date updateDate,data_source dataSource,round(net_accumulative_value,4) netAccumulativeValue "
			+ "FROM t_product_net_value "
			+ "WHERE product_id = :productID "
			+ "ORDER BY DATE DESC "
			+ "LIMIT 1" ,nativeQuery=true)
	public List<Object[]> getNetValueDataByProductID(@Param("productID") String productID);

	/**
	 * 获取基金交割数据
	 * @return
	 */
	@Query(value="SELECT DATE,update_date,data_source FROM t_invester_fund "
			+ "WHERE CONCAT(invester_id,broker_id) IN (SELECT CONCAT(invester_id,broker_id) FROM t_product_invester_relationship WHERE product_id = :productID)"
			+ "ORDER BY DATE DESC LIMIT 1" ,nativeQuery=true)
	public List<Object[]> getSettlementSheetDataByProductID(@Param("productID") String productID);

	// 获取所有专态不为3的产品
	@Query("select p from iWinProduct p where p.productStatus <> 3")
	public List<iWinProduct> findAllProduct();

	//更新投顾下产品主机构
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("update iWinProduct i set i.organizationId =:organizationId ,i.serviceManagerId=:serviceManagerID where i.investmentID =:investmentId and i.isIndependent= '0' and i.serviceManagerId =:userId ")
	public void updateChangeOrganizationId(@Param("organizationId") String organizationId, @Param("investmentId") String investmentId, @Param("userId") String userId, @Param("serviceManagerID") String serviceManagerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("update iWinProduct i set i.organizationId =:organizationId ,i.serviceManagerId=:serviceManagerID where i.investmentID =:investmentId  and i.serviceManagerId =:userId ")
	public void updateOrganizationId(@Param("organizationId") String organizationId, @Param("investmentId") String investmentId, @Param("userId") String userId, @Param("serviceManagerID") String serviceManagerID);

	//更新最大回撤起止期
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("update iWinProduct i set i.maxDrawdownStartDate = :maxDrawdownStartDate,i.maxDrawdownEndDate = :maxDrawdownEndDate where i.id = :productID ")
	public void updateDrawDownDateById(@Param("productID") Long productID, @Param("maxDrawdownStartDate") String maxDrawdownStartDate, @Param("maxDrawdownEndDate") String maxDrawdownEndDate);

	/**
	 * 获取基金净值数据
	 * @return
	 */
	@Query(value="SELECT count(id) "
			+ "FROM t_product "
			+ "WHERE id IN (SELECT product_id FROM t_products_relationship WHERE parent_product_id = :productID) "
			+ "AND is_calculate_netValue = '0'" ,nativeQuery=true)
	public int getProductListByIds(@Param("productID") String productID);

	@Query(value="SELECT b.product_name FROM t_products_relationship a LEFT JOIN t_product b ON a.parent_product_id = b.id "
			+ " WHERE a.product_id=:productID AND a.parent_product_id IN(SELECT id FROM t_product WHERE is_parent_product='1' AND is_calculate_netValue='1')",nativeQuery=true)
	public Object[] getCalNetValueParent(@Param("productID") String productID);

	@Query(value="SELECT t.productName from iWinProduct t WHERE t.isParentProduct='1' AND t.isCalculateNetValue='1' and t.productName = :productName	")
	public String getProductByParam(@Param("productName") String productName);

	public List<iWinProduct> findByIdIn(List<Long> ids);
}
	