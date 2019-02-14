package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 持仓汇总表对应的实体类
 */
@Entity
@Table(name = "t_position_summary", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"date", "invester_id", "broker_id", "contact", "sh", "bs"})})
public class PositionSummary implements Serializable {

    private static final long serialVersionUID = 1L;
    // 交易日期（格式:YYYYMMDD）
    @Id
    @Column(name = "date", length = 8)
    @Length(min = 1, max = 8)
    @NotNull
    @NotBlank
    private String date;
    // 经济公司投资者ID
    @Id
    @Column(name = "invester_id", length = 32)
    @Length(min = 1, max = 32)
    @NotNull
    @NotBlank
    private String investerID;
    // 投赢汇经纪公司代号
    @Id
    @Column(name = "broker_id")
    private int brokerID;
    // 合约
    @Id
    @Column(name = "contact", length = 32)
    @Length(min = 1, max = 32)
    @NotNull
    @NotBlank
    private String contact;
    // 买持仓
    @Column(name = "position_buy")
    private int positionBuy;
    // 买均价
    @Column(name = "price_buy", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal priceBuy;
    // 卖持仓
    @Column(name = "position_sell")
    private int positionSell;
    // 卖均价
    @Column(name = "price_sell", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal priceSell;
    // 今结算价
    @Column(name = "settlementPrice_today", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal settlementPriceToday;
    // 昨结算价
    @Column(name = "settlementPrice_yesterday", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal settlementPriceYesterday;
    // 浮动盈亏
    @Column(name = "floating_profit", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal floatingProfit;
    // 交易保证金
    @Column(name = "margin", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal margin;
    // 投保标志(数据字典 1003)
    @Id
    @Column(name = "sh")
    @NotNull
    private int sh;
    // 数据来源
    @Column(name = "data_source")
    private int dataSource;
    // 买卖标志(数据字典 1001)
    @Id
    @Column(name = "bs")
    @NotNull
    private int bs;
    // 补填的交易保证金
    @Column(name = "ori_margin", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal oriMargin;

    // 市场类型（允许市场）
    @Column(name = "market_type", length = 2)
    private String marketType;

    // 持仓成本
    @Column(name = "position_cost", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal positionCost;

    // 收益（持仓+平仓）
    @Column(name = "total_profit", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal totalProfit;

    // 市值
    @Column(name = "market_capitalization", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal marketCapitalization;

    // 所属证券行业
    @Column(name = "industry", length = 50)
    private String industry;

    // 证券盘型
    @Column(name = "stock_type", length = 50)
    private String stockType;

    // 品种
    @Column(name = "variety_id")
    private String varietyID;

    @Transient
    private String brokerIDStr;

    @Transient
    private String productID;
    // 更新日期（格式:YYYYMMDD）
    @Column(name = "update_date", length = 8)
    @Length(min = 1, max = 8)
    private String updateDate;

    // 持仓盈亏
    @Column(name = "position_profit_market", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal positionProfitMarket;

    //多头期权市值
    @Column(name = "long_option_market_value", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal longOptionMarketValue;

    //空头期权市值
    @Column(name = "short_option_market_value", precision = 20, scale = 4)
    @Digits(integer = 16, fraction = 4)
    private BigDecimal shortOptionMarketValue;

    @Column(name = "total_expense")
    private String totalExpense;

    public BigDecimal getLongOptionMarketValue() {
        return longOptionMarketValue;
    }

    public void setLongOptionMarketValue(BigDecimal longOptionMarketValue) {
        this.longOptionMarketValue = longOptionMarketValue;
    }

    public BigDecimal getShortOptionMarketValue() {
        return shortOptionMarketValue;
    }

    public void setShortOptionMarketValue(BigDecimal shortOptionMarketValue) {
        this.shortOptionMarketValue = shortOptionMarketValue;
    }

    public String getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(String totalExpense) {
        this.totalExpense = totalExpense;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public BigDecimal getPositionCost() {
        return positionCost;
    }

    public void setPositionCost(BigDecimal positionCost) {
        this.positionCost = positionCost;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public BigDecimal getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(BigDecimal marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
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

    public BigDecimal getOriMargin() {
        return oriMargin;
    }

    public void setOriMargin(BigDecimal oriMargin) {
        this.oriMargin = oriMargin;
    }

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getPositionBuy() {
        return positionBuy;
    }

    public void setPositionBuy(int positionBuy) {
        this.positionBuy = positionBuy;
    }

    public BigDecimal getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(BigDecimal priceBuy) {
        this.priceBuy = priceBuy;
    }

    public int getPositionSell() {
        return positionSell;
    }

    public void setPositionSell(int positionSell) {
        this.positionSell = positionSell;
    }

    public BigDecimal getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(BigDecimal priceSell) {
        this.priceSell = priceSell;
    }

    public BigDecimal getSettlementPriceToday() {
        return settlementPriceToday;
    }

    public void setSettlementPriceToday(BigDecimal settlementPriceToday) {
        this.settlementPriceToday = settlementPriceToday;
    }

    public BigDecimal getSettlementPriceYesterday() {
        return settlementPriceYesterday;
    }

    public void setSettlementPriceYesterday(BigDecimal settlementPriceYesterday) {
        this.settlementPriceYesterday = settlementPriceYesterday;
    }

    public BigDecimal getFloatingProfit() {
        return floatingProfit;
    }

    public void setFloatingProfit(BigDecimal floatingProfit) {
        this.floatingProfit = floatingProfit;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public int getSh() {
        return sh;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public int getBrokerID() {
        return brokerID;
    }

    public void setBrokerID(int brokerID) {
        this.brokerID = brokerID;
    }

    public String getBrokerIDStr() {
        return brokerIDStr;
    }

    public void setBrokerIDStr(String brokerIDStr) {
        this.brokerIDStr = brokerIDStr;
    }

    public String getVarietyID() {
        return varietyID;
    }

    public void setVarietyID(String varietyID) {
        this.varietyID = varietyID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }


    public BigDecimal getPositionProfitMarket() {
        return positionProfitMarket;
    }

    public void setPositionProfitMarket(BigDecimal positionProfitMarket) {
        this.positionProfitMarket = positionProfitMarket;
    }

    public PositionSummary() {
    }

    public PositionSummary(String date, String contact, String marketType, BigDecimal marketCapitalization,
                           String industry, String stockType, String varietyID, int productID) {
        this.date = date;
        this.contact = contact;
        this.marketType = marketType;
        this.marketCapitalization = marketCapitalization;
        this.industry = industry;
        this.stockType = stockType;
        this.varietyID = varietyID;
        this.productID = String.valueOf(productID);
    }

    public PositionSummary(String date, String contact, String marketType, BigDecimal marketCapitalization,
                           String industry, String stockType, String varietyID, String productID) {
        this.date = date;
        this.contact = contact;
        this.marketType = marketType;
        this.marketCapitalization = marketCapitalization;
        this.industry = industry;
        this.stockType = stockType;
        this.varietyID = varietyID;
        this.productID = productID;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Transient
    private BigDecimal dividendRatio; // 股息率

    public BigDecimal getDividendRatio() {
        return dividendRatio;
    }

    public void setDividendRatio(BigDecimal dividendRatio) {
        this.dividendRatio = dividendRatio;
    }

}
