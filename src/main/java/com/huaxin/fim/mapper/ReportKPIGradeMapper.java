package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.Datadictionary;
import com.huaxin.fim.entity.entity.ReportKPIGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基金评测规则设置
 * @author liumd
 *
 */
public interface ReportKPIGradeMapper {

	/**
	 * 获取基金评测评分规则
	 * @param kpi
	 * @param reportId
	 * @return
	 */
	public List<ReportKPIGrade> getReportKPIGradeList(
            @Param("kpi") String kpi,
            @Param("reportId") String reportId, @Param("periodType") String periodType);

	/**
	 * 获取指标权重
	 * @param dataCode
	 * @return
	 */
	public Datadictionary getKpiWeight(
            @Param("dataCode") String dataCode);

	/**
	 * 根据报表ID删除指标得分数据
	 * @param reportId
	 */
	public void deleteKpiGradeByReportId(@Param("reportId") String reportId);

}
