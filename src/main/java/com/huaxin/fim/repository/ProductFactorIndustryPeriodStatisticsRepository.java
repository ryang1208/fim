package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductFactorIndustryPeriodStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品行业因子周期
 */
@Repository("productFactorIndustryPeriodStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductFactorIndustryPeriodStatistics.class)
public interface ProductFactorIndustryPeriodStatisticsRepository extends CrudRepository<ProductFactorIndustryPeriodStatistics, Long> {
	
	
	/**
	 * 根据指定kpi及产品ID及因子代码获取产品行业因子周期最新日数据
	 */
	@Query("select p from ProductFactorIndustryPeriodStatistics p "
			+ "where p.date = (select max(date) from ProductFactorIndustryPeriodStatistics where productId = :productID and kpi = :kpi and factorID in (:factorIDs)) "
			+ "and p.productId = :productID and p.kpi = :kpi and factorID in (:factorIDs)")
	public List<ProductFactorIndustryPeriodStatistics> getLastContributionData(@Param("productID") String productID,
                                                                               @Param("kpi") String kpi, @Param("factorIDs") List<String> factorIDs);
}
	