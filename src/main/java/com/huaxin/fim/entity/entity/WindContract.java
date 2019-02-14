package com.huaxin.fim.entity.entity;


import java.math.BigDecimal;

public class WindContract {
    /**
     * 交易日期
     */
    private String tradeDate;
    /**
     * 交易所
     */
    private String exchangeId;
    /**
     * 交易代码
     */
    private String contract;
    /**
     * 交易代码
     */
    private String varietyId;

    /**
     *
     */
    private BigDecimal contractMultiplier;

    /**
     * 货币代码
     */
    private String currency;
    /**
     *
     */
    private String assetType;
    /**
     * 合约名字
     */
    private String contractName;

    /**
     * 行业姓名
     */
    private String industriesName;
    /**
     * 是否停牌
     */
    private String isSuspension;

    private BigDecimal closePriceLastDay;

    private BigDecimal openPriceToday;

    private BigDecimal priceToday;

    private BigDecimal closePriceToday;

    private BigDecimal marketValue;

    private BigDecimal peRatio;

    private BigDecimal pbRatio;

    private BigDecimal dividendRatio;

    private String listingDate;

    private String windCode;

    private BigDecimal dailyYieldRate;

    private BigDecimal assetDebtRatio;

    private BigDecimal cashEarning;

    private BigDecimal totalEarning;

    private BigDecimal turnover;

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
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

    public BigDecimal getContractMultiplier() {
        return contractMultiplier;
    }

    public void setContractMultiplier(BigDecimal contractMultiplier) {
        this.contractMultiplier = contractMultiplier;
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

    public String getIndustriesName() {
        return industriesName;
    }

    public void setIndustriesName(String industriesName) {
        this.industriesName = industriesName;
    }

    public String getIsSuspension() {
        return isSuspension;
    }

    public void setIsSuspension(String isSuspension) {
        this.isSuspension = isSuspension;
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

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode;
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

    @Override
    public String toString() {
        return "WindContract{" +
                "tradeDate='" + tradeDate + '\'' +
                ", exchangeId='" + exchangeId + '\'' +
                ", contract='" + contract + '\'' +
                ", varietyId='" + varietyId + '\'' +
                ", contractMultiplier=" + contractMultiplier +
                ", currency='" + currency + '\'' +
                ", assetType=" + assetType +
                ", contractName='" + contractName + '\'' +
                ", industriesName='" + industriesName + '\'' +
                ", isSuspension='" + isSuspension + '\'' +
                ", closePriceLastDay=" + closePriceLastDay +
                ", openPriceToday=" + openPriceToday +
                ", priceToday=" + priceToday +
                ", closePriceToday=" + closePriceToday +
                ", marketValue=" + marketValue +
                ", peRatio=" + peRatio +
                ", pbRatio=" + pbRatio +
                ", dividendRatio=" + dividendRatio +
                ", listingDate='" + listingDate + '\'' +
                ", windCode='" + windCode + '\'' +
                ", dailyYieldRate=" + dailyYieldRate +
                ", assetDebtRatio=" + assetDebtRatio +
                ", cashEarning=" + cashEarning +
                ", totalEarning=" + totalEarning +
                ", turnover=" + turnover +
                '}';
    }
}
