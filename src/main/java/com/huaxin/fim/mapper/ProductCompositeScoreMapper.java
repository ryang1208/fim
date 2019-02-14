package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.FundEvaluationReport;
import com.huaxin.fim.entity.entity.FundEvaluationReportParameter;
import com.huaxin.fim.entity.entity.ProductPeriodHisStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodStatistics;
import com.huaxin.fim.entity.request.ProductScoreRequest;
import com.huaxin.fim.entity.response.ComplexRankTitleResponse;
import com.huaxin.fim.entity.response.ProductScoreResponse;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 期货大赛评分报表
 * 
 * @author liumd
 *
 */
public interface ProductCompositeScoreMapper {

	/**
	 * 产品评分报表后台分页查询
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public List<ProductScoreResponse> getProductScoreList(
            @Param("request") ProductScoreRequest request,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay);

	/**
	 * 获取需要计算的指标及权重
	 * @return
	 */
	public List<FundEvaluationReportParameter> getReportParameterList(@Param("kpiType") String kpiType, @Param("kpiCodes") List<String> kpiCodes, @Param("reportId") String reportId, @Param("isUpdate") String isUpdate);

	/**
	 * 根据指标代码获取指定区间的指标数据
	 * @param beginDate
	 * @param endDate
	 * @param kpi
	 * @param productId
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getStatisticsListByKpi(@Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("kpi") String kpi, @Param("productId") String productId);

	/**
	 * 计算到指定日期的平均分（算数平均值）
	 * @param reportId
	 * @param productId
	 * @param kpi
	 * @param periodType
	 * @param endDate
	 * @param currentDayScore
	 * @return
	 */
	public BigDecimal getAverageScore(@Param("reportId") String reportId, @Param("productId") String productId, @Param("kpi") String kpi,
                                      @Param("periodType") String periodType, @Param("endDate") String endDate, @Param("currentDayScore") BigDecimal currentDayScore);

	/**
	 * 获取报表代码列表
	 * @return
	 */
	public List<String> getReportIdList();

	/**
	 * 获取综合排名动态表头
	 * @param reportId
	 * @return
	 */
	public List<ComplexRankTitleResponse> getTableTitleList(@Param("reportId") String reportId);

	/**
	 * 获取动态列对应指标数值及得分集合
	 * @param reportId
	 * @param date
	 * @return
	 */
	public List<FundEvaluationReport> getKpiValueAndScore(@Param("reportId") String reportId, @Param("date") String date, @Param("productId") String productId);

	/**
	 * 获取报表类型报表
	 * @return
	 */
	public List<FundEvaluationReportParameter> getReportIdTypeList();

	/**
	 * 获取年化指标数据集合
	 * @param beginDate
	 * @param endDate
	 * @param kpi
	 * @param productId
	 * @return
	 */
	public List<ProductPeriodHisStatistics> getHisStatisticsListByKpi(@Param("beginDate") String beginDate, @Param("endDate") String endDate,
																	  @Param("kpi") String kpi, @Param("productId") String productId);

	public List<ProductPeriodStatistics> getNewestStatisticsListByKpi(@Param("endDate") String endDate,
																	  @Param("kpi") String kpi, @Param("productId") String productId);

	public List<FundEvaluationReport> getKpiValueAndScoreForYearKpi(@Param("reportId") String reportId, @Param("date") String date,
                                                                    @Param("productId") String productId, @Param("kpi") String kpi);

}
