package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 基金查询结果对象(投顾产品数据分析)
 * 
 * @author liumd
 *
 */
public class InvestmentProductContrastAnalysisResponse {

	private String productId; // 产品编号
	private String productName; // 产品名称
	private String investmentName; // 投顾名称
	private String productStatus; // 产品状态
	private BigDecimal netValue; // 最新累计净值
	private BigDecimal totalShare; // 总份额
	private BigDecimal assetValue; // 资产净值
	private BigDecimal avgFundsUseRatio; // 平均资金使用率
	private BigDecimal maxFundsUseRatio; // 最大资金使用率
	private String stragegy; // 策略
	private BigDecimal yieldRatio; // 成立以来收益率
	private BigDecimal oneMonthYieldRatio; // 近一月收益率
	private BigDecimal threeMonthYieldRatio; // 近三月收益率
	private BigDecimal yearYieldRatio; // 年化收益率
	private BigDecimal maxDrawDown; // 最大回撤率
	private BigDecimal sharp; // 夏普比率
	private String createDate; // 成立日期
	private String settlementDate; // 清算日期
	private String isIndependent; //是否自主发行
	private String maxDrawdownStartDate; //最大回撤形成起期
	private String maxDrawdownEndDate; //最大回撤形成止期
	private String netValueStartDate; //投前产品净值起期
	private String netValueEndDate; //投前产品净值止期
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
	public String getInvestmentName() {
		return investmentName;
	}
	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public BigDecimal getNetValue() {
		return netValue;
	}
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}
	public BigDecimal getTotalShare() {
		return totalShare;
	}
	public void setTotalShare(BigDecimal totalShare) {
		this.totalShare = totalShare;
	}
	public BigDecimal getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(BigDecimal assetValue) {
		this.assetValue = assetValue;
	}
	public BigDecimal getAvgFundsUseRatio() {
		return avgFundsUseRatio;
	}
	public void setAvgFundsUseRatio(BigDecimal avgFundsUseRatio) {
		this.avgFundsUseRatio = avgFundsUseRatio;
	}
	public BigDecimal getMaxFundsUseRatio() {
		return maxFundsUseRatio;
	}
	public void setMaxFundsUseRatio(BigDecimal maxFundsUseRatio) {
		this.maxFundsUseRatio = maxFundsUseRatio;
	}
	public String getStragegy() {
		return stragegy;
	}
	public void setStragegy(String stragegy) {
		this.stragegy = stragegy;
	}
	public BigDecimal getYieldRatio() {
		return yieldRatio;
	}
	public void setYieldRatio(BigDecimal yieldRatio) {
		this.yieldRatio = yieldRatio;
	}
	public BigDecimal getOneMonthYieldRatio() {
		return oneMonthYieldRatio;
	}
	public void setOneMonthYieldRatio(BigDecimal oneMonthYieldRatio) {
		this.oneMonthYieldRatio = oneMonthYieldRatio;
	}
	public BigDecimal getThreeMonthYieldRatio() {
		return threeMonthYieldRatio;
	}
	public void setThreeMonthYieldRatio(BigDecimal threeMonthYieldRatio) {
		this.threeMonthYieldRatio = threeMonthYieldRatio;
	}
	public BigDecimal getYearYieldRatio() {
		return yearYieldRatio;
	}
	public void setYearYieldRatio(BigDecimal yearYieldRatio) {
		this.yearYieldRatio = yearYieldRatio;
	}
	public BigDecimal getMaxDrawDown() {
		return maxDrawDown;
	}
	public void setMaxDrawDown(BigDecimal maxDrawDown) {
		this.maxDrawDown = maxDrawDown;
	}
	public BigDecimal getSharp() {
		return sharp;
	}
	public void setSharp(BigDecimal sharp) {
		this.sharp = sharp;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getIsIndependent() {
		return isIndependent;
	}
	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}
	public String getMaxDrawdownStartDate() {
		return maxDrawdownStartDate;
	}
	public void setMaxDrawdownStartDate(String maxDrawdownStartDate) {
		this.maxDrawdownStartDate = maxDrawdownStartDate;
	}
	public String getMaxDrawdownEndDate() {
		return maxDrawdownEndDate;
	}
	public void setMaxDrawdownEndDate(String maxDrawdownEndDate) {
		this.maxDrawdownEndDate = maxDrawdownEndDate;
	}
	public String getNetValueStartDate() {
		return netValueStartDate;
	}
	public void setNetValueStartDate(String netValueStartDate) {
		this.netValueStartDate = netValueStartDate;
	}
	public String getNetValueEndDate() {
		return netValueEndDate;
	}
	public void setNetValueEndDate(String netValueEndDate) {
		this.netValueEndDate = netValueEndDate;
	}
	
}
