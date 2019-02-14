package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Index;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository("indexRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = Index.class)
public interface IndexRepository extends CrudRepository<Index, Long> {
	
	/**
	 * 日期区间正收益率
	 */
	@Query(value = "select i from Index i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.dailyYieldRate is not null and i.dailyYieldRate >= 0 "
			+ "and i.indexId = :indexId "
			+ "order by i.date")
	public List<Index> findPlusYieldRateByDatePeriod(@Param("startDate") String startDate,
                                                     @Param("endDate") String endDate, @Param("indexId") String indexId);

	/**
	 * 日期区间负收益率
	 */
	@Query(value = "select i from Index i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.dailyYieldRate is not null and i.dailyYieldRate < 0 "
			+ "and i.indexId = :indexId "
			+ "order by i.date")
	public List<Index> findMinusYieldRateByDatePeriod(@Param("startDate") String startDate,
                                                      @Param("endDate") String endDate, @Param("indexId") String indexId);

	/**
	 * 日期区间收益率
	 */
	@Query(value = "select i from Index i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.dailyYieldRate is not null "
			+ "and i.indexId = :indexId "
			+ "order by i.date")
	public List<Index> findYieldRateByDatePeriod(@Param("startDate") String startDate,
                                                 @Param("endDate") String endDate, @Param("indexId") String indexId);

	/**
	 * 日期区间某基准数据
	 */
	@Query(value = "select i from Index i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.indexId = :indexId "
			+ "order by i.date")
	public List<Index> findIndexByDatePeriod(@Param("startDate") String startDate,
                                             @Param("endDate") String endDate, @Param("indexId") String indexId);

	/**
	 * 日期收益率
	 */
	@Query(value = "select i from Index i "
			+ "where (i.date = :statdate or :statdate is null) "
			+ "and i.dailyYieldRate is not null "
			+ "and i.indexId = :indexId ")
	public Index findYieldRateByDate(@Param("statdate") String statdate, @Param("indexId") String indexId);


	public List<Index> findByDate(@Param("date") String date);

	/**
	 * 日期区间某基准数据
	 */
	@Query(value = "select i from Index i where i.indexId = :indexId order by i.date")
	public List<Index> findIndexByIndexID(@Param("indexId") String indexId);

	@Query("select i from Index i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null)")
	public List<Index> findByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from Index i "
			+ "where i.date in :date and (i.indexId = :indexId)")
	public void delByDates(@Param("date") Set<String> date, @Param("indexId") String indexId);

	/**
	 * 根据日期删除合约
	 * @param date
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" delete from   t_index  where date=:date",nativeQuery=true)
	public void delIndexByDate(@Param("date") String date);

	/**
	 * 根据指数名称删除指数
	 * @param name
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" delete from  t_index  where index_name = :indexName ",nativeQuery=true)
	public void delIndexByIndexName(@Param("indexName") String indexName);

	/**
	 * 日期区间多个指数收益率
	 */
	@Query(value = "select i from Index i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.dailyYieldRate is not null "
			+ "and i.indexName in (:indexNames) "
			+ "order by i.date")
	public List<Index> findYieldRateByDatePeriodAndIdxs(@Param("startDate") String startDate,
                                                        @Param("endDate") String endDate, @Param("indexNames") List<String> indexNames);

	/**
	 * 根据基准指数信息表名称及日期区间获取指数收益率
	 */
	@Query(value = "select i from Index i,IndexInfo f "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.dailyYieldRate is not null "
			+ "and f.id = :indexId "
			+ "and i.indexName = f.indexName "
			+ "order by i.date")
	public List<Index> findYieldRateByPeriodAndIndexInfoID(@Param("startDate") String startDate,
                                                           @Param("endDate") String endDate, @Param("indexId") Long indexId);

	/**
	 * 更新指数名称
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("update Index set indexName = :indexName where indexName = :indexOldName ")
	public void updateIndexByIndexName(@Param("indexName") String indexName, @Param("indexOldName") String indexOldName);
}
	