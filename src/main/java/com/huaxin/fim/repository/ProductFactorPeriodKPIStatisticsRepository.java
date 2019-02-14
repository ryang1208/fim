package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductFactorPeriodKPIStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品因子周期
 */
@Repository("productFactorPeriodKPIStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductFactorPeriodKPIStatistics.class)
public interface ProductFactorPeriodKPIStatisticsRepository extends CrudRepository<ProductFactorPeriodKPIStatistics, Long> {
	
	
	/**
	 * 根据指定kpi及产品ID及因子代码获取产品因子周期最新日数据
	 */
	@Query("select p from ProductFactorPeriodKPIStatistics p "
			+ "where p.date = (select max(a.date) from ProductFactorPeriodKPIStatistics a where a.productID = :productID "
			+ "and a.KPI = :kpi and a.factorID in (:factorIDs)) "
			+ "and p.productID = :productID and p.KPI = :kpi and p.factorID in (:factorIDs)")
	public List<ProductFactorPeriodKPIStatistics> getLastContributionData(@Param("productID") String productID,
                                                                          @Param("kpi") String kpi, @Param("factorIDs") List<String> factorIDs);
}
	