package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.FundEvaluationReport;
import com.huaxin.fim.entity.entity.FundEvaluationReportParameter;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.request.ProductScoreRequest;
import com.huaxin.fim.entity.response.ProductScoreResponse;

/**
 * 计算产品综合得分
 * @author liumd
 *
 */
@Gateway
public interface ProductCompositeScoreService {

	/**
	 * 计算指标得分
	 * @param list
	 * @param kpi
	 * @param parameterList
	 * @return
	 */
	public List<FundEvaluationReport> calculateProductCompositeScore(List<ProductPeriodKPIStatistics> list, String kpi, List<FundEvaluationReportParameter> parameterList);

	/**
	 * 获取产品评分报表后台分页
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public List<ProductScoreResponse> getProductScoreList(ProductScoreRequest request,
														  FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);

	/**
	 * 导出产品评分报表
	 * @param request
	 * @param columList
	 * @return
	 */
	public List<?> exportProductScoreList(ProductScoreRequest request, List<String> columList);


	/**
	 * 获取综合排名列表
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Map<String,Object> calculateFundRanking(String startDate, String endDate);


	/**
	 * 计算时间区间指标得分
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @param kpiType
	 * @param kpiCodes
	 * @return
	 */
	public Map<String,Object> calculateFundEvaluationReport(String beginDate, String endDate, String productId, String kpiType, List<String> kpiCodes);

	/**
	 * 获取综合排名动态表头
	 * @param reportId
	 * @return
	 */
	public Map<String ,Object> getTableTitleList(String reportId);

	/**
	 * 获取报表类型下拉列表
	 * @return
	 */
	public Map<String, Object> getReportIdTypeList();


	/**
	 * 计算年化指标综合得分（申万使用）
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @param kpiType
	 * @param kpiCodes
	 * @return
	 */
	public Map<String, Object> calculateFundEvaluationReportForYearKpi(String beginDate, String endDate, String productId, String kpiType, List<String> kpiCodes, String reportId);

	/**
	 * 综合排名查询（申万使用）
	 * @param pc
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public Map<String,Object> getRankingList(KPICalculationRequest pc, FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);

	/**
	 * 导出基金排名（申万使用）
	 * @param request
	 * @param columList
	 * @return
	 */
	public List<?> exportRankingList(KPICalculationRequest request, List<String> columList);
	
	public List<FundEvaluationReportParameter> getReportName();
	
	/**
	 * 计算年化指标综合得分（申万使用）
	 * @return
	 */
	public Map<String, Object> updateFundEvaluationReportForYearKpi(String reportId);

}
