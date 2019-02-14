package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
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
 * 基金产品净值表对应的元数据实体类
 */
@Entity
@Table(name = "t_raw_qdiam_product_net_value", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "product_id"})})
public class RawQDIAMProductNetValue implements Serializable{

	private static final long serialVersionUID = -7665438803504962359L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	
	// 基金产品编号
	@Column(name = "product_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String productID;
	// 单位基金净值
	@Column(name = "net_asset_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal netAssetValue;
	// 累计基金净值
	@Column(name = "net_accumulative_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal netAccumulativeValue;
	// 资产净值
	@Column(name = "asset_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal assetValue;
	// 总份额
	@Column(name = "total_share", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal totalShare;	
	// 数据来源
	@Column(name = "data_source")
	private int dataSource;
	
	@Transient
	private String qdiamProductCode;

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

	public BigDecimal getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(BigDecimal netAssetValue) {
		this.netAssetValue = netAssetValue;
	}


	public BigDecimal getNetAccumulativeValue() {
		return netAccumulativeValue;
	}

	public void setNetAccumulativeValue(BigDecimal netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}
	
	public BigDecimal getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(BigDecimal assetValue) {
		this.assetValue = assetValue;
	}

	public BigDecimal getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(BigDecimal totalShare) {
		this.totalShare = totalShare;
	}

	public String getQdiamProductCode() {
		return qdiamProductCode;
	}

	public void setQdiamProductCode(String qdiamProductCode) {
		this.qdiamProductCode = qdiamProductCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
