package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
 * 系统自定义参数表对应的实体类
 */
@Entity
@Table(name = "t_custom_parameter")

public class CustomParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 参数代码
	@Id
	@Column(name = "parameter_code", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String parameterCode;

	// 参数内容描述
	@Column(name = "parameter_describe", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String parameterDescribe;
	
	// 参数内容
	@Column(name = "parameter_value", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String parameterValue;

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

	/**
	 *  获取系统参数值(字符串)
	 * @return 系统参数值(字符串)
	 */
	public String getParameterValue() {
		return parameterValue;
	}
	
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	@Override
	public String toString() {
		return "CustomParameter [parameterCode=" + parameterCode + ", parameterDescribe=" + parameterDescribe
				+ ", parameterValue=" + parameterValue + "]";
	}
}
