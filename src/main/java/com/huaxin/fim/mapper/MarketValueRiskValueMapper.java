package com.huaxin.fim.mapper;


import com.huaxin.fim.entity.entity.CustomParameter;
import com.huaxin.fim.entity.entity.FundValuationMessage;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;


public interface MarketValueRiskValueMapper {
	
	/**
	 * 资产基金的估值表今天的市值
	 * @return
	 */	
	public FundValuationMessage FundMarketValue(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	
	/**
	 * 资产基金的估值表的时间权重
	 * @return
	 */	
	public FundValuationMessage rikeValueTimeWeight(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	
	/**
	 * 资产基金的时间权重
	 * @return
	 */	
	public CustomParameter TimeWeight();
	


}
