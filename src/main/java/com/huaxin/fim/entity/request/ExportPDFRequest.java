package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 导出pdf生成图表参数对象
 * @author liumd
 *
 */
public class ExportPDFRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060579374621048806L;
	private String periodName; // 统计周期名称
	private String indexName; // 基准指数名称
	private String confidence; // 置信度
	private String topFiveAwkwardness; // 重仓股排名类型
	private String totalIndustryFloatingProfit;// 总持仓盈亏
	
	private String queryIndexID;	// 查询用,指数代码
	private String queryPeriodType;	// 查询用,时间区间
	
	public String getTotalIndustryFloatingProfit() {
		return totalIndustryFloatingProfit;
	}
	public void setTotalIndustryFloatingProfit(String totalIndustryFloatingProfit) {
		this.totalIndustryFloatingProfit = totalIndustryFloatingProfit;
	}
	public String getTopFiveAwkwardness() {
		return topFiveAwkwardness;
	}
	public void setTopFiveAwkwardness(String topFiveAwkwardness) {
		this.topFiveAwkwardness = topFiveAwkwardness;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getConfidence() {
		return confidence;
	}
	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
	public String getQueryIndexID() {
		return queryIndexID;
	}
	public void setQueryIndexID(String queryIndexID) {
		this.queryIndexID = queryIndexID;
	}
	public String getQueryPeriodType() {
		return queryPeriodType;
	}
	public void setQueryPeriodType(String queryPeriodType) {
		this.queryPeriodType = queryPeriodType;
	}
	
}
