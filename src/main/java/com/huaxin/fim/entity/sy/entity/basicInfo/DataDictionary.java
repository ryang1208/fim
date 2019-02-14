package com.huaxin.fim.entity.sy.entity.basicInfo;

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
 * 数据字典
 * @author xieky
 *
 */
@Entity
@Table(name = "t_data_dictionary")
public class DataDictionary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	//数据字典类型
	@Column(name = "data_type", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String dataType;
	
	//数据字典类型描述
	@Column(name = "data_type_des", nullable = false, length = 100)
	@Length(min = 0, max = 100)
	private String dataTypeDes;

	//数据字典描述
	@Column(name = "data_des", nullable = false, length = 100)
	@Length(min = 0, max = 100)
	private String dataDes;
	
	//数据字典描述
	@Column(name = "data_code", nullable = false, length = 100)
	@Length(min = 0, max = 100)
	private String dataCode;
	
	//数据字典值
	@Column(name = "data_value", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String dataValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataTypeDes() {
		return dataTypeDes;
	}

	public void setDataTypeDes(String dataTypeDes) {
		this.dataTypeDes = dataTypeDes;
	}

	public String getDataDes() {
		return dataDes;
	}

	public void setDataDes(String dataDes) {
		this.dataDes = dataDes;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	
}
