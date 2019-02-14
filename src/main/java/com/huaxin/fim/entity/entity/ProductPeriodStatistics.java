package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/*
 * 产品周期统计表对应的实体类
 */
@Embeddable
@Entity
@Table(name = "t_product_period_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","product_id","KPI","period_type"})})
public class ProductPeriodStatistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// 交易日期
	@Column(name = "date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String date;

	// 基金产品编号
	@Column(name = "product_id", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String productID;
	
	// 指标代码
	@Column(name = "KPI", nullable = false, length = 6)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 6)
	private String KPI;
	
	// 统计周期
	@Column(name = "period_type", nullable = false, length = 5)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 5)
	private String periodType;
	
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
	@Column(name = "value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal value;

	@Transient
	private String productName;
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Transient
	private BigDecimal netAccumulativeValue;
	public BigDecimal getNetAccumulativeValue() {
		return netAccumulativeValue;
	}

	public void setNetAccumulativeValue(BigDecimal netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
