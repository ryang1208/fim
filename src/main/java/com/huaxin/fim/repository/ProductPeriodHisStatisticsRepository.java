package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductPeriodHisStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductPeriodHisStatistics.class)
@Named("productPeriodHisStatisticsRepository")
public interface ProductPeriodHisStatisticsRepository extends CrudRepository<ProductPeriodHisStatistics, Long> {
	
	public List<ProductPeriodHisStatistics> findAll();
	
	@Query("select i from ProductPeriodHisStatistics i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.productID = :productID "
			+ "and i.KPI = :KPI "
			+ "and i.periodType in (:periodTypes)")
	public List<ProductPeriodHisStatistics> findByCondition(@Param("startDate") String startDate,
                                                            @Param("endDate") String endDate, @Param("productID") String productID,
                                                            @Param("KPI") String KPI, @Param("periodTypes") List<String> periodTypes);

	/**
	 * 获取相关KPI
	 */
	@Query(value = "select p from ProductPeriodHisStatistics p "
			+ "where p.KPI = :KPI "
			+ "and (p.productID = :productID or :productID is null) "
			+ "and p.statDate = :statDate "
			+ "order by p.productID,p.date")
	public List<ProductPeriodHisStatistics> findProductKPIsByProductIdAndKPI(@Param("productID") String productID, @Param("KPI") String KPI, @Param("statDate") String statDate);
	
}	