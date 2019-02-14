package com.huaxin.fim.entity.entity.temp;

import java.math.BigDecimal;

//债券久期
public class TempBondDurationValue {
	//日期
	private String date;
	//债券代码
	private String bondId;
	//市值
	private BigDecimal marketValue;
	//久期
	private BigDecimal duration;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBondId() {
		return bondId;
	}
	public void setBondId(String bondId) {
		this.bondId = bondId;
	}
	public BigDecimal getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}
	public BigDecimal getDuration() {
		return duration;
	}
	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}
	
	
}
