package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FactorStatistics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("factorStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FactorStatistics.class)
public interface FactorStatisticsRepository extends CrudRepository<FactorStatistics, Long> {
	
	/**
	 * 获取单合约因子缺失数据的日期集合
	 */
	@Query(value = "SELECT DISTINCT i.date "
			+ "FROM t_index i "
			+ "WHERE i.date NOT IN ("
			+ "SELECT DISTINCT fs.date "
			+ "FROM t_factor_statistics fs ) "
			+ "ORDER BY i.date ", nativeQuery = true)
	public List<String> getLossDataDates();
	
	/**
	 * 指定日期区段和资产类型进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorStatistics where date >= :startDate and date <= :endDate and (factorType = :factorType or :factorType is null)")
	public void deleteByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("factorType") String factorType);
	
	/**
	 * 指定日期区段、资产类型和指定因子代码进行数据删除
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from FactorStatistics where date >= :startDate and date <= :endDate "
			+ "and (factorType = :factorType or :factorType is null) "
			+ "and factorID in :factorIDs")
	public void deleteByDatePeriodAndFactors(@Param("startDate") String startDate, @Param("endDate") String endDate,
                                             @Param("factorType") String factorType, @Param("factorIDs") List<String> factorIDs);
	
	/**
	 * 指定日期、指标、资产类型进行查询
	 */
	@Query("select f from FactorStatistics f "
			+ "where f.date = :date "
			+ "and (f.factorID = :factorID or :factorID is null) "
			+ "and (f.factorType = :factorType or :factorType is null)")
	public List<FactorStatistics> findByCondition(@Param("date") String date, @Param("factorID") String factorID, @Param("factorType") String factorType);
	
	/**
	 * 查找指定日期之前的数据
	 */
	@Query("select f from FactorStatistics f where f.date <= :date")
	public List<FactorStatistics> findByDateBefore(@Param("date") String date);
}
	