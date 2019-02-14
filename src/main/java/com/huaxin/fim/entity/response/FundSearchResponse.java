package com.huaxin.fim.entity.response;

/**
 * 基金查询结果对象
 * 
 * @author liumd
 *
 */
public class FundSearchResponse {

	private String productId; // 产品编号
	private String productCode; // 产品代码
	private String productName; // 产品名称
	private String productShortName; // 产品全称
	private String strategyList;	// 策略列表
	private String fundTrustee; // 基金管理人
	private String fundManager; // 基金经理
	private String initialAsset; // 发行规模
	private String createDate; // 成立日期
	private String riskReturnRatio; // 风报比
	private String netNewestValue; // 最新净值
	private String maxDrawDown; // 最大回撤
	private String today; // 收益率（当日）
	private String oneMonth; // 收益率（1月内）
	private String threeMonth; // 收益率（3月内）
	private String sixMonth; // 收益率（6月内）
	private String oneYear; // 收益率（一年内）
	private String untilNow; // 收益率（成立以来）
	private String thisYear; // 收益率（当年）
	private String todayDrawDown; // 当日回撤率
	private String oneMonthDrawDown;
	private String threeMonthDrawDown;
	private String sixMonthDrawDown;
	private String oneYearDrawDown;
	private String untilNowDrawDown;
	private String thisYearDrawDown;
	private String todaySharpRatio; // 当日sharp
	private String oneMonthSharpRatio;
	private String threeMonthSharpRatio;
	private String sixMonthSharpRatio;
	private String oneYearSharpRatio;
	private String untilNowSharpRatio;
	private String thisYearSharpRatio;
	private String todayCalmarRatio; // 当日卡玛
	private String oneMonthCalmarRatio;
	private String threeMonthCalmarRatio;
	private String sixMonthCalmarRatio;
	private String oneYearCalmarRatio;
	private String untilNowCalmarRatio;
	private String thisYearCalmarRatio;
	private String netAccumulativeValue; // 累计净值
	private String sharpRatio; // 夏普比率
	private String sortinoRatio; //索提诺比率
	private String calmarRatio; //卡玛比率
	private String statDate; // 统计日期
	private String date; // 最新净值日期
	private String productStatus; // 产品状态
	private String productType; // 基金类型
	private String attentionStatu;//关注状态

	private String strategy; // 投资策略
	private String qupdateDate;//持仓更新日期
	private String qdataSource;//持仓数据来源
	private String xupdateDate;//净值数据更新日期
	private String xdataSource;//净值数据来源
	private String fupdateDate;//资金更新日期
	private String fdataSource;//资金数据来源
	private String deliveryDate;//交割更新日期
	private String deliverySource;//交割数据来源
	private String isParentProduct; // 是否为母基金（0：否,1：是）
	private String xDate;//净值最新日期
	

	public String getIsParentProduct() {
		return isParentProduct;
	}

	public void setIsParentProduct(String isParentProduct) {
		this.isParentProduct = isParentProduct;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getAttentionStatu() {
		return attentionStatu;
	}

	public void setAttentionStatu(String attentionStatu) {
		this.attentionStatu = attentionStatu;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
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
	
	

	public String getSortinoRatio() {
		return sortinoRatio;
	}

	public void setSortinoRatio(String sortinoRatio) {
		this.sortinoRatio = sortinoRatio;
	}

	public String getCalmarRatio() {
		return calmarRatio;
	}

	public void setCalmarRatio(String calmarRatio) {
		this.calmarRatio = calmarRatio;
	}

	public String getStatDate() {
		return statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
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

	public String getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getRiskReturnRatio() {
		return riskReturnRatio;
	}

	public void setRiskReturnRatio(String riskReturnRatio) {
		this.riskReturnRatio = riskReturnRatio;
	}

	public String getNetNewestValue() {
		return netNewestValue;
	}

	public void setNetNewestValue(String netNewestValue) {
		this.netNewestValue = netNewestValue;
	}

	public String getMaxDrawDown() {
		return maxDrawDown;
	}

	public void setMaxDrawDown(String maxDrawDown) {
		this.maxDrawDown = maxDrawDown;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getOneMonth() {
		return oneMonth;
	}

	public void setOneMonth(String oneMonth) {
		this.oneMonth = oneMonth;
	}

	public String getThreeMonth() {
		return threeMonth;
	}

	public void setThreeMonth(String threeMonth) {
		this.threeMonth = threeMonth;
	}

	public String getSixMonth() {
		return sixMonth;
	}

	public void setSixMonth(String sixMonth) {
		this.sixMonth = sixMonth;
	}

	public String getOneYear() {
		return oneYear;
	}

	public void setOneYear(String oneYear) {
		this.oneYear = oneYear;
	}

	public String getUntilNow() {
		return untilNow;
	}

	public void setUntilNow(String untilNow) {
		this.untilNow = untilNow;
	}

	public String getThisYear() {
		return thisYear;
	}

	public void setThisYear(String thisYear) {
		this.thisYear = thisYear;
	}

	public String getTodayDrawDown() {
		return todayDrawDown;
	}

	public void setTodayDrawDown(String todayDrawDown) {
		this.todayDrawDown = todayDrawDown;
	}

	public String getOneMonthDrawDown() {
		return oneMonthDrawDown;
	}

	public void setOneMonthDrawDown(String oneMonthDrawDown) {
		this.oneMonthDrawDown = oneMonthDrawDown;
	}

	public String getThreeMonthDrawDown() {
		return threeMonthDrawDown;
	}

	public void setThreeMonthDrawDown(String threeMonthDrawDown) {
		this.threeMonthDrawDown = threeMonthDrawDown;
	}

	public String getSixMonthDrawDown() {
		return sixMonthDrawDown;
	}

	public void setSixMonthDrawDown(String sixMonthDrawDown) {
		this.sixMonthDrawDown = sixMonthDrawDown;
	}

	public String getOneYearDrawDown() {
		return oneYearDrawDown;
	}

	public void setOneYearDrawDown(String oneYearDrawDown) {
		this.oneYearDrawDown = oneYearDrawDown;
	}

	public String getUntilNowDrawDown() {
		return untilNowDrawDown;
	}

	public void setUntilNowDrawDown(String untilNowDrawDown) {
		this.untilNowDrawDown = untilNowDrawDown;
	}

	public String getThisYearDrawDown() {
		return thisYearDrawDown;
	}

	public void setThisYearDrawDown(String thisYearDrawDown) {
		this.thisYearDrawDown = thisYearDrawDown;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQupdateDate() {
		return qupdateDate;
	}

	public void setQupdateDate(String qupdateDate) {
		this.qupdateDate = qupdateDate;
	}

	public String getXupdateDate() {
		return xupdateDate;
	}

	public void setXupdateDate(String xupdateDate) {
		this.xupdateDate = xupdateDate;
	}

	public String getQdataSource() {
		return qdataSource;
	}

	public void setQdataSource(String qdataSource) {
		this.qdataSource = qdataSource;
	}

	public String getXdataSource() {
		return xdataSource;
	}

	public void setXdataSource(String xdataSource) {
		this.xdataSource = xdataSource;
	}

	public String getFupdateDate() {
		return fupdateDate;
	}

	public void setFupdateDate(String fupdateDate) {
		this.fupdateDate = fupdateDate;
	}

	public String getFdataSource() {
		return fdataSource;
	}

	public void setFdataSource(String fdataSource) {
		this.fdataSource = fdataSource;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliverySource() {
		return deliverySource;
	}

	public void setDeliverySource(String deliverySource) {
		this.deliverySource = deliverySource;
	}

	public String getTodaySharpRatio() {
		return todaySharpRatio;
	}

	public void setTodaySharpRatio(String todaySharpRatio) {
		this.todaySharpRatio = todaySharpRatio;
	}

	public String getOneMonthSharpRatio() {
		return oneMonthSharpRatio;
	}

	public void setOneMonthSharpRatio(String oneMonthSharpRatio) {
		this.oneMonthSharpRatio = oneMonthSharpRatio;
	}

	public String getThreeMonthSharpRatio() {
		return threeMonthSharpRatio;
	}

	public void setThreeMonthSharpRatio(String threeMonthSharpRatio) {
		this.threeMonthSharpRatio = threeMonthSharpRatio;
	}

	public String getSixMonthSharpRatio() {
		return sixMonthSharpRatio;
	}

	public void setSixMonthSharpRatio(String sixMonthSharpRatio) {
		this.sixMonthSharpRatio = sixMonthSharpRatio;
	}

	public String getOneYearSharpRatio() {
		return oneYearSharpRatio;
	}

	public void setOneYearSharpRatio(String oneYearSharpRatio) {
		this.oneYearSharpRatio = oneYearSharpRatio;
	}

	public String getUntilNowSharpRatio() {
		return untilNowSharpRatio;
	}

	public void setUntilNowSharpRatio(String untilNowSharpRatio) {
		this.untilNowSharpRatio = untilNowSharpRatio;
	}

	public String getThisYearSharpRatio() {
		return thisYearSharpRatio;
	}

	public void setThisYearSharpRatio(String thisYearSharpRatio) {
		this.thisYearSharpRatio = thisYearSharpRatio;
	}

	public String getTodayCalmarRatio() {
		return todayCalmarRatio;
	}

	public void setTodayCalmarRatio(String todayCalmarRatio) {
		this.todayCalmarRatio = todayCalmarRatio;
	}

	public String getOneMonthCalmarRatio() {
		return oneMonthCalmarRatio;
	}

	public void setOneMonthCalmarRatio(String oneMonthCalmarRatio) {
		this.oneMonthCalmarRatio = oneMonthCalmarRatio;
	}

	public String getThreeMonthCalmarRatio() {
		return threeMonthCalmarRatio;
	}

	public void setThreeMonthCalmarRatio(String threeMonthCalmarRatio) {
		this.threeMonthCalmarRatio = threeMonthCalmarRatio;
	}

	public String getSixMonthCalmarRatio() {
		return sixMonthCalmarRatio;
	}

	public void setSixMonthCalmarRatio(String sixMonthCalmarRatio) {
		this.sixMonthCalmarRatio = sixMonthCalmarRatio;
	}

	public String getOneYearCalmarRatio() {
		return oneYearCalmarRatio;
	}

	public void setOneYearCalmarRatio(String oneYearCalmarRatio) {
		this.oneYearCalmarRatio = oneYearCalmarRatio;
	}

	public String getUntilNowCalmarRatio() {
		return untilNowCalmarRatio;
	}

	public void setUntilNowCalmarRatio(String untilNowCalmarRatio) {
		this.untilNowCalmarRatio = untilNowCalmarRatio;
	}

	public String getThisYearCalmarRatio() {
		return thisYearCalmarRatio;
	}

	public void setThisYearCalmarRatio(String thisYearCalmarRatio) {
		this.thisYearCalmarRatio = thisYearCalmarRatio;
	}

	public String getxDate() {
		return xDate;
	}

	public void setxDate(String xDate) {
		this.xDate = xDate;
	}
	
	
}
