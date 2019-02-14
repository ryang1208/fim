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

/**
 * 模拟组合构建产品净值表
 * @author liumd
 *
 */
@Entity
@Table(name = "t_simulation_product_net_value")
public class SimulationProductNetValue implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_simulation_product_net_value")
	@Column(name = "id")
	private long id;

	private static final long serialVersionUID = 1L;

	// 产品代码
	@Column(name = "product_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String productId;

	// 交易日期
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;

	// 单位净值
	@Column(name = "net_asset_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal netAssetValue;

	// 累计净值
	@Column(name = "net_accumulative_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal netAccumulativeValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
