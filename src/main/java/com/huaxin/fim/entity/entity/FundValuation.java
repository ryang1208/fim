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
 * 基金产品估值表
 * 
 * @author liumd
 * @since 2017年2月23日
 * @version 1.0
 */
@Entity
@Table(name = "t_fund_valuation_table")
public class FundValuation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_fund_valuation_table") // 适配oracle等没有主键自增长的数据库，改用sequence
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

	// 科目代码（一级）
	@Column(name = "account_code", length = 50)
	private String accountCode;
	
	// 科目名称（一级）
	@Column(name = "account_name", length = 100)
	private String accountName;
	
	// 数量
	@Column(name = "amount", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal amount;
	
	// 单位成本
	@Column(name = "unit_cost", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal unitCost;
	
	// 成本
	@Column(name = "cost", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal cost;
	
	// 成本占净值
	@Column(name = "net_value_cost_ratio", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal netValueCostRatio;
	
	// 市价
	@Column(name = "market_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal marketValue;
	
	// 市值
	@Column(name = "market_capitalization", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal marketCapitalization;
	
	// 市值占净值
	@Column(name = "net_value_market_capitalization_value", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal netValueMarketCapitalizationValue;
	
	// 估值增值
	@Column(name = "appreciation_valuation", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal appreciationValuation;
	
	// 停牌信息
	@Column(name = "stock_suspension_message",length = 100)
	private String stockSuspensionMessage;
	
	// 二级科目代码
	@Column(name = "second_class_account_code", length = 50)
	private String secondClassAccountCode;
	
	// 二级科目名称
	@Column(name = "second_class_account_name", length = 100)
	private String secondClassAccountName;

	// 三级科目代码
	@Column(name = "third_class_account_code", length = 50)
	private String thirdClassAccountCode;
	
	// 三级科目名称
	@Column(name = "third_class_account_name", length = 100)
	private String thirdClassAccountName;
	
	// 一级科目代码
	@Column(name = "first_class_account_code", length = 50)
	private String firstClassAccountCode;
	
	// 一级科目名称
	@Column(name = "first_class_account_name", length = 100)
	private String firstClassAccountName;
	
	// 行业
	@Column(name = "industry", length = 50)
	private String industry;
	
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

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getNetValueCostRatio() {
		return netValueCostRatio;
	}

	public void setNetValueCostRatio(BigDecimal netValueCostRatio) {
		this.netValueCostRatio = netValueCostRatio;
	}

	public BigDecimal getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}

	public BigDecimal getMarketCapitalization() {
		return marketCapitalization;
	}

	public void setMarketCapitalization(BigDecimal marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}

	public BigDecimal getNetValueMarketCapitalizationValue() {
		return netValueMarketCapitalizationValue;
	}

	public void setNetValueMarketCapitalizationValue(BigDecimal netValueMarketCapitalizationValue) {
		this.netValueMarketCapitalizationValue = netValueMarketCapitalizationValue;
	}

	public BigDecimal getAppreciationValuation() {
		return appreciationValuation;
	}

	public void setAppreciationValuation(BigDecimal appreciationValuation) {
		this.appreciationValuation = appreciationValuation;
	}

	public String getStockSuspensionMessage() {
		return stockSuspensionMessage;
	}

	public void setStockSuspensionMessage(String stockSuspensionMessage) {
		this.stockSuspensionMessage = stockSuspensionMessage;
	}

	public String getSecondClassAccountCode() {
		return secondClassAccountCode;
	}

	public void setSecondClassAccountCode(String secondClassAccountCode) {
		this.secondClassAccountCode = secondClassAccountCode;
	}

	public String getSecondClassAccountName() {
		return secondClassAccountName;
	}

	public void setSecondClassAccountName(String secondClassAccountName) {
		this.secondClassAccountName = secondClassAccountName;
	}

	public String getThirdClassAccountCode() {
		return thirdClassAccountCode;
	}

	public void setThirdClassAccountCode(String thirdClassAccountCode) {
		this.thirdClassAccountCode = thirdClassAccountCode;
	}

	public String getThirdClassAccountName() {
		return thirdClassAccountName;
	}

	public void setThirdClassAccountName(String thirdClassAccountName) {
		this.thirdClassAccountName = thirdClassAccountName;
	}

	public String getFirstClassAccountCode() {
		return firstClassAccountCode;
	}

	public void setFirstClassAccountCode(String firstClassAccountCode) {
		this.firstClassAccountCode = firstClassAccountCode;
	}

	public String getFirstClassAccountName() {
		return firstClassAccountName;
	}

	public void setFirstClassAccountName(String firstClassAccountName) {
		this.firstClassAccountName = firstClassAccountName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public FundValuation() {
	}

	public FundValuation(String date, String productId, BigDecimal marketCapitalization) {
		this.date = date;
		this.productId = productId;
		this.marketCapitalization = marketCapitalization;
	}

}
