package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 基金评测报表
 */
@Entity
@Table(name = "t_fund_evaluation_report", uniqueConstraints = {@UniqueConstraint(columnNames = {"date","report_id","product_id","KPI","period_type"})})
public class FundEvaluationReport implements Serializable {

	private static final long serialVersionUID = 1L;
	// 交易日期
	@Id
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	
	// 报表编号
	@Id
	@Column(name = "report_id", length = 6)
	@Length(min = 1, max = 6)
	@NotNull
	@NotBlank
	private String reportId;
	
	// 产品Id
	@Id
	@Column(name = "product_id", length = 6)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String productId;
	
	// 指标类型
	@Id
	@Column(name = "KPI", length = 6)
	@Length(min = 1, max = 6)
	@NotNull
	@NotBlank
	private String kpi;
	
	// 原始分数
	@Column(name = "origin_score", precision = 6, scale = 3)
	@Digits(integer = 3, fraction = 3)
	private BigDecimal originScore;
	
	// 平均分数（敞口比和资金使用率用）
	@Column(name = "average_score", precision = 5, scale = 2)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal averageScore;
	
	// 权重
	@Column(name = "weight", precision = 5, scale = 2)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal weight;
	
	// 加权分数
	@Column(name = "score", precision = 5, scale = 2)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal score;

	// 周期类型（近1月，近3月，近6月，近1年，今年，成立以来，同统计周期类型数据字典）
	@Id
	@Column(name = "period_type", length = 2)
	@Length(min = 1, max = 2)
	@NotNull
	@NotBlank
	private String periodType;
	
	// 指标数值
	@Column(name = "value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal value;
		
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public BigDecimal getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(BigDecimal averageScore) {
		this.averageScore = averageScore;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public BigDecimal getOriginScore() {
		return originScore;
	}

	public void setOriginScore(BigDecimal originScore) {
		this.originScore = originScore;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
