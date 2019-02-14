package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 各分析页面图表查询条件对象
 * @author liumd
 *
 */
public class AnalysisSearchRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060579374621048806L;
	private String periodType;
	private String beginDate;
	private String endDate;
	private String productId;
	private String kpiCode;
	private String periodTypes;
	//期末持股集中度的传值
	private String concentrationOnStockID;
	//传kpi的值
	private String kpi;
	
	private String indexID;
	
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public String getConcentrationOnStockID() {
		return concentrationOnStockID;
	}
	public void setConcentrationOnStockID(String concentrationOnStockID) {
		this.concentrationOnStockID = concentrationOnStockID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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
	public String getPeriodTypes() {
		return periodTypes;
	}
	public void setPeriodTypes(String periodTypes) {
		this.periodTypes = periodTypes;
	}
	
}
