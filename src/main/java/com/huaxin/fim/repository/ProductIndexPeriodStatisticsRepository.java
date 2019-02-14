package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductIndexPeriodStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品指数周期最新一天
 */
@Repository("productIndexPeriodStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductIndexPeriodStatistics.class)
public interface ProductIndexPeriodStatisticsRepository extends CrudRepository<ProductIndexPeriodStatistics, Long> {

	@Query("select p from ProductIndexPeriodStatistics p where "
			+ "p.productID = :productID and p.KPI in (:kpis) "
			+ "and p.indexID = :indexID ")
	public List<ProductIndexPeriodStatistics> findRiskAssets(@Param("productID") String productID,
                                                             @Param("kpis") List<String> kpis, @Param("indexID") String indexID);
	
}
	