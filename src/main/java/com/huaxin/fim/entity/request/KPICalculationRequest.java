package com.huaxin.fim.entity.request;

import java.math.BigDecimal;
import java.util.List;

/**
 * 计算累计盈利，累计亏损查询条件对象
 * 
 * @author liumd
 *
 */
public class KPICalculationRequest {

	private String kpi;
	private String dataSource;
	private String productId;
	private String oneMonth;
	private String threeMonth;
	private String sixMonth;
	private String oneYear;
	private String thisYear;
	private String today;
	private String date;
	private String statDate;
	private String beginDate;
	private String endDate;
	private String reportId;
	private String group;
	private String productCreateDate;
	private BigDecimal riskFreeRate;
	private String baseKPI;
	private String indexId;
	
	private String stockType;
	private String valueGrowth;
	//证券期货类型
    private String investorType;
    
    //买卖方
    private String bs;
	
	// 指标类型（1：净值；2：结算单）
	private String kpiType;
	
	private String isProfit;// 盈利or亏损（Y：盈利，N：亏损）
	
	private List<String> kpiCodes; // 指定计算kpi
	
	private List<String> productIds; // 产品代码集合	

	private String[] strategyList;	// 投资策略列表
	private String strategyListStr;	// 投资策略
	
	private String[] statusList;	// 产品状态列表
	private String statusListStr;	// 产品状态
	
	private String isIndependent; // 是否自主发行


	public String getIsIndependent() {
		return isIndependent;
	}

	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}

	public String getStrategyListStr() {
		return strategyListStr;
	}

	public void setStrategyListStr(String strategyListStr) {
		this.strategyListStr = strategyListStr;
	}

	public String[] getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String[] strategyList) {
		this.strategyList = strategyList;
	}

	public List<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<String> productIds) {
		this.productIds = productIds;
	}

	public List<String> getKpiCodes() {
		return kpiCodes;
	}

	public void setKpiCodes(List<String> kpiCodes) {
		this.kpiCodes = kpiCodes;
	}

	public String getIsProfit() {
		return isProfit;
	}

	public void setIsProfit(String isProfit) {
		this.isProfit = isProfit;
	}

	public String getKpiType() {
		return kpiType;
	}

	public void setKpiType(String kpiType) {
		this.kpiType = kpiType;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getValueGrowth() {
		return valueGrowth;
	}

	public void setValueGrowth(String valueGrowth) {
		this.valueGrowth = valueGrowth;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	
	public String getProductCreateDate() {
		return productCreateDate;
	}

	public BigDecimal getRiskFreeRate() {
		return riskFreeRate;
	}

	public void setRiskFreeRate(BigDecimal riskFreeRate) {
		this.riskFreeRate = riskFreeRate;
	}

	public void setProductCreateDate(String productCreateDate) {
		this.productCreateDate = productCreateDate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatDate() {
		return statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getThisYear() {
		return thisYear;
	}

	public void setThisYear(String thisYear) {
		this.thisYear = thisYear;
	}

	public String getBaseKPI() {
		return baseKPI;
	}

	public void setBaseKPI(String baseKPI) {
		this.baseKPI = baseKPI;
	}

	public String getInvestorType() {
		return investorType;
	}

	public void setInvestorType(String investorType) {
		this.investorType = investorType;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String[] getStatusList() {
		return statusList;
	}

	public void setStatusList(String[] statusList) {
		this.statusList = statusList;
	}

	public String getStatusListStr() {
		return statusListStr;
	}

	public void setStatusListStr(String statusListStr) {
		this.statusListStr = statusListStr;
	}
	

}
