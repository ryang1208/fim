package com.huaxin.fim.entity.request;

/**
 * 归因分析图表查询条件对象
 *
 */
public class AttributionAnalysisRequest{

	private String periodType;
	private String beginDate;
	private String endDate;
	private String productId;
	private String kpiCode;
	private String indexID;
	
	public String getKpiCode() {
		return kpiCode;
	}
	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getIndexID() {
		return indexID;
	}
	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}
	
}
