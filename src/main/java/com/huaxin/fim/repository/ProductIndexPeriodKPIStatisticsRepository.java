package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductIndexPeriodKPIStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品指数周期
 */
@Repository("productIndexPeriodKPIStatisticsRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductIndexPeriodKPIStatistics.class)
public interface ProductIndexPeriodKPIStatisticsRepository extends CrudRepository<ProductIndexPeriodKPIStatistics, Long> {
	
	@Query("select i from ProductIndexPeriodKPIStatistics i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and i.productID = :productID "
			+ "and i.KPI = :KPI "
			+ "and i.indexID in (:indexIDs) "
			+ "and i.periodType in (:periodTypes)")
	public List<ProductIndexPeriodKPIStatistics> findByCondition(@Param("startDate") String startDate,
                                                                 @Param("endDate") String endDate, @Param("productID") String productID,
                                                                 @Param("KPI") String KPI, @Param("indexIDs") List<String> indexIDs, @Param("periodTypes") List<String> periodTypes);

	@Query("select i from ProductIndexPeriodKPIStatistics i "
			+ "where i.date = ("
			+ "select max(t.date) from ProductIndexPeriodKPIStatistics t "
			+ "where t.productID = :productID and t.KPI in (:KPIs) "
			+ "and t.indexID = :indexID and t.periodType = :periodType) "
			+ "and i.productID = :productID "
			+ "and i.KPI in (:KPIs) "
			+ "and i.indexID = :indexID "
			+ "and i.periodType = :periodType")
	public List<ProductIndexPeriodKPIStatistics> findMaxDateInfoByCondition(@Param("productID") String productID,
                                                                            @Param("KPIs") List<String> KPIs, @Param("indexID") String indexID, @Param("periodType") String periodType);

	@Query("select p from ProductIndexPeriodKPIStatistics p "
			+ "where CONCAT(p.date,'#',p.KPI,'#',p.indexID,'#',p.periodType) in ( "
			+ "select CONCAT(MAX(w.date),'#',w.KPI,'#',w.indexID,'#',w.periodType) "
			+ "from ProductIndexPeriodKPIStatistics w "
			+ "where w.productID = :productID and w.KPI in (:kpis) "
			+ "and w.indexID = :indexID and periodType = :periodType "
			+ "group by w.KPI) "
			+ "and p.productID = :productID ")
	public List<ProductIndexPeriodKPIStatistics> findMaxDateRiskAssets(@Param("productID") String productID,
                                                                       @Param("kpis") List<String> kpis, @Param("indexID") String indexID, @Param("periodType") String periodType);
	
}
	