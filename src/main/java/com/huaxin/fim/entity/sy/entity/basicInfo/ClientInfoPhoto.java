package com.huaxin.fim.entity.sy.entity.basicInfo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 客户信息与图片关联表
 * <br> 
 * 创建日期：2016年3月25日 上午10:36:23<br>
 * <b>Copyright 2016 上海量投网络科技有限公司 All Rights Reserved</b>
 *
 * @author 周胜兵
 * @since 1.0
 * @version 1.0
 */
@Entity
@Table(name = "t_client_info_photo", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_type","id_number","pic_type","pic_url"})} )
public class ClientInfoPhoto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	//证件类型
	@Column(name = "id_type", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String idType;
	
	//证件编号
	@Column(name = "id_number", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String idNumber;
	
	//图片类别
	@Column(name = "pic_type", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String picType;
	
	//图片url
	@Column(name = "pic_url", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String picUrl;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}
	
}
