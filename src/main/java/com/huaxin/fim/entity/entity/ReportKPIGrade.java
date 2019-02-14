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
 * 基金评测指标分级表
 */
@Entity
@Table(name = "t_report_kpi_grade")
public class ReportKPIGrade implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="seq_t_report_kpi_grade")	
	@Column(name = "id")
	private Long id;
	
	private static final long serialVersionUID = 1L;
	// 报表名称
	@Column(name = "report_id", length = 6)
	@Length(min = 1, max = 6)
	@NotNull
	@NotBlank
	private String reportId;
	
	// 指标类型
	@Column(name = "KPI", length = 6)
	@Length(min = 1, max = 6)
	@NotNull
	@NotBlank
	private String kpi;
	
	// 分级下线
	@Column(name = "grade_floor", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal gradeFloor;
		
	// 分级上线
	@Column(name = "grade_ceiling", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal gradeCeiling;
	
	// 分级分数
	@Column(name = "grade_score", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal gradeScore;

	// 周期类型（近1月，近3月，近6月，近1年，今年，成立以来，同统计周期类型数据字典）
	@Column(name = "period_type", length = 2)
	@Length(min = 1, max = 2)
	@NotNull
	@NotBlank
	private String periodType;
		
	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
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

	public BigDecimal getGradeFloor() {
		return gradeFloor;
	}

	public void setGradeFloor(BigDecimal gradeFloor) {
		this.gradeFloor = gradeFloor;
	}

	public BigDecimal getGradeCeiling() {
		return gradeCeiling;
	}

	public void setGradeCeiling(BigDecimal gradeCeiling) {
		this.gradeCeiling = gradeCeiling;
	}

	public BigDecimal getGradeScore() {
		return gradeScore;
	}

	public void setGradeScore(BigDecimal gradeScore) {
		this.gradeScore = gradeScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
