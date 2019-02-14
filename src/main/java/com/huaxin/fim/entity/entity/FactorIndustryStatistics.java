package com.huaxin.fim.entity.entity;

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
 * 因子行业统计表
 */
@Entity
@Table(name = "t_factor_industry_statistics", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "factor_id", "factor_type", "industry"})})
public class FactorIndustryStatistics implements Serializable {

	private static final long serialVersionUID = 1L;
		
	// 交易日期
	@Id
	@NotNull
	@NotBlank
	@Column(name = "date", nullable = false, length = 8)
	private String date;
		
	// 因子ID
	@Id
	@NotNull
	@NotBlank
	@Column(name = "factor_id")
	private String factorID;
	
	// 因子名称
	@Column(name = "factor_name")
	private String factorName;
	
	// 因子类型(1:期货,2:证券)
	@Id
	@NotNull
	@NotBlank
	@Column(name = "factor_type")
	private String factorType;
	
	// 行业
	@Id
	@NotNull
	@NotBlank
	@Column(name = "industry")
	private String industry;
	
	// 因子收益率
	@Column(name = "yeild_rate", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal yeildRate;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFactorID() {
		return factorID;
	}

	public void setFactorID(String factorID) {
		this.factorID = factorID;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public String getFactorType() {
		return factorType;
	}

	public void setFactorType(String factorType) {
		this.factorType = factorType;
	}

	public BigDecimal getYeildRate() {
		return yeildRate;
	}

	public void setYeildRate(BigDecimal yeildRate) {
		this.yeildRate = yeildRate;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

}
