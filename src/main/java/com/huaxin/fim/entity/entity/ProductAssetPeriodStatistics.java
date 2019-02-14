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
 * 产品资产周期统计表
 * 
 * @author liumd
 * @since 20170601
 * @version 1.0
 */
@Entity
@Table(name = "t_product_asset_period_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","asset_type","product_id","KPI"})})
public class ProductAssetPeriodStatistics implements Serializable {
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
	
	// 资产类型
	@Id
	@Column(name = "asset_type", length = 50)
	@NotNull
	@NotBlank
	private String assetType;
	
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

	// 指标数据
	@Column(name = "value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal value;

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

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
