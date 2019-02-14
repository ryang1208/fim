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

/**
 * 产品行业周期统计表
 * 
 * @author liumd
 * @since 20170601
 * @version 1.0
 */
@Entity
@Table(name = "t_product_industry_period_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","industry","product_id","KPI"})})
public class ProductIndustryPeriodStatistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;


	// 交易日期（格式:YYYYMMDD）
	// 交易日期
	@Id
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	
	// 产品代码
	@Id
	@Column(name = "product_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String productId;

	// 行业
	@Id
	@Column(name = "industry", length = 50)
	@NotNull
	@NotBlank
	private String industry;
	
	// 指标代码
	@Id
	@Column(name = "kpi", length = 6)
	@NotNull
	@NotBlank
	private String kpi;
	
	// 数据源
	@Column(name = "data_source", length = 100)
	@NotNull
	@NotBlank
	private String dataSource;
	
	// 统计日期
	@Column(name = "stat_date", length = 8)
	@NotNull
	@NotBlank
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
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
