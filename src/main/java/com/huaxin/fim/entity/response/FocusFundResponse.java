package com.huaxin.fim.entity.response;

/**
 * 关注基金结果对象
 * 
 * @author wangdl
 *
 */
public class FocusFundResponse {
	// 关注状态
	private String focusStatus;
	// 产品名称
	private String productName;
	// 基金管理人--具体从哪张表或得待定
	private String fundManagerMan;
	// 整合后的投资策略:包含下边的三种策略，每种策略可能是多个值,显示时用"/"分隔
	private String investedStrategy;
	// 期货投资策略
	private String futureStrategyList;
	// 证券投资策略
	private String securitiesStrategyList;
	// 其他投资策略
	private String otherStrategyList;
	// 投资策略
	private String strategyList;
	// 基金经理
	private String fundManager;
	// 成立日期
	private String createDate;
	// 最新净值
	private String netNewestValue;
	// 今年以来收益率:KPI--020032
	private String thisYear;
	// 发行规模
	private String initialAsset; 
	// 产品ID
	private String productId; 
	// 产品状态
	private String productStatus;
	// 产品类型
	private String productType;
	// 最大回撤
	private String maxDrawDown; 
	// 累计净值
	private String netAccumulativeValue;
	// sharp比率
	private String sharpRatio;
	// 基金管理人
	private String fundTrustee;
	// 净值日期
	private String date;
	// 产品编号
	private String productCode;
	// 是否是母基金
	private String isParentProduct;

	public String getIsParentProduct() {
		return isParentProduct;
	}

	public void setIsParentProduct(String isParentProduct) {
		this.isParentProduct = isParentProduct;
	}

	public String getFocusStatus() {
		return focusStatus;
	}

	public void setFocusStatus(String focusStatus) {
		this.focusStatus = focusStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFundManagerMan() {
		return fundManagerMan;
	}

	public void setFundManagerMan(String fundManagerMan) {
		this.fundManagerMan = fundManagerMan;
	}

	public String getInvestedStrategy() {
		return investedStrategy;
	}

	public void setInvestedStrategy(String investedStrategy) {
		this.investedStrategy = investedStrategy;
	}

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

	public String getFundManager() {
		return fundManager;
	}

	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getNetNewestValue() {
		return netNewestValue;
	}

	public void setNetNewestValue(String netNewestValue) {
		this.netNewestValue = netNewestValue;
	}

	public String getThisYear() {
		return thisYear;
	}

	public void setThisYear(String thisYear) {
		this.thisYear = thisYear;
	}

	public String getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getMaxDrawDown() {
		return maxDrawDown;
	}

	public void setMaxDrawDown(String maxDrawDown) {
		this.maxDrawDown = maxDrawDown;
	}

	public String getNetAccumulativeValue() {
		return netAccumulativeValue;
	}

	public void setNetAccumulativeValue(String netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}

	public String getSharpRatio() {
		return sharpRatio;
	}

	public void setSharpRatio(String sharpRatio) {
		this.sharpRatio = sharpRatio;
	}

	public String getFundTrustee() {
		return fundTrustee;
	}

	public void setFundTrustee(String fundTrustee) {
		this.fundTrustee = fundTrustee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	
}
