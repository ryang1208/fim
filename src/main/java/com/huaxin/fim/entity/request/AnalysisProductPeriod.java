package com.huaxin.fim.entity.request;

import java.io.Serializable;
import java.util.List;

/**
 * 指标统计查询条件参数对象
 * @author sust
 *
 */
public class AnalysisProductPeriod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//指标
	private String KPI;
	//数据来源
	private String dataSource;
	//统计日
	private String statDate;
	//前日
	private String yesterday;
	//前一个月
	private String oneMonth;
	//前三个月
	private String threeMonth;
	//前六个月
	private String sixMonth;
	//前一年
	private String oneYear;
	//今年度
	private String thisYear;
	//产品编号
	private String productID;
	//统计起始日
	private String startDate;
	//统计终止日
	private String endDate;
	//买卖方向
	private String bs;
	//开平方向
	private String oc;
	// 指标类型（1：净值；2：结算单）
	private String kpiType;
	
	private List<String> kpiCodes;
	
	private List<String> productIds;
	
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
	public String getKpiType() {
		return kpiType;
	}
	public void setKpiType(String kpiType) {
		this.kpiType = kpiType;
	}
	private int compareAwkwardness; 
	
	public int getCompareAwkwardness() {
		return compareAwkwardness;
	}
	public void setCompareAwkwardness(int compareAwkwardness) {
		this.compareAwkwardness = compareAwkwardness;
	}
	public String getKPI() {
		return KPI;
	}
	public void setKPI(String kPI) {
		KPI = kPI;
	}
	public String getStatDate() {
		return statDate;
	}
	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getYesterday() {
		return yesterday;
	}
	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
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
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public String getOc() {
		return oc;
	}
	public void setOc(String oc) {
		this.oc = oc;
	}
	
	
}
