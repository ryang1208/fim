package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 品种表
 */
@Entity
@Table(name = "t_variety")
public class Variety implements Serializable {

	private static final long serialVersionUID = 1L;
	// 品种代码
	@Id
	@Column(name = "variety_id", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String varietyID;
	// 品种名称
	@Column(name = "variety_name", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String varietyName;
	// 交易所(见数据字典)
	@Column(name = "exchange_id", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String exchangeID;
	// 交易单位
	@Column(name = "exchange_unit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	@NotNull
	@NotBlank
	private BigDecimal exchangeUnit;
	// 品种类型(见数据字典)
	@Column(name = "classify", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String classify;
	// 是否优先使用
	@Column(name = "is_priority", length = 2)
	@Length(min = 1, max = 2)
	@NotNull
	@NotBlank
	private String isPriority;
		
	public String getVarietyID() {
		return varietyID;
	}

	public void setVarietyID(String varietyID) {
		this.varietyID = varietyID;
	}

	public String getVarietyName() {
		return varietyName;
	}

	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public BigDecimal getExchangeUnit() {
		return exchangeUnit;
	}

	public void setExchangeUnit(BigDecimal exchangeUnit) {
		this.exchangeUnit = exchangeUnit;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

}
