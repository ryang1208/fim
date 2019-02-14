package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductIndustryPeriodStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品行业Respository对象
 *
 */
@Repository("productIndustryPeriodStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductIndustryPeriodStatistics.class)
public interface ProductIndustryPeriodStatisticsRepository extends CrudRepository<ProductIndustryPeriodStatistics, Long> {
	
	
	@Query(value="select i from ProductIndustryPeriodStatistics i "
			+ "where i.date = :date "
			+ "and i.kpi = '020089' and i.productId = :productID "
			+ "order by i.today desc")
	public List<ProductIndustryPeriodStatistics> findIndustryProfitDesc(@Param("productID") String productID, @Param("date") String date);

	/**
	 * 根据指定kpi及产品ID获取最大日期
	 * @param productID
	 * @param kpi
	 * @return
	 */
	@Query(value="SELECT MAX(DATE) FROM t_product_industry_period_statistics t WHERE t.product_id=:productID AND t.KPI=:kpi",nativeQuery=true)
	public String getMaxDateByKpi(@Param("productID") String productID, @Param("kpi") String kpi);

	//根据产品id和和kpi获取行业周期表数据
	@Query(value="select i from ProductIndustryPeriodStatistics i "
			+ "where i.kpi = :kpi "
			+ "and i.productId = :productId "
			+ "order by i.date ")
	public  List<ProductIndustryPeriodStatistics> findIndustryByProductIdAndKPI(@Param("productId") String productId, @Param("kpi") String kpi);

	//根据产品id和和kpi获取行业周期表数据
	@Query(value="SELECT 														"
			+"  p.date DATE,                                                    "
			+"  p.industry industry,                                            "
			+"  IFNULL(baseYieldTemp.today,0) baseYield,                        "
			+"  IFNULL(baseWeightTemp.today,0) baseWeight,                      "
			+"  IFNULL(yieldTemp.today,0) yield,                                "
			+"  IFNULL(weightTemp.today,0) weight                               "
			+"FROM                                                              "
			+"  t_position_summary p                                            "
			+"  LEFT JOIN t_product_invester_relationship tp                    "
			+"    ON p.invester_id = tp.invester_id                             "
			+"    AND p.broker_id = tp.broker_id                                "
			+"  LEFT JOIN t_product_industry_period_statistics baseYieldTemp    "
			+"    ON baseYieldTemp.date = p.date                                "
			+"    AND baseYieldTemp.product_id = tp.product_id                  "
			+"    AND baseYieldTemp.industry = p.industry                       "
			+"    AND baseYieldTemp.KPI = :yieldKpi                             "
			+"  LEFT JOIN t_product_industry_period_statistics baseWeightTemp   "
			+"    ON baseWeightTemp.date = p.date                               "
			+"    AND baseWeightTemp.product_id = tp.product_id                 "
			+"    AND baseWeightTemp.industry = p.industry                      "
			+"    AND baseWeightTemp.KPI = :weightKpi                           "
			+"  LEFT JOIN t_product_industry_period_statistics yieldTemp        "
			+"    ON yieldTemp.product_id = tp.product_id                       "
			+"    AND yieldTemp.date = p.date                                   "
			+"    AND yieldTemp.industry = p.industry                           "
			+"    AND yieldTemp.KPI = 030063                                    "
			+"  LEFT JOIN t_product_industry_period_statistics weightTemp       "
			+"    ON weightTemp.product_id = tp.product_id                      "
			+"    AND weightTemp.date = p.date                                  "
			+"    AND weightTemp.industry = p.industry                          "
			+"    AND weightTemp.KPI = 030064                                   "
			+"WHERE p.industry IS NOT NULL                                      "
			+"  AND tp.product_id = :productId                                  "
			+"GROUP BY p.date,p.industry " , nativeQuery = true)
	public  List<Object[]> findIndustryByProductIdAndIndexKPI(@Param("productId") String productId,
                                                              @Param("yieldKpi") String yieldKpi, @Param("weightKpi") String weightKpi);

	/**
	 * 获取最新一天需要计算成交额的产品代码列表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT                                 "
				+" DISTINCT  t.product_id                   "
				+" FROM                                   "
				+"   t_product_industry_period_statistics t     "
				+" WHERE t.date = :date    ",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);
}

	