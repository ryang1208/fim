package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
 * 投赢汇数据字典对应的实体类
 */
@Embeddable
@Entity
@Table(name = "t_foreign_data_dictionary" , uniqueConstraints = {@UniqueConstraint(columnNames = {"data_type","data_code"})})
public class ForeignDataDictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8556014430413510938L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product") 
	// 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	// 数据代码
	@Id
	@Column(name = "data_code", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String dataCode;
	
	// 数据类型
	@Id
	@Column(name = "data_type", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String dataType;
	
	// 数据内容描述
	@Id
	@Column(name = "data_describe", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String dataDescribe;
	
	// 数据类型描述
	@Column(name = "data_type_describe", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String dataTypeDescribe;
	
	// 数据内容
	@Column(name = "data_value", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String dataValue;
	
	// 序号
	@Column(name = "ser_no", nullable = false, length = 11)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 11)
	private int serno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataDescribe() {
		return dataDescribe;
	}

	public void setDataDescribe(String dataDescribe) {
		this.dataDescribe = dataDescribe;
	}

	public String getDataTypeDescribe() {
		return dataTypeDescribe;
	}

	public void setDataTypeDescribe(String dataTypeDescribe) {
		this.dataTypeDescribe = dataTypeDescribe;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	
	public int getSerno() {
		return serno;
	}

	public void setSerno(int serno) {
		this.serno = serno;
	}

	public ForeignDataDictionary(){
		
	}

	public ForeignDataDictionary(Long id,String dataType, String dataTypeDescribe) {
		this.id = id;
		this.dataType = dataType;
		this.dataTypeDescribe = dataTypeDescribe;
	}
}
