package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 基金评价设置查询参数对象
 * @author liumd
 *
 */
public class ReportSettingRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// 报表名称
	private String reportName;
	// 报表Id
	private String reportId;
	// kpi
	private String kpi;
	// 周期
	private String periodType;
	
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
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
	
}
