package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 因子自定义参数表（1:N对应）
 */
@Entity
@Table(name = "t_factor_custom_parameter", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "factor_id", "parameter_code"})})
public class FactorCustomParameter implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// 因子ID
	@Column(name = "factor_id")
	@NotNull
	@NotBlank
	private String factorID;
	
	// 参数代码
	@Column(name = "parameter_code")
	@NotNull
	@NotBlank
	private String parameterCode;
	
	// 参数内容描述
	@Column(name = "parameter_describe")
	private String parameterDescribe;
	
	// 参数值
	@Column(name = "parameter_value", precision = 10, scale = 4)
	@Digits(integer = 6, fraction = 4)
	private BigDecimal parameterValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFactorID() {
		return factorID;
	}

	public void setFactorID(String factorID) {
		this.factorID = factorID;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getParameterDescribe() {
		return parameterDescribe;
	}

	public void setParameterDescribe(String parameterDescribe) {
		this.parameterDescribe = parameterDescribe;
	}

	public BigDecimal getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(BigDecimal parameterValue) {
		this.parameterValue = parameterValue;
	}

}
