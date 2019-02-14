package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductPeriodVarietyKPIStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;

/**
 * 产品品种Respository对象
 * @author liumd
 *
 */
@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductPeriodVarietyKPIStatistics.class)
@Named("productVarietyKPIStatisticsRepository")
public interface ProductVarietyKPIStatisticsRepository extends CrudRepository<ProductPeriodVarietyKPIStatistics, Long> {
	
	
	@Query(value="SELECT MIN(DATE)FROM t_product_period_variety_kpi_statistics t WHERE t.KPI IN('020039','020040')  "
			+ "and (t.product_id =:productId or :productId is null)",nativeQuery=true)
	public String getMinDate(@Param("productId") String productId);

	@Query(value = "SELECT v.date AS DATE,v.product_id AS productID,v.variety AS variety,contract.contract_name AS contractName,v.today AS today "
			+ "FROM t_product_period_variety_kpi_statistics v "
			+ "LEFT JOIN (SELECT c.date,c.contract,c.contract_name "
			+ "FROM t_contract c WHERE c.date = :date) contract "
			+ "ON v.variety = contract.contract AND v.date = contract.date "
			+ "WHERE v.KPI = '020088' AND v.product_id = :productID "
			+ "AND v.date = :date "
			+ "AND v.today > 0 "
			+ "ORDER BY v.today DESC "
			+ "LIMIT 5", nativeQuery = true)
	public List<Object []> findNewestDayProfitFloatingProfit(@Param("productID") String productID, @Param("date") String date);

	@Query(value = "SELECT v.date AS DATE,v.product_id AS productID,v.variety AS variety,contract.contract_name AS contractName,v.today AS today "
			+ "FROM t_product_period_variety_kpi_statistics v "
			+ "LEFT JOIN (SELECT c.date,c.contract,c.contract_name "
			+ "FROM t_contract c WHERE c.date = :date) contract "
			+ "ON v.variety = contract.contract AND v.date = contract.date "
			+ "WHERE v.KPI = '020088' AND v.product_id = :productID "
			+ "AND v.date = :date "
			+ "AND v.today < 0 "
			+ "ORDER BY v.today ASC "
			+ "LIMIT 5", nativeQuery = true)
	public List<Object []> findNewestDayLossFloatingProfit(@Param("productID") String productID, @Param("date") String date);

	/**
	 * 根据指定kpi及产品ID获取最大日期
	 * @param productID
	 * @param kpi
	 * @return
	 */
	@Query(value="SELECT MAX(DATE) FROM t_product_period_variety_kpi_statistics t WHERE t.product_id=:productID AND t.KPI=:kpi",nativeQuery=true)
	public String getMaxDateByKpi(@Param("productID") String productID, @Param("kpi") String kpi);


	/**
	 * 获取最新一天需要计算品种成交额指标的产品列表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT                                 "
				+"    CONCAT(product_id,'')                           "
				+" FROM                                   "
				+"   t_product_invester_relationship      "
				+" WHERE invester_id IN                   "
				+"   (SELECT                              "
				+"     t.invester_id                      "
				+"   FROM                                 "
				+"     t_variety_summary t            "
				+"   WHERE t.date = :date              "
				+"   GROUP BY t.invester_id)              "
				+" GROUP BY product_id   ",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);

	/**
	 * 获取品种KPI表
	 * @param date
	 * @return
	 */
	@Query(value="select p from  ProductPeriodVarietyKPIStatistics p  where p.productID = :productId "
			+ "AND (p.KPI = :KPI) "
			+ "AND (p.date >= :startDate ) "
			+ "AND (p.date <= :endDate ) ORDER BY p.date ")
	public List<ProductPeriodVarietyKPIStatistics> getProductPeriodVarietyKPIStatistics(@Param("productId") String productId, @Param("KPI") String KPI,
                                                                                        @Param("startDate") String startDate, @Param("endDate") String endDate);


	/**
	 * 获取品种
	 * @param date
	 * @return
	 */
	@Query(value="SELECT DISTINCT date,variety FROM t_product_period_variety_kpi_statistics WHERE product_id=:productId "
			+ "AND (KPI =:KPI) "
			+ "AND (date >= :startDate) "
			+ "AND (date <= :endDate) ",nativeQuery=true)
	public List<Object[]> getVarietyByProductIdAndKPI(@Param("productId") String productId, @Param("KPI") String KPI,
                                                      @Param("startDate") String startDate, @Param("endDate") String endDate);
	/**
	 * 获取品种
	 * @param date
	 * @return
	 */
	@Query(value="SELECT DISTINCT date,variety FROM t_product_period_variety_kpi_statistics WHERE product_id=:productId "
			+ "AND (KPI in (:KPIList)) "
			+ "AND (date >= :startDate) "
			+ "AND (date <= :endDate) ",nativeQuery=true)
	public List<Object[]> getVarietyByProductIdAndKPIList(@Param("productId") String productId, @Param("KPIList") List<String> KPIList,
                                                          @Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 获取品种KPI
	 * @param date
	 * @return
	 */
	@Query(value="select p from  ProductPeriodVarietyKPIStatistics p  where p.productID = :productId "
			+ "AND (p.KPI = :KPI) AND (p.date = :date) AND (p.variety = :variety)")
	public ProductPeriodVarietyKPIStatistics getProductPeriodVarietyKPIByIdKPIAndDate(@Param("productId") String productId, @Param("KPI") String KPI,
                                                                                      @Param("date") String date, @Param("variety") String variety);

	/**
	 * 求和品种KPI表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT 											"
				+"  v.date DATE,                                    "
				+"  SUM(v.today) today,                             "
				+"  SUM(v.one_month) oneMonth,                      "
				+"  SUM(v.three_month) threeMonth,                  "
				+"  SUM(v.six_month) sixMonth,                      "
				+"  SUM(v.one_year) oneYear,                        "
				+"  SUM(v.this_year) thisYear,                      "
				+"  SUM(v.until_now) untilNow                       "
				+"FROM                                              "
				+"  t_product_period_variety_kpi_statistics v       "
				+"WHERE v.KPI in (:KPIList)                         "
				+"  AND (v.product_id = :productId)                 "
				+"  AND (v.date >= :startDate)						"
				+"	AND (v.date <= :endDate)						"
				+"GROUP BY v.date,                                  "
				+"  v.product_id   ",nativeQuery=true)
	public List<Object[]> getProductPeriodKPIStatisticsByProductIdAndKPI(@Param("productId") String productId, @Param("KPIList") List<String> KPIList,
                                                                         @Param("startDate") String startDate, @Param("endDate") String endDate);
	
}
	