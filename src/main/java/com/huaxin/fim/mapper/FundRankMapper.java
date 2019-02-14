package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.FundRank;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.response.ProductRankResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 期货大赛评分报表
 * 
 * @author liumd
 *
 */
public interface FundRankMapper {
 

	/**
	 * 计算综合排名
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<FundRank> calculateFundRanking(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 删除综合排名
	 *
	 * @param request
	 * @return
	 */
	public void deleteFundRank(
            @Param("kpiCalculationRequest") KPICalculationRequest request);

	/**
	 * 删除指标得分
	 * @param request
	 */
	public void deleteEvaluationReport(@Param("kpiCalculationRequest") KPICalculationRequest request);

	/**
	 * 计算综合排名
	 *
	 * @return
	 */
	public List<ProductRankResponse> calculateFundRankingForYearKpi(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay);
	
}
