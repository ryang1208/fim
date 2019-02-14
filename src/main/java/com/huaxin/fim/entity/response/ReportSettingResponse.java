package com.huaxin.fim.entity.response;


import com.huaxin.fim.entity.entity.FundEvaluationReportParameter;

import java.io.Serializable;
import java.util.List;

/**
 * 基金评价配置页面查询结果
 * @author liumd
 *
 */
public class ReportSettingResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String reportId;
	private String reportName;
	private List<FundEvaluationReportParameter> kpiDetails;
	private String organizationId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<FundEvaluationReportParameter> getKpiDetails() {
		return kpiDetails;
	}
	public void setKpiDetails(List<FundEvaluationReportParameter> kpiDetails) {
		this.kpiDetails = kpiDetails;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
	
}
