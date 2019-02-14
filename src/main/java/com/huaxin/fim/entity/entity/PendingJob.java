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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
 *  待处理指标表对应的实体类
 */
@Entity
@Table(name = "t_pending_job" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","product_id","KPI_type"})})
public class PendingJob implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	// 日期
	@Column(name = "date", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String date;

	// 产品代码
	@Column(name = "product_id", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String productID;
	
	// 指标类型
	@Column(name = "KPI_type", length = 4)
	private int KPIType;
	
	// 指标类型
	@Column(name = "is_working", nullable = false, length = 2)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 2)
	private String isWorking;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getKPIType() {
		return KPIType;
	}

	public void setKPIType(int kPIType) {
		KPIType = kPIType;
	}

	public String getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(String isWorking) {
		this.isWorking = isWorking;
	}

	
	
}
