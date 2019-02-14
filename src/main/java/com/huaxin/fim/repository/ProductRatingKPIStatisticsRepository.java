package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductRatingKpiStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 产品指数周期
 */
@Repository("productRatingKPIStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductRatingKpiStatistics.class)
public interface ProductRatingKPIStatisticsRepository extends CrudRepository<ProductRatingKpiStatistics, Long> {
	
	
}
	