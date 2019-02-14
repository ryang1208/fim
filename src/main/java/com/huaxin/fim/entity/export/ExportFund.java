package com.huaxin.fim.entity.export;

/**
 * 
 * 描述: 导出基金
 *
 * @author 李会军
 * 
 * @date 2017年4月11日 下午5:48:54
 *
 */
public class ExportFund {

	/**
	 * 交易日期
	 */
	private String date;
	/**
	 * 夏普率
	 */
	private String sharpRatio;
	/**
	 * 最大回撤
	 */
	private String maxDrawdown;
	/**
	 * 累计净值
	 */
	private String netAccumulativeValue;
	/**
	 * 最新净值
	 */
	private String netNewestValue;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品状态
	 */
	private String productStatus;
	/**
	 * 成立日期
	 */
	private String createDate;
	/**
	 * 产品代码
	 */
	private String id;
	/**
	 * 基金经理
	 */
	private String fundManager;
	/**
	 * 产品管理人
	 */
	private String productManager;
	/**
	 * 业绩报酬
	 */
	private String performanceReward;
	/**
	 * 外包服务商
	 */
	private String outsourcingCompany;
	/**
	 * 产品类型
	 */
	private String productType;
	/**
	 * 托管机构
	 */
	private String trustee;
	/**
	 * 发行规模
	 */
	private String initialAsset;
	/**
	 * 策略
	 */
	private String strategy;
	
	/**
	 * 产品代码
	 */
	private String productCode;
	
	/**
	 * 期货投资策略
	 */
	private String futureStrategyList;
	
	/**
	 * 证券投资策略
	 */
	private String securitiesStrategyList;
	
	/**
	 * 其他投资策略
	 */
	private String otherStrategyList;
	
	/**
	 * 成立以来收益率
	 */
	private String untilNowYieldRate;
	
	/**
	 * 投资策略
	 */
	private String strategyList;
	
	/**
	 * 投顾名称
	 */
	private String investmentName;
	
	public String getFutureStrategyList() {
		return futureStrategyList;
	}
	public void setFutureStrategyList(String futureStrategyList) {
		this.futureStrategyList = futureStrategyList;
	}
	public String getSecuritiesStrategyList() {
		return securitiesStrategyList;
	}
	public void setSecuritiesStrategyList(String securitiesStrategyList) {
		this.securitiesStrategyList = securitiesStrategyList;
	}
	public String getOtherStrategyList() {
		return otherStrategyList;
	}
	public void setOtherStrategyList(String otherStrategyList) {
		this.otherStrategyList = otherStrategyList;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSharpRatio() {
		return sharpRatio;
	}
	public void setSharpRatio(String sharpRatio) {
		this.sharpRatio = sharpRatio;
	}
	public String getMaxDrawdown() {
		return maxDrawdown;
	}
	public void setMaxDrawdown(String maxDrawdown) {
		this.maxDrawdown = maxDrawdown;
	}
	public String getNetAccumulativeValue() {
		return netAccumulativeValue;
	}
	public void setNetAccumulativeValue(String netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}
	public String getNetNewestValue() {
		return netNewestValue;
	}
	public void setNetNewestValue(String netNewestValue) {
		this.netNewestValue = netNewestValue;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFundManager() {
		return fundManager;
	}
	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}
	public String getPerformanceReward() {
		return performanceReward;
	}
	public void setPerformanceReward(String performanceReward) {
		this.performanceReward = performanceReward;
	}
	public String getOutsourcingCompany() {
		return outsourcingCompany;
	}
	public void setOutsourcingCompany(String outsourcingCompany) {
		this.outsourcingCompany = outsourcingCompany;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTrustee() {
		return trustee;
	}
	public void setTrustee(String trustee) {
		this.trustee = trustee;
	}
	public String getInitialAsset() {
		return initialAsset;
	}
	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public String getUntilNowYieldRate() {
		return untilNowYieldRate;
	}
	public void setUntilNowYieldRate(String untilNowYieldRate) {
		this.untilNowYieldRate = untilNowYieldRate;
	}
	public String getStrategyList() {
		return strategyList;
	}
	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	public String getInvestmentName() {
		return investmentName;
	}
	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}
	@Override
	public String toString() {
		return "ExportFund [date=" + date + ", sharpRatio=" + sharpRatio + ", maxDrawdown=" + maxDrawdown + ", netAccumulativeValue=" + netAccumulativeValue + ", netNewestValue=" + netNewestValue
				+ ", productName=" + productName + ", productStatus=" + productStatus + ", createDate=" + createDate + ", id=" + id + ", fundManager=" + fundManager + ", productManager="
				+ productManager + ", performanceReward=" + performanceReward + ", outsourcingCompany=" + outsourcingCompany + ", productType=" + productType + ", trustee=" + trustee
				+ ", initialAsset=" + initialAsset + ", strategy=" + strategy + "]";
	}
	
}
