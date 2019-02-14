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
 * 合约行情表
 * 
 * @author liumd
 * @since 20170601
 * @version 1.0
 */
@Entity
@Table(name = "t_contract")
public class Contract implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_contract") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 交易日期（格式:YYYYMMDD）
	// 交易日期
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	
	// 交易所代码
	@Column(name = "exchange_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String exchangeId;
	
	// 合约代码
	@Column(name = "contract", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String contract;
	
	// 品种代码
	@Column(name = "variety_id", length = 10)
	private String varietyId;
	
	// 合约乘数
	@Column(name = "contract_multiplier", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal contract_multiplier;
	
	// 币种
	@Column(name = "currency", length = 8)
	private String currency;
	
	// 资产类型
	@Column(name = "asset_type", length = 8)
	private String assetType;
	
	// 合约名称
	@Column(name = "contract_name", length = 30)
	private String contractName;
	
	// 是否停牌（0：停牌/ 1：正常）
	@Column(name = "is_suspension", length = 1)
	private String isSuspension;
	
	// 行业
	@Column(name = "industry", length = 50)
	private String industry;
	
	// 盘型（枚举）
	@Column(name = "stock_type", length = 1)
	private String stockType;

	// 昨结算价
	@Column(name = "close_price_last_day",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closePriceLastDay;
	
	// 开盘价
	@Column(name = "open_price_today",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal openPriceToday;
	
	// 今结算价
	@Column(name = "price_today",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceToday;
	
	// 今收盘价
	@Column(name = "close_price_today",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closePriceToday;
	
	// 市值
	@Column(name = "market_value",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marketValue;
	
	// 市值类型（枚举）
	@Column(name = "market_value_type", length = 1)
	private String marketValueType;
	
	// 市盈率
	@Column(name = "pe_ratio",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal peRatio;
	
	// 市净率
	@Column(name = "pb_ratio",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal pbRatio;

	// 成长价值
	@Column(name = "stock_growth_value", length = 2)
	private String stockGrowthValue;
	
	// 股息率
	@Column(name = "dividend_ratio",  precision = 9, scale = 4)
	@Digits(integer = 5, fraction = 4)
	private BigDecimal dividendRatio;
	
	// 上市时间
	@Column(name = "listing_date", length = 8)
	@Length(min = 1, max = 8)
	private String listingDate;
	
	// 日收益率
	@Column(name = "daily_yield_rate",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal dailyYieldRate;
	
	// 资产负债比
	@Column(name = "asset_debt_ratio",  precision = 10, scale = 6)
	@Digits(integer = 4, fraction = 6)
	private BigDecimal assetDebtRatio;
	
	// 现金收益值
	@Column(name = "cash_earning",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal cashEarning;
	
	// 总收益值
	@Column(name = "total_earning",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal totalEarning;
	
	// 成交额
	@Column(name = "turnover",  precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal turnover;
	
	public BigDecimal getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(BigDecimal peRatio) {
		this.peRatio = peRatio;
	}

	public BigDecimal getPbRatio() {
		return pbRatio;
	}

	public void setPbRatio(BigDecimal pbRatio) {
		this.pbRatio = pbRatio;
	}

	public String getStockGrowthValue() {
		return stockGrowthValue;
	}

	public void setStockGrowthValue(String stockGrowthValue) {
		this.stockGrowthValue = stockGrowthValue;
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

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getVarietyId() {
		return varietyId;
	}

	public void setVarietyId(String varietyId) {
		this.varietyId = varietyId;
	}

	public BigDecimal getContract_multiplier() {
		return contract_multiplier;
	}

	public void setContract_multiplier(BigDecimal contract_multiplier) {
		this.contract_multiplier = contract_multiplier;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}


	public String getIsSuspension() {
		return isSuspension;
	}

	public void setIsSuspension(String isSuspension) {
		this.isSuspension = isSuspension;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public BigDecimal getClosePriceLastDay() {
		return closePriceLastDay;
	}

	public void setClosePriceLastDay(BigDecimal closePriceLastDay) {
		this.closePriceLastDay = closePriceLastDay;
	}

	public BigDecimal getOpenPriceToday() {
		return openPriceToday;
	}

	public void setOpenPriceToday(BigDecimal openPriceToday) {
		this.openPriceToday = openPriceToday;
	}

	public BigDecimal getPriceToday() {
		return priceToday;
	}

	public void setPriceToday(BigDecimal priceToday) {
		this.priceToday = priceToday;
	}

	public BigDecimal getClosePriceToday() {
		return closePriceToday;
	}

	public void setClosePriceToday(BigDecimal closePriceToday) {
		this.closePriceToday = closePriceToday;
	}

	public BigDecimal getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}

	public String getMarketValueType() {
		return marketValueType;
	}

	public void setMarketValueType(String marketValueType) {
		this.marketValueType = marketValueType;
	}

	public BigDecimal getDividendRatio() {
		return dividendRatio;
	}

	public void setDividendRatio(BigDecimal dividendRatio) {
		this.dividendRatio = dividendRatio;
	}

	public String getListingDate() {
		return listingDate;
	}

	public void setListingDate(String listingDate) {
		this.listingDate = listingDate;
	}

	public BigDecimal getDailyYieldRate() {
		return dailyYieldRate;
	}

	public void setDailyYieldRate(BigDecimal dailyYieldRate) {
		this.dailyYieldRate = dailyYieldRate;
	}

	public BigDecimal getAssetDebtRatio() {
		return assetDebtRatio;
	}

	public void setAssetDebtRatio(BigDecimal assetDebtRatio) {
		this.assetDebtRatio = assetDebtRatio;
	}

	public BigDecimal getCashEarning() {
		return cashEarning;
	}

	public void setCashEarning(BigDecimal cashEarning) {
		this.cashEarning = cashEarning;
	}

	public BigDecimal getTotalEarning() {
		return totalEarning;
	}

	public void setTotalEarning(BigDecimal totalEarning) {
		this.totalEarning = totalEarning;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	
	public Contract() {
	}

	public Contract(String date, String contract, String assetType, 
			String industry, BigDecimal pbRatio, BigDecimal assetDebtRatio, BigDecimal cashEarning,
			BigDecimal totalEarning, BigDecimal dailyYieldRate, BigDecimal marketValue) {
		this.date = date;
		this.contract = contract;
		this.assetType = assetType;
		this.industry = industry;
		this.pbRatio = pbRatio;
		this.assetDebtRatio = assetDebtRatio;
		this.cashEarning = cashEarning;
		this.totalEarning = totalEarning;
		this.dailyYieldRate = dailyYieldRate;
		this.marketValue = marketValue;
	}

	@Override
	public String toString() {
		return "Contract{" +
				"id=" + id +
				", date='" + date + '\'' +
				", exchangeId='" + exchangeId + '\'' +
				", contract='" + contract + '\'' +
				", varietyId='" + varietyId + '\'' +
				", contract_multiplier=" + contract_multiplier +
				", currency='" + currency + '\'' +
				", assetType='" + assetType + '\'' +
				", contractName='" + contractName + '\'' +
				", isSuspension='" + isSuspension + '\'' +
				", industry='" + industry + '\'' +
				", stockType='" + stockType + '\'' +
				", closePriceLastDay=" + closePriceLastDay +
				", openPriceToday=" + openPriceToday +
				", priceToday=" + priceToday +
				", closePriceToday=" + closePriceToday +
				", marketValue=" + marketValue +
				", marketValueType='" + marketValueType + '\'' +
				", peRatio=" + peRatio +
				", pbRatio=" + pbRatio +
				", stockGrowthValue='" + stockGrowthValue + '\'' +
				", dividendRatio=" + dividendRatio +
				", listingDate='" + listingDate + '\'' +
				", dailyYieldRate=" + dailyYieldRate +
				", assetDebtRatio=" + assetDebtRatio +
				", cashEarning=" + cashEarning +
				", totalEarning=" + totalEarning +
				", turnover=" + turnover +
				'}';
	}
}
