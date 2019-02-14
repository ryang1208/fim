package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FactorPeriodKPIStatistics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("factorPeriodKPIStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FactorPeriodKPIStatistics.class)
public interface FactorPeriodKPIStatisticsRepository extends CrudRepository<FactorPeriodKPIStatistics, Long> {
	
	/**
	 * 指定日期区段进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorPeriodKPIStatistics where date >= :startDate and date <= :endDate")
	public void deleteByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	/**
	 * 指定日期区段和KPI进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorPeriodKPIStatistics where date >= :startDate and date <= :endDate and KPI in :kpis")
	public void deleteByDatePeriodAndKPI(@Param("startDate") String startDate, @Param("endDate") String endDate,
                                         @Param("kpis") List<String> kpis);

	@Query("select i from FactorPeriodKPIStatistics i "
			+ "where i.date <= :date "
			+ "and i.KPI = :kpi ")
	public List<FactorPeriodKPIStatistics> findByDateBeforeAndKPI(@Param("date") String date,
                                                                  @Param("kpi") String kpi);
}
	