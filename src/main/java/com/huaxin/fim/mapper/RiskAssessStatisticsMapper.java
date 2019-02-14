package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.RiskAssessRequest;
import com.huaxin.fim.entity.response.DrawDownResponse;
import com.huaxin.fim.entity.response.FluctionResponse;
import com.huaxin.fim.entity.response.PositionResponse;
import com.huaxin.fim.entity.response.RiskCycleResponse;
import com.huaxin.fim.entity.response.RiskDegreeResponse;
import com.huaxin.fim.entity.response.RiskIndicatorResponse;
import com.huaxin.fim.entity.response.RiskIndicatorsResponse;
import com.huaxin.fim.entity.response.RiskValueNinetyFiveResponse;
import com.huaxin.fim.entity.response.RiskValueNinetynineResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 风险评估图表查询
 * @author sust
 *
 */
public interface RiskAssessStatisticsMapper {

	/**
	 * 每日仓位曲线
	 * @param riskAssessRequest
	 * @return
	 */
	public List<PositionResponse> getPositionList(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);

	/**
	 * 账户风险度
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskDegreeResponse> getRiskDegreeList(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);
	/**
	 * 账户仓位风险度
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskDegreeResponse> getPositionRiskDegreeList(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);

	/**
	 * 净值回撤率
	 * @param riskAssessRequest
	 * @return
	 */
	public List<DrawDownResponse> getDrawDownList(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);



	/**
	 * 净值5日波动率
	 * @param riskAssessRequest
	 * @return
	 */
	public List<FluctionResponse> getFluctuationList(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);

	/**
	 * 风险指标
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskIndicatorResponse> getRiskIndicator(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);
	/**
	 * 风险指标
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskIndicatorsResponse> getRiskIndicators(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);
	/**
	 * 风险价值99%
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskValueNinetynineResponse> getRiskVlueNinetynine(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);

	/**
	 * 风险价值95%
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskValueNinetyFiveResponse> getRiskVlueNinetyFive(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);

	/**
	 * 风险指标
	 * @param riskAssessRequest
	 * @return
	 */
	public List<RiskCycleResponse> getRiskCycle(
            @Param("riskAssessRequest") RiskAssessRequest riskAssessRequest);
}
