package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import com.huaxin.fim.entity.response.ProfitAndLossResponse;
import com.huaxin.fim.entity.response.TotalYieldAndLossResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 盈亏分析图表查询
 * @author liumd
 *
 */
public interface ProfitAndLossAnalysisStatisticsMapper {

	public List<ProfitAndLossResponse> getProfitAndLossList(
            @Param("profitAndLossRequest") AnalysisSearchRequest profitAndLossRequest);

	/**
	 * 累积盈利额（亏损额）
	 * @param profitAndLossRequest
	 * @return
	 */
	public List<TotalYieldAndLossResponse> getTotalYieldOrLoss(
            @Param("profitAndLossRequest") AnalysisSearchRequest profitAndLossRequest);
	

}
