package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 母子基金风格分析回传参数对象
 * 
 * @author wucq
 *
 */
public class ParentStyleAnalysisResponse {

	private String date;
	private String productId;
	private String productName;
	private BigDecimal avgYieldRate;
	private BigDecimal winValue;
	private BigDecimal alphaValue;
	private BigDecimal timingValue;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getAvgYieldRate() {
		return avgYieldRate;
	}

	public void setAvgYieldRate(BigDecimal avgYieldRate) {
		this.avgYieldRate = avgYieldRate;
	}

	public BigDecimal getWinValue() {
		return winValue;
	}

	public void setWinValue(BigDecimal winValue) {
		this.winValue = winValue;
	}

	public BigDecimal getAlphaValue() {
		return alphaValue;
	}

	public void setAlphaValue(BigDecimal alphaValue) {
		this.alphaValue = alphaValue;
	}

	public BigDecimal getTimingValue() {
		return timingValue;
	}

	public void setTimingValue(BigDecimal timingValue) {
		this.timingValue = timingValue;
	}

	
}
