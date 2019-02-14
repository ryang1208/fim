package com.huaxin.fim.entity.entity;

import java.math.BigDecimal;

public class StandardDeviationYieldRate {

	// 交易日期
	private String date;

	// 产品Id
	private String productID;
	
	// 累计收益率 
	private BigDecimal yruntilNow;
	
	// 累计收益率标准差
	private BigDecimal tsuntilNow;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public BigDecimal getYruntilNow() {
		return yruntilNow;
	}

	public void setYruntilNow(BigDecimal yruntilNow) {
		this.yruntilNow = yruntilNow;
	}

	public BigDecimal getTsuntilNow() {
		return tsuntilNow;
	}

	public void setTsuntilNow(BigDecimal tsuntilNow) {
		this.tsuntilNow = tsuntilNow;
	}


	
	
	
}
