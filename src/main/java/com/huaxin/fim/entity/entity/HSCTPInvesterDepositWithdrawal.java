package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * ctp出入金原始表
 * 
 */
@Entity
@Table(name = "t_raw_HS_invester_deposit_withdrawal")
public class HSCTPInvesterDepositWithdrawal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//日期
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	//客户内部资金账户
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;
	
	
	//入金
	@Column(name = "deposit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal deposit;
	
	//出金
	@Column(name = "withdrawal", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal withdrawal;
	
	//注释
	@Column(name = "note",  length = 128)
	@Length(min = 0, max = 128)
	private String note;

	// 数据来源
	@Column(name = "data_source")
	private int dataSource;
	
	// 币种
	@Column(name = "currency")
	private String currency;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInvesterID() {
		return investerID;
	}

	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(BigDecimal withdrawal) {
		this.withdrawal = withdrawal;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
