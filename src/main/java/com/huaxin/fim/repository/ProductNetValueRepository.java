package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.CustomParameter;
import com.huaxin.fim.entity.entity.ProductNetValue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository(value = "productNetValueRepository")
@Forbid(forbiddenMethods = {"deleteAll"})
@EntityClass(entityClass = ProductNetValue.class)
public interface ProductNetValueRepository extends CrudRepository<ProductNetValue, Long> {

    public List<ProductNetValue> findByProductID(String productID);

	public ProductNetValue findByProductIDAndDate(String productID, String date);

	@Query("select pnv from ProductNetValue pnv,iWinProduct p where "
			+ "pnv.productID = p.id "
			+ "AND (p.productName =:contact or :contact is null) "
			+ "AND (pnv.date <=:endDate or :endDate is null) "
			+ "AND (pnv.date >=:beginDate or :beginDate is null) order by pnv.date desc")
	public List<ProductNetValue> findByCondition(@Param("contact") String contact, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

    public List<ProductNetValue> findAll();


    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from ProductNetValue p "
            + "where p.date in :date and (p.productID = :productID)")
    public void delByDates(@Param("date") Set<String> date, @Param("productID") String productID);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from ProductNetValue p "
            + "where p.date = :date and (p.productID = :productID)")
    public void delByPrimaryKey(@Param("date") String date, @Param("productID") String productID);


    @Query(value = "select c from CustomParameter c where c.parameterCode='IsCalculateNetValue' and c.parameterValue='1'")
    public CustomParameter getCustomerParameter();

    @Query(value = "select p from ProductNetValue p where "
            + "p.productID = :productID "
            + "order by p.date asc")
    public List<ProductNetValue> getNetValueListByProductID(@Param("productID") String productID);

    /**
     * 保存净值（估值导入时）
     *
     * @param date
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "  INSERT INTO t_product_net_value (      "
            + "   product_id,                          "
            + "   DATE,                                "
            + "   data_source,                         "
            + "   net_asset_value,                     "
            + "   net_accumulative_value,              "
            + "   asset_value,                         "
            + "   total_share,						  "
            + "  update_date                          "
            + " )                                      "
            + "SELECT product_id,DATE,data_source,net_asset_value,"
            + "CASE WHEN ISNULL(net_accumulative_value)=1 THEN net_asset_value ELSE net_accumulative_value END ,"
            + "asset_value,total_share,update_date FROM( "
            + " SELECT                                 "
            + "   t.product_id,                        "
            + "   t.date,                              "
            + "   t.data_source,                       "
            + "   t.value net_asset_value,                             "
            + "   (SELECT a.value FROM t_fund_valuation_message a WHERE (a.type LIKE '基金累计净值%' OR a.type LIKE '累计单位净值%') AND a.date=t.date AND a.product_id = t.product_id ) net_accumulative_value,                                "
            + "   (select a.market_value from t_fund_valuation_message a  WHERE ( a.type LIKE '基金资产净值%' OR a.type LIKE '资产净值' OR a.type LIKE '资产资产净值%') and a.date=t.date and a.product_id = t.product_id) asset_value,                                "
            + "   NULL total_share,"
            + "  (SELECT DATE_FORMAT(NOW(), '%Y%m%d') FROM DUAL) update_date                                "
            + " FROM                                   "
            + "   t_fund_valuation_message t           "
            + " WHERE (t.type LIKE '基金单位净值%' or t.type like'今日单位净值%' OR t.type LIKE'单位净值%') "
            + " and t.date = :date and t.product_id = :productID )X", nativeQuery = true)
    public void saveNetValueFromValudation(@Param("date") String date, @Param("productID") String productID);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from ProductNetValue t "
            + "where t.date = :date "
            + "and t.productID in :products")
    public void delQDIAMByDate(@Param("date") String date, @Param("products") List<String> products);

    /**
     * 日期区间产品净值数据
     */
    @Query(value = "select i from ProductNetValue i "
            + "where (i.date >= :startDate or :startDate is null) "
            + "and (i.date <= :endDate or :endDate is null) "
            + "and (i.productID = :productID or :productID is null) "
            + "order by i.productID,i.date")
    public List<ProductNetValue> findNetValueByDatePeriod(@Param("startDate") String startDate,
                                                          @Param("endDate") String endDate, @Param("productID") String productID);

    /**
     * 获取产品第一天累计净值数据
     */
    @Query(value = "SELECT p.date,p.net_accumulative_value FROM t_product_net_value p "
            + "WHERE p.product_id = :productID "
            + "ORDER BY p.product_id,p.date "
            + "LIMIT 1", nativeQuery = true)
    public List<Object[]> findFirstNetValueByProductID(@Param("productID") String productID);


    /**
     *
     */
    @Query(value=" SELECT									   "
            + " t.date date,                                   "
            +"  t.net_accumulative_value netAccumulativeValue, "
            +"  td.until_now untilNow                		   "
            +" FROM                                            "
            +"  t_product_net_value t                          "
            +"  LEFT JOIN t_product_period_kpi_statistics td   "
            +"    ON t.product_id = td.product_id              "
            +"    AND t.date = td.date                         "
            +"    AND td.KPI= '020041'                   	   "
            +"   WHERE t.product_id = :productId              "
            +"   ORDER BY t.date  " ,nativeQuery=true)
    public List<Object[]> findProductNetByProductId(@Param("productId") Integer productId);

    /**
     * 获取最新一天需要计算品种成交额指标的产品列表
     *
     * @param date
     * @return
     */
    @Query(value = " SELECT                              "
            + "     t.product_id                      "
            + "   FROM                                 "
            + "     t_product_net_value t            "
            + "   WHERE t.date = :date              "
            + "   GROUP BY t.product_id  ", nativeQuery = true)
    public List<String> getProductIdList(@Param("date") String date);

    /**
     * 日期区间产品净值数据
     */
    @Query(value = "select i.net_accumulative_value from t_product_net_value i "
            + "where (i.date >= :startDate or :startDate is null) "
            + "and (i.date <= :endDate or :endDate is null) "
            + "and (i.product_id = :productID or :productID is null) "
            + "order by i.product_id,i.date", nativeQuery = true)
    public List<BigDecimal> findNetValueByDateAndId(@Param("startDate") String startDate,
                                                    @Param("endDate") String endDate, @Param("productID") String productID);

    /**
     * 获取净值
     */
    @Query(value = "select p from ProductNetValue p where "
            + "p.productID = :productID "
            + "order by p.date ")
    public List<ProductNetValue> findNetValueByProductID(@Param("productID") String productID);

    /**
     * 获取净值表中产品Id
     */
    @Query(value = "select distinct p.product_id productId from t_product_net_value p where "
            + "p.date >= :beginDate "
            + "order by p.product_id asc", nativeQuery = true)
    public List<String> getNetValueProductIdByBeginDate(@Param("beginDate") String beginDate);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_product_net_value(product_id,date,update_date,data_source,net_asset_value,net_accumulative_value,asset_value,total_share)" +
            " values(:productId,:date,:updateDate,:datasource,:netAssetValue,:netAccumulativeValue,:assetValue,:totalShare)", nativeQuery = true)
    public void insert(@Param("productId") String productId, @Param("date") String date, @Param("updateDate") String updateDate,
                       @Param("datasource") int datasource, @Param("netAssetValue") BigDecimal netAssetValue, @Param("netAccumulativeValue") BigDecimal netAccumulativeValue,
                       @Param("assetValue") BigDecimal assetValue, @Param("totalShare") BigDecimal totalShare);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "update t_product_net_value set update_date=:updateDate,data_source=:datasource," +
            "net_asset_value=:netAssetValue,net_accumulative_value =:netAccumulativeValue,asset_value =:assetValue,total_share=:totalShare where id = :id", nativeQuery = true)
    public void update(@Param("id") int id, @Param("updateDate") String updateDate,
                       @Param("datasource") int datasource, @Param("netAssetValue") BigDecimal netAssetValue, @Param("netAccumulativeValue") BigDecimal netAccumulativeValue,
                       @Param("assetValue") BigDecimal assetValue, @Param("totalShare") BigDecimal totalShare);

}
	