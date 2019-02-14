package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 基金评测参数配置对象
 */
@Entity
@Table(name = "t_fund_evaluation_report_parameter")
public class FundEvaluationReportParameter implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_fund_evaluation_report_parameter") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 报表编号
	@Column(name = "report_id", length = 6)
	@Length(min = 1, max = 6)
	@NotNull
	@NotBlank
	private String reportId;
	
	// 指标类型
	@Column(name = "KPI", length = 6)
	@Length(min = 0, max = 6)
	private String kpi;

	// 报表名称
	@Column(name = "report_name", length = 100)
	@Length(min = 1, max = 100)
	@NotNull
	@NotBlank
	private String reportName;
	
	@Column(name = "ser_no", length = 6)
	@Length(min = 0, max = 6)
	private String serNo;
	
	// 权重
	@Column(name = "weight", precision = 5, scale = 2)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal weight;
	
	// 指标类型（1：定性，2：定量）
	@Column(name = "type", length = 2)
	private String type;

	// 计算类型（源数据，加权，平均值）
	@Column(name = "calculate_type", length = 2)
	@Length(min = 0, max = 2)
	private String calculateType;
	
	
	// 周期类型（近1月，近3月，近6月，近1年，今年，成立以来，同统计周期类型数据字典）
	@Column(name = "period_type", length = 2)
	@Length(min = 0, max = 2)
	private String periodType;
	
	// 机构代码
	@Column(name = "organization_id", length = 10)
	@Length(min = 1, max = 10)
	private String organizationId;
	
	// 是否更新
	@Column(name = "is_update", length = 2)
	@Length(min = 0, max = 2)
	private String isUpdate;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

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

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getSerNo() {
		return serNo;
	}

	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getCalculateType() {
		return calculateType;
	}

	public void setCalculateType(String calculateType) {
		this.calculateType = calculateType;
	}

	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

}
