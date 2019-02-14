package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FundEvaluationReportParameter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("fundEvaluationReportParameterRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FundEvaluationReportParameter.class)
public interface FundEvaluationReportParameterRepository extends CrudRepository<FundEvaluationReportParameter,Long> {
	
	public FundEvaluationReportParameter findByReportIdAndKpiAndPeriodType(String reportId, String kpi, String periodType);

	/**
	 * 删除报表指标配置表
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from FundEvaluationReportParameter p "
			+ "where reportId = :reportId")
	public void delReportParameter(@Param("reportId") String reportId);


	@Query(value="select max(ser_no) from t_fund_evaluation_report_parameter "
			+ "where report_id = :reportId",nativeQuery=true)
	public String getMaxSerNo(@Param("reportId") String reportId);

	/**
	 * 删除报表指标配置表
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from FundEvaluationReportParameter p "
			+ "where reportId = :reportId and kpi is null and type is null ")
	public void delReportParameterForNullInfo(@Param("reportId") String reportId);

	public List<FundEvaluationReportParameter> findByReportId(String reportId);

	@Query(value="SELECT SUM(weight) FROM t_fund_evaluation_report_parameter WHERE report_id=:reportId AND (id<>:id or :id is null)" ,nativeQuery=true)
	public String getSumWeightByReportId(@Param("reportId") String reportId, @Param("id") String id);

	@Query(value="SELECT DISTINCT t.report_id,t.report_name,t.organization_id FROM t_fund_evaluation_report_parameter t " ,nativeQuery=true)
	public List<Object[]> getReportName();

	/**
	 * 更新报表指标配置表状态
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="update FundEvaluationReportParameter p "
			+ "set isUpdate = :isUpdate "
			+ "where reportId = :reportId")
	public void updateReportParameter(@Param("reportId") String reportId, @Param("isUpdate") String isUpdate);


	/**
	 * 更新报表机构id
	 * @param reportId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="update FundEvaluationReportParameter p "
			+ "set organizationId = :organizationId "
			+ "where reportId = :reportId")
	public void updateReportOrganizationId(@Param("reportId") String reportId, @Param("organizationId") String organizationId);
	
}	
