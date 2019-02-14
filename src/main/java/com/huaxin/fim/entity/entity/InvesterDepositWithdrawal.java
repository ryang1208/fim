package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 投资者出入金表对应的实体类
 * 
 */
@Entity
@Table(name = "t_invester_deposit_withdrawal", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "invester_id", "broker_id" }) })
public class 	InvesterDepositWithdrawal implements Serializable {

	private static final long serialVersionUID = 1L;

	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	// 经济公司投资者ID
	@Column(name = "invester_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String investerID;

	// 投赢汇经纪公司代号
	@Column(name = "broker_id")
	private int brokerID;
	// 出入金类型(数据字典 1004)
	@Column(name = "type_deposit_withdrawal")
	private int typeDepositWithdrawal;
	// 入金
	@Column(name = "deposit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal deposit;
	// 出金
	@Column(name = "withdrawal", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal withdrawal;
	// 说明
	@Column(name = "note", length = 128)
	@Length(min = 0, max = 128)
	private String note;
    // 数据来源
    @Column(name = "data_source")
    private int dataSource;
    // 更新日期（格式:YYYYMMDD）
    @Column(name = "update_date", length = 8)
    @Length(min = 1, max = 8)
    private String updateDate;

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public String getInvesterID() {
		return investerID;
	}

	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}

	public int getBrokerID() {
		return brokerID;
	}

	public void setBrokerID(int brokerID) {
		this.brokerID = brokerID;
	}

	public int getTypeDepositWithdrawal() {
		return typeDepositWithdrawal;
	}

	public void setTypeDepositWithdrawal(int typeDepositWithdrawal) {
		this.typeDepositWithdrawal = typeDepositWithdrawal;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
