package com.huaxin.fim.entity.sy.entity.financial;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 财务核算-基础参数维护
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_financial_parameter")
public class FinancialParameter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 参数代码
	@Column(name = "code", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String code;
		
	//参数名称
	@Column(name = "name", nullable = false, length = 15)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 15)
	private String name;
	
	// 参数值
	@Column(name = "value", nullable = false, length = 15)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 15)
	private String value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
