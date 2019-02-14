package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.ProductDailyKPIStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 投资账户每日统计表对应的实体类
 * @author xieky
 *
 */
@Repository(value = "ProductDailyKPIStatisticsRepository")
@EntityClass(entityClass = ProductDailyKPIStatistics.class)
public interface ProductDailyKPIStatisticsRepository extends CrudRepository<ProductDailyKPIStatistics, Long>{

	@Query("select p from ProductDailyKPIStatistics p,iWinProduct d where "
			+ "p.date = (select max(c.date) from ProductDailyKPIStatistics c where c.productID = d.id) "
			+ "AND p.productID = d.id "
			+ "AND d.productName =:productName")
	public ProductDailyKPIStatistics findMaxDateNetNewValue(@Param("productName") String productName);
	
}
