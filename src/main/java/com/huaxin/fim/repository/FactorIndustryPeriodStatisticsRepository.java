package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FactorIndustryPeriodStatistics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("factorIndustryPeriodStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FactorIndustryPeriodStatistics.class)
public interface FactorIndustryPeriodStatisticsRepository extends CrudRepository<FactorIndustryPeriodStatistics, Long> {
	
	/**
	 * 指定日期区段进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorIndustryPeriodStatistics where date >= :startDate and date <= :endDate")
	public void deleteByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	/**
	 * 指定日期区段和KPI进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorIndustryPeriodStatistics where date >= :startDate and date <= :endDate "
			+ "and KPI in :kpis")
	public void deleteByDatePeriodAndKpi(@Param("startDate") String startDate, @Param("endDate") String endDate,
                                         @Param("kpis") List<String> kpis);

	@Query("select i from FactorIndustryPeriodStatistics i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.kpi = :kpi "
			+ "and i.factorID = :factorID "
			+ "and i.industry in :industries")
	public List<FactorIndustryPeriodStatistics> findByDateBeforeAndFactorIDAndKPI(@Param("startDate") String startDate,
                                                                                  @Param("endDate") String endDate, @Param("factorID") String factorID,
                                                                                  @Param("kpi") String kpi, @Param("industries") List<String> industries);
}
	