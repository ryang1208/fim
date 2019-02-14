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

/*
 * 基金产品净值表对应的实体类
 */
@Entity
@Table(name = "t_product_share_history")
public class ProductShareHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product_share_history") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;

	// 基金产品编号
	@Column(name = "product_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String productId;
	
	// 当前份额
	@Column(name = "init_share", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal inithare;
		
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getInithare() {
		return inithare;
	}

	public void setInithare(BigDecimal inithare) {
		this.inithare = inithare;
	}
}
