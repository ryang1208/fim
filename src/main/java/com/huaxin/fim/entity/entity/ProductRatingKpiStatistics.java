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
 * 产品指数周期统计历史表对应的实体类(保存指标：信息比率，特雷诺比率，年化跟踪误差最新一天指标数据)
 */
@Embeddable
@Entity
@Table(name = "t_product_rating_kpi_statistics" , uniqueConstraints = {@UniqueConstraint(
		columnNames = {"date", "product_id", "KPI", "organization", "rating"})})

public class ProductRatingKpiStatistics implements Serializable {

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
	
	// 机构
	@Id
	@Column(name = "organization", nullable = false, length = 30)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String organization;
	
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
	
	// 债项评级
	@Id
	@Column(name = "rating", nullable = false, length = 30)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String rating;
	
	// 数据值
	@Column(name = "value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal value;

	
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	

}
