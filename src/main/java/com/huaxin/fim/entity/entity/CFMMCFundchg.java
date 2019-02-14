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
 * 客户出入金，对应的表t_raw_cfmmc_fundchg
 */
@Entity
@Table(name = "t_raw_cfmmc_fundchg")
public class CFMMCFundchg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_raw_cfmmc_fundchg")
	@Column(name = "id", nullable = false)
	private Long id;
	

	//日期,格式：YYYY-MM-DD
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
	
	//出入金额
	@Column(name = "in_and_out_amount", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal inAndOutAmount;
	
	//	客户结算账户或交易会员保证金专用账户银行统一标识 
	@Column(name = "customer_settlement_account", length = 10)
	@Length(min = 0, max = 10)
	private String customerSettlementAccount;
	
	//客户结算账户或交易会员保证金专用账户   
	@Column(name = "trading_member_deposit_account", length = 22)
	@Length(min = 0, max = 22)
	private String tradingMemberDepositAccount;
	
	//	期货公司保证金专用账户银行统一标识    
	@Column(name = "futures_deposit_special_account_bank_logo", length = 22)
	@Length(min = 0, max = 22)
	private String futuresDepositSpecialAccountBankLogo;
	
	//期货公司保证金专用账户           
	@Column(name = "futures_company_margin_account", length = 22)
	@Length(min = 0, max = 22)
	private String futuresCompanyMarginAccount;
	
	//备注
	@Column(name = "remark", length = 200)
	@Length(min = 0, max = 200)
	private String remark;

	//是否为交易会员
	@Column(name = "is_exchange_member", nullable = false, length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String isExchangeMember;	

	//币种
	@Column(name = "currency", nullable = false, length = 5)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 5)
	private String currency;
	
	//出入金类型
	@Column(name = "in_and_out_type", nullable = false, length = 5)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 5)
	private String inAndOutType;
	
	//出入金发生日期	 
	@Column(name = "occurrence_date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String occurrenceDate;

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

	public BigDecimal getInAndOutAmount() {
		return inAndOutAmount;
	}

	public void setInAndOutAmount(BigDecimal inAndOutAmount) {
		this.inAndOutAmount = inAndOutAmount;
	}

	public String getCustomerSettlementAccount() {
		return customerSettlementAccount;
	}

	public void setCustomerSettlementAccount(String customerSettlementAccount) {
		this.customerSettlementAccount = customerSettlementAccount;
	}

	public String getTradingMemberDepositAccount() {
		return tradingMemberDepositAccount;
	}

	public void setTradingMemberDepositAccount(String tradingMemberDepositAccount) {
		this.tradingMemberDepositAccount = tradingMemberDepositAccount;
	}

	public String getFuturesDepositSpecialAccountBankLogo() {
		return futuresDepositSpecialAccountBankLogo;
	}

	public void setFuturesDepositSpecialAccountBankLogo(String futuresDepositSpecialAccountBankLogo) {
		this.futuresDepositSpecialAccountBankLogo = futuresDepositSpecialAccountBankLogo;
	}

	public String getFuturesCompanyMarginAccount() {
		return futuresCompanyMarginAccount;
	}

	public void setFuturesCompanyMarginAccount(String futuresCompanyMarginAccount) {
		this.futuresCompanyMarginAccount = futuresCompanyMarginAccount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsExchangeMember() {
		return isExchangeMember;
	}

	public void setIsExchangeMember(String isExchangeMember) {
		this.isExchangeMember = isExchangeMember;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInAndOutType() {
		return inAndOutType;
	}

	public void setInAndOutType(String inAndOutType) {
		this.inAndOutType = inAndOutType;
	}

	public String getOccurrenceDate() {
		return occurrenceDate;
	}

	public void setOccurrenceDate(String occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}

	public CFMMCFundchg() {
	}

	public CFMMCFundchg(String date, String investerID, BigDecimal inAndOutAmount, String remark, String inAndOutType) {
		this.date = date;
		this.investerID = investerID;
		this.inAndOutAmount = inAndOutAmount;
		this.remark = remark;
		this.inAndOutType = inAndOutType;
	}
	
	
}
