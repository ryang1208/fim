package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.StyleAnalysisRequest;
import com.huaxin.fim.entity.response.TradeTypeResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 风格分析图表查询
 * @author sust
 *
 */
public interface StyleAnalysisStatisticsMapper {

	/**
	 * 日内交易类型图
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<TradeTypeResponse> getDaysTradeTypeList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);

	/**
	 * 隔夜交易类型图
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<TradeTypeResponse> getOverNightTradeTypeList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);

	/**
	 * 交易周期分布图
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<TradeTypeResponse> getTradePeriodDistributionList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);

	/**
	 * 日内交易分布图
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<TradeTypeResponse> getDaysTradeDistributionList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);

	/**
	 * 资金容量
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<TradeTypeResponse> getCapitalCapacityList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);
	
}
