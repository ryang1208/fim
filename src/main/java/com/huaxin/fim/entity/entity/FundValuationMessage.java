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

/**
 * 基金产品估值信息表
 * 
 * @author liumd
 * @since 2017年2月23日
 * @version 1.0
 */
@Entity
@Table(name = "t_fund_valuation_message")
public class FundValuationMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_fund_valuation_message") // 适配oracle等没有主键自增长的数据库，改用sequence
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
	
	// 数据源
	@Column(name = "data_source", length = 1)
	private int dataSource;

	// 估值类型
	@Column(name = "type", length = 100)
	private String type;

	// 估值内容
	@Column(name = "value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal value;
		
		
	// 市值
	@Column(name = "market_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal market_value;
	
	// 估值
	@Column(name = "appreciation_valuation", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal appreciation_valuation;
	
	// 比例
	@Column(name = "propportion", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal propportion;

    // 更新日期（格式:YYYYMMDD）
    @Column(name = "update_date", length = 8)
    @Length(min = 1, max = 8)
    private String updateDate;
    
    // 托管机构代号（1：恒生，2：赢时胜）
 	@Column(name = "trustee_id", length = 1)
 	@Length(min = 1, max = 1)
 	@NotNull
 	@NotBlank
 	private String trusteeId;
	
	public String getTrusteeId() {
		return trusteeId;
	}

	public void setTrusteeId(String trusteeId) {
		this.trusteeId = trusteeId;
	}

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

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getMarket_value() {
		return market_value;
	}

	public void setMarket_value(BigDecimal market_value) {
		this.market_value = market_value;
	}

	public BigDecimal getAppreciation_valuation() {
		return appreciation_valuation;
	}

	public void setAppreciation_valuation(BigDecimal appreciation_valuation) {
		this.appreciation_valuation = appreciation_valuation;
	}

	public BigDecimal getPropportion() {
		return propportion;
	}

	public void setPropportion(BigDecimal propportion) {
		this.propportion = propportion;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public FundValuationMessage() {
	}

	public FundValuationMessage(String productId, String date) {
		this.date = date;
		this.productId = productId;
	}
	
	public FundValuationMessage(String productId, String date,BigDecimal market_value) {
		this.date = date;
		this.productId = productId;
		this.market_value = market_value;
	}
	
}
