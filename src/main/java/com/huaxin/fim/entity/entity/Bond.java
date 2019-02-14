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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 基金产品对应的实体类
 */
@Entity
@Table(name = "t_bond" , uniqueConstraints = {
		@UniqueConstraint(columnNames = {"bond_id","exchange_id"}) }	)
public class Bond implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	// 债券代码
	@Column(name = "bond_id", length = 20)
	@Length(min = 1, max = 20)
	@NotNull
	@NotBlank
	private String bondId;
	// 交易所代码
	@Column(name = "exchange_id", length = 32)
	@Length(min = 0, max = 32)
	@NotNull
	@NotBlank
	private String exchangeId;
	// 债券内部编码
	@Column(name = "bond_inner_id", length = 50)
	@Length(min = 0, max = 50)
	@NotNull
	@NotBlank
	private String bondInnerId;
	// 债券名称
	@Column(name = "bond_name")
	private String bondName;
	// 起息日期
	@Column(name = "value_date")
	private String valueDate;
	// 到期日期
	@Column(name = "due_date")
	private String dueDate;
	// 利率类型
	@Column(name = "interest_rate_type")
	private String interestRateType;
	// 债券类型
	@Column(name = "bond_type")
	private String bondType;
	// 票面利率
	@Column(name = "coupon_rate", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal couponRate;
	// 年度付息频率
	@Column(name = "pay_interest_frequency")
	private int payInterestFrequency;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBondId() {
		return bondId;
	}
	public void setBondId(String bondId) {
		this.bondId = bondId;
	}
	public String getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
	public String getBondInnerId() {
		return bondInnerId;
	}
	public void setBondInnerId(String bondInnerId) {
		this.bondInnerId = bondInnerId;
	}
	public String getBondName() {
		return bondName;
	}
	public void setBondName(String bondName) {
		this.bondName = bondName;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getInterestRateType() {
		return interestRateType;
	}
	public void setInterestRateType(String interestRateType) {
		this.interestRateType = interestRateType;
	}
	public String getBondType() {
		return bondType;
	}
	public void setBondType(String bondType) {
		this.bondType = bondType;
	}
	public BigDecimal getCouponRate() {
		return couponRate;
	}
	public void setCouponRate(BigDecimal couponRate) {
		this.couponRate = couponRate;
	}
	public int getPayInterestFrequency() {
		return payInterestFrequency;
	}
	public void setPayInterestFrequency(int payInterestFrequency) {
		this.payInterestFrequency = payInterestFrequency;
	}
	
	
}
