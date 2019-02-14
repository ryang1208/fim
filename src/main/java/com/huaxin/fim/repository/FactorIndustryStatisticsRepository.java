package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FactorIndustryStatistics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("factorIndustryStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FactorIndustryStatistics.class)
public interface FactorIndustryStatisticsRepository extends CrudRepository<FactorIndustryStatistics, Long> {
	
	/**
	 * 指定日期区段和资产类型进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorIndustryStatistics where date >= :startDate and date <= :endDate and (factorType = :factorType or :factorType is null)")
	public void deleteByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("factorType") String factorType);
	
	/**
	 * 指定日期区段、资产类型和因子代码进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorIndustryStatistics where date >= :startDate and date <= :endDate "
			+ "and (factorType = :factorType or :factorType is null) "
			+ "and factorID in :factorIDs")
	public void deleteByDatePeriodAndFactors(@Param("startDate") String startDate, @Param("endDate") String endDate,
                                             @Param("factorType") String factorType, @Param("factorIDs") List<String> factorIDs);

	/**
	 * 按指定日期和因子代码获取数据
	 */
	public List<FactorIndustryStatistics> findByDateAndFactorID(@Param("date") String date, @Param("factorID") String factorID);

	/**
	 * 根据因子代码获取数据
	 */
	public List<FactorIndustryStatistics> findByFactorID(@Param("factorID") String factorID);

	@Query("select f from FactorIndustryStatistics f where f.date <= :date and f.factorID = :factorID")
	public List<FactorIndustryStatistics> findByDateBeforeAndFactorID(@Param("date") String date, @Param("factorID") String factorID);

	/**
	 * 获取因子指定行业数据
	 * @param date
	 * @param factorID
	 * @param kpi
	 * @param industries
	 * @return
	 */
	@Query("select i from FactorIndustryStatistics i "
			+ "where i.date <= :date "
			+ "and i.factorID = :factorID "
			+ "and i.industry in :industries "
			+ "ORDER BY i.date,i.industry")
	public List<FactorIndustryStatistics> findByDateBeforeAndFactorID(@Param("date") String date,
                                                                      @Param("factorID") String factorID, @Param("industries") List<String> industries);
}
	