package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.request.FundCompareRequest;
import com.huaxin.fim.entity.response.RiskCompareResponse;
import com.huaxin.fim.entity.response.TotalDrawDownResponse;
import com.huaxin.fim.entity.response.TotalFiveDayFluctuationResponse;
import com.huaxin.fim.entity.response.TotalYieldRatioResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基金对比查询
 * @author liumd
 *
 */
public interface ContrastAnalysisMapper {
	

	/**
	 * 获取产品累计收益率
	 * @param request
	 * @return
	 */
	public List<TotalYieldRatioResponse> getYieldRatioList(@Param("request") FundCompareRequest request);

	/**
	 * 获取产品净值回撤率
	 * @param request
	 * @return
	 */
	public List<TotalDrawDownResponse> getContrastDrawDownList(@Param("request") FundCompareRequest request);

	/**
	 * 获取产品净值5日滚动波动率
	 * @param request
	 * @return
	 */
	public List<TotalFiveDayFluctuationResponse> getContrastFiveDayFluctuationList(@Param("request") FundCompareRequest request);

	/**
	 * 获取风险指标列表
	 * @param request
	 * @return
	 */
	public List<RiskCompareResponse> getRiskRatioList(@Param("request") FundCompareRequest request);

	/**
	 * 产品基本情况
	 * @param request
	 * @return
	 */
	public List<iWinProduct> getProductBasicList(@Param("request") FundCompareRequest request);

	/**
	 * 获取已选产品
	 * @param request
	 * @return
	 */
	public List<iWinProduct> getCheckedProductList(@Param("request") FundCompareRequest request);

	/**
	 * 获取可选产品
	 * @param request
	 * @return
	 */
	public List<iWinProduct> getUncheckProductList(@Param("request") FundCompareRequest request);

	/**
	 * 获取指定产品其区间最大范围
	 * @param productIds
	 * @param kpiCode
	 * @return
	 */
	public List<String> getDateListForYieldRatio(@Param("productIds") String[] productIds, @Param("kpiCode") String kpiCode);

	/**
	 * 获取指定产品净值最大区间时间列表
	 * @param productIds
	 * @return
	 */
	public List<String> getDateFromNetValue(@Param("productIds") String[] productIds);
	
}
