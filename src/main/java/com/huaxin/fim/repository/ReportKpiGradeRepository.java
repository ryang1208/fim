package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ReportKPIGrade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("reportKpiGradeRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ReportKPIGrade.class)
public interface ReportKpiGradeRepository extends CrudRepository<ReportKPIGrade,Long> {
	
	public List<ReportKPIGrade> findByReportIdAndKpiAndPeriodType(String reportId, String kpi, String periodType);

	public List<ReportKPIGrade> findByReportId(String reportId);

	/**
	 * 删除报表指标配置表
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ReportKPIGrade p "
			+ "where reportId = :reportId and kpi = :kpi and periodType = :periodType ")
	public void delByrReportIdAndKpiAndPeriodType(@Param("reportId") String reportId, @Param("kpi") String kpi, @Param("periodType") String periodType);


	/**
	 * 删除报表指标配置表
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ReportKPIGrade p "
			+ "where reportId = :reportId ")
	public void delByrReportId(@Param("reportId") String reportId);

	/**
	 * 删除报表指标配置表
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="update ReportKPIGrade set kpi=:kpi ,periodType = :periodType  "
			+ "where reportId = :reportId and kpi = :oldKpi and periodType = :oldPeriodType ")
	public void updateByReportIdAndKpiAndPeriodType(@Param("reportId") String reportId, @Param("kpi") String kpi, @Param("periodType") String periodType,
                                                    @Param("oldKpi") String oldKpi, @Param("oldPeriodType") String oldPeriodType);
}	
