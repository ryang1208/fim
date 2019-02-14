package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 投顾产品数据分析查询条件对象
 * @author sust
 *
 */
public class InvestmentProductContrastAnalysisRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strategyStr;		// 投资策略
	private String productStatus;
	private String[] strategyList;
	private String[] productStatusList;
	private String investmentName;
	public String[] getProductStatusList() {
		return productStatusList;
	}
	public void setProductStatusList(String[] productStatusList) {
		this.productStatusList = productStatusList;
	}
	public String[] getStrategyList() {
		return strategyList;
	}
	public void setStrategyList(String[] strategyList) {
		this.strategyList = strategyList;
	}
	public String getStrategyStr() {
		return strategyStr;
	}
	public void setStrategyStr(String strategyStr) {
		this.strategyStr = strategyStr;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getInvestmentName() {
		return investmentName;
	}
	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}
	
}
