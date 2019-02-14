package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/*
 * 产品个股因子周期统计表对应的实体类
 */
@Embeddable
@Entity
@Table(name = "t_product_factor_period_kpi_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","product_id","KPI", "factor_id"})})

public class ProductFactorPeriodKPIStatistics implements Serializable {

	private static final long serialVersionUID = 1L;

	// 交易日期
	@Id
	@Column(name = "date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String date;

	// 基金产品编号
	@Id
	@Column(name = "product_id", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String productID;
	
	// 指标代码
	@Id
	@Column(name = "KPI", nullable = false, length = 6)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 6)
	private String KPI;
	
	// 个股因子代码
	@Id
	@Column(name = "factor_id", nullable = false, length = 6)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 6)
	private String factorID;
	
	// 数据来源
	@Column(name = "data_source", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String dataSource;
	
	// 统计日期
	@Column(name = "stat_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String statDate;
	
	// 当日
	@Column(name = "today", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal today;

	// 近1月
	@Column(name = "one_month", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal oneMonth;
	
	// 近3月
	@Column(name = "three_month", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal threeMonth;
	
	// 近6月
	@Column(name = "six_month", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal sixMonth;
	
	// 近1年
	@Column(name = "one_year", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal oneYear;	
	
	// 成立至今
	@Column(name = "until_now", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal untilNow;
	
	// 今年度
	@Column(name = "this_year", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal thisYear;

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getKPI() {
		return KPI;
	}

	public void setKPI(String kPI) {
		KPI = kPI;
	}

	public String getFactorID() {
		return factorID;
	}

	public void setFactorID(String factorID) {
		this.factorID = factorID;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getStatDate() {
		return statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	public BigDecimal getToday() {
		return today;
	}

	public void setToday(BigDecimal today) {
		this.today = today;
	}

	public BigDecimal getOneMonth() {
		return oneMonth;
	}

	public void setOneMonth(BigDecimal oneMonth) {
		this.oneMonth = oneMonth;
	}

	public BigDecimal getThreeMonth() {
		return threeMonth;
	}

	public void setThreeMonth(BigDecimal threeMonth) {
		this.threeMonth = threeMonth;
	}

	public BigDecimal getSixMonth() {
		return sixMonth;
	}

	public void setSixMonth(BigDecimal sixMonth) {
		this.sixMonth = sixMonth;
	}

	public BigDecimal getOneYear() {
		return oneYear;
	}

	public void setOneYear(BigDecimal oneYear) {
		this.oneYear = oneYear;
	}

	public BigDecimal getUntilNow() {
		return untilNow;
	}

	public void setUntilNow(BigDecimal untilNow) {
		this.untilNow = untilNow;
	}

	public BigDecimal getThisYear() {
		return thisYear;
	}

	public void setThisYear(BigDecimal thisYear) {
		this.thisYear = thisYear;
	}
	
}
