package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import com.huaxin.fim.entity.response.CategoryResponse;
import com.huaxin.fim.entity.response.RatioResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 品种分析(债券)图表查询
 * @author sust
 *
 */
public interface BondVarietyAnalysisStatisticsMapper {

	/**
	 * 持仓不同期限债券占比图
	 * @return
	 */
	public List<CategoryResponse> getBondPaymentPeriodList(
            @Param("varietyAnalysisRequest") AnalysisSearchRequest varietyAnalysisRequest);

	/**
	 * 债券持仓评级占比
	 * @return
	 */
	public List<RatioResponse> getBondRatingList(
            @Param("varietyAnalysisRequest") AnalysisSearchRequest varietyAnalysisRequest);

	/**
	 * 债券持仓利率类型占比图
	 * @return
	 */
	public List<CategoryResponse> getBondInterestRateList(
            @Param("varietyAnalysisRequest") AnalysisSearchRequest varietyAnalysisRequest);

	/**
	 * 债券持仓评级占比
	 * @return
	 */
	public List<RatioResponse> getBondTypeList(
            @Param("varietyAnalysisRequest") AnalysisSearchRequest varietyAnalysisRequest);
	
}
