package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
 * KPI指标字典对应的实体类
 */
@Embeddable
@Entity
@Table(name = "t_kpi_dictionary" , uniqueConstraints = {@UniqueConstraint(columnNames = {"KPI","type"})})

public class KPIDictionary implements Serializable {

	// 指标代码
	@Id
	@Column(name = "KPI", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String KPI;

	// 指标描述
	@Column(name = "KPI_describe", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String KPIDescribe;
	
	// 指标类型
	@Id
	@Column(name = "type", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String type;
	
	// 交易日期
	@Column(name = "type_discribe", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String typeDiscribe;

	public String getKPI() {
		return KPI;
	}

	public void setKPI(String kPI) {
		KPI = kPI;
	}

	public String getKPIDescribe() {
		return KPIDescribe;
	}

	public void setKPIDescribe(String kPIDescribe) {
		KPIDescribe = kPIDescribe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeDiscribe() {
		return typeDiscribe;
	}

	public void setTypeDiscribe(String typeDiscribe) {
		this.typeDiscribe = typeDiscribe;
	}
	
}
