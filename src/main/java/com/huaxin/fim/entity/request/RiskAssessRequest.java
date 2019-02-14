package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 风险评估图表查询条件对象
 * @author sust
 *
 */
public class RiskAssessRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060579374621048806L;
	private String periodType;
	private String beginDate;
	private String endDate;
	private String productId;
	private String kpiCode;
	private String checkriskvalue;
	private String checkriskvaluea;
	
	private String indexcode;
	private String formactionKpi;
	private String cycleKpi;
	
	public String getCheckriskvalue() {
		return checkriskvalue;
	}
	public void setCheckriskvalue(String checkriskvalue) {
		this.checkriskvalue = checkriskvalue;
	} 
	public String getCheckriskvaluea() {
		return checkriskvaluea;
	}
	public void setCheckriskvaluea(String checkriskvaluea) {
		this.checkriskvaluea = checkriskvaluea;
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
	public String getIndexcode() {
		return indexcode;
	}
	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}
	public String getFormactionKpi() {
		return formactionKpi;
	}
	public void setFormactionKpi(String formactionKpi) {
		this.formactionKpi = formactionKpi;
	}
	public String getCycleKpi() {
		return cycleKpi;
	}
	public void setCycleKpi(String cycleKpi) {
		this.cycleKpi = cycleKpi;
	}
	
	
	
}
