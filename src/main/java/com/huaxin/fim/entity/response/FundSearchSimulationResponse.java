package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 基金查询结果对象(模拟组合查询)
 * 
 * @author liumd
 *
 */
public class FundSearchSimulationResponse {

	private String productId; // 产品编号
	private String productName; // 产品名称
	private String strategyList; // 投资策略源数据
	private String initialAsset; // 发行规模
	private String duration; // 存续期
	private BigDecimal netAccumulativeValue; // 累计净值
	private BigDecimal yieldData; // 收益率
	private BigDecimal maxDrawndownData; // 最大回撤
	private BigDecimal sharpData; // 夏普比率
	private String strategy; // 投资策略
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStrategyList() {
		return strategyList;
	}
	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	public String getInitialAsset() {
		return initialAsset;
	}
	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public BigDecimal getNetAccumulativeValue() {
		return netAccumulativeValue;
	}
	public void setNetAccumulativeValue(BigDecimal netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}
	public BigDecimal getYieldData() {
		return yieldData;
	}
	public void setYieldData(BigDecimal yieldData) {
		this.yieldData = yieldData;
	}
	public BigDecimal getMaxDrawndownData() {
		return maxDrawndownData;
	}
	public void setMaxDrawndownData(BigDecimal maxDrawndownData) {
		this.maxDrawndownData = maxDrawndownData;
	}
	public BigDecimal getSharpData() {
		return sharpData;
	}
	public void setSharpData(BigDecimal sharpData) {
		this.sharpData = sharpData;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	
	
}
