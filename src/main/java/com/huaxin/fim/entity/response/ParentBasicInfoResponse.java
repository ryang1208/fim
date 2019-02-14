package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 母子基金基本信息
 * 
 * @author liumd
 *
 */
public class ParentBasicInfoResponse {

	private String productId; // 产品代码
	private String productName; // 产品名称
	private String strategyList; // 投资策略
	private BigDecimal initialAsset; // 发行规模
	private BigDecimal initialAssetRatio; // 发行规模占比
	private String fundTrustee; // 基金管理人
	private String fundManager; // 基金经理
	private BigDecimal netAccumulativeValue; // 累计净值
	private BigDecimal yearRatio; // 年化收益率
	private BigDecimal maxDrawdown; // 成立以来最大回撤
	private String strategyStr;// 投资策略
	private BigDecimal sharpRatio; // 夏普比率
	private String productStatus; // 产品状态
	private String createDate; // 成立日期
	private BigDecimal yieldRatio; //成立以来收益率
	private String isParentProduct; // 是否母基金（0：否，1：是）
	private String productType; // 产品类型
	private BigDecimal riskReturnRatio; // 收益回撤比（风报比）

	public BigDecimal getRiskReturnRatio() {
		return riskReturnRatio;
	}

	public void setRiskReturnRatio(BigDecimal riskReturnRatio) {
		this.riskReturnRatio = riskReturnRatio;
	}

	private String period; // 产品存续期
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getIsParentProduct() {
		return isParentProduct;
	}

	public void setIsParentProduct(String isParentProduct) {
		this.isParentProduct = isParentProduct;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getYieldRatio() {
		return yieldRatio;
	}

	public void setYieldRatio(BigDecimal yieldRatio) {
		this.yieldRatio = yieldRatio;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getSharpRatio() {
		return sharpRatio;
	}

	public void setSharpRatio(BigDecimal sharpRatio) {
		this.sharpRatio = sharpRatio;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getStrategyStr() {
		return strategyStr;
	}

	public void setStrategyStr(String strategyStr) {
		this.strategyStr = strategyStr;
	}

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

	public BigDecimal getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(BigDecimal initialAsset) {
		this.initialAsset = initialAsset;
	}

	public BigDecimal getInitialAssetRatio() {
		return initialAssetRatio;
	}

	public void setInitialAssetRatio(BigDecimal initialAssetRatio) {
		this.initialAssetRatio = initialAssetRatio;
	}

	public String getFundTrustee() {
		return fundTrustee;
	}

	public void setFundTrustee(String fundTrustee) {
		this.fundTrustee = fundTrustee;
	}

	public String getFundManager() {
		return fundManager;
	}

	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}

	public BigDecimal getNetAccumulativeValue() {
		return netAccumulativeValue;
	}

	public void setNetAccumulativeValue(BigDecimal netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}

	public BigDecimal getYearRatio() {
		return yearRatio;
	}

	public void setYearRatio(BigDecimal yearRatio) {
		this.yearRatio = yearRatio;
	}

	public BigDecimal getMaxDrawdown() {
		return maxDrawdown;
	}

	public void setMaxDrawdown(BigDecimal maxDrawdown) {
		this.maxDrawdown = maxDrawdown;
	}
}
