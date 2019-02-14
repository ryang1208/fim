package com.huaxin.fim.entity.response;

import java.io.Serializable;

/**
 * 综合排名表格动态表头返回对象
 * @author liumd
 *
 */
public class ComplexRankTitleResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reportId;
	private String reportName;
	private String kpi;
	private String kpiDescribe;
	private String periodType;
	private String periodName;
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public String getKpiDescribe() {
		return kpiDescribe;
	}
	public void setKpiDescribe(String kpiDescribe) {
		this.kpiDescribe = kpiDescribe;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	
}
