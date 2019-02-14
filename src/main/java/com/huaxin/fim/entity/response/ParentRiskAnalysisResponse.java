package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 母子基金风险分析回传参数对象
 * 
 * @author liumd
 *
 */
public class ParentRiskAnalysisResponse {

	private String date;
	private String productId;
	private String productName;
	private BigDecimal xData;
	private BigDecimal yData;
	private BigDecimal zData;
	private BigDecimal maxSharp;
	private BigDecimal minSharp;

	public BigDecimal getzData() {
		return zData;
	}

	public void setzData(BigDecimal zData) {
		this.zData = zData;
	}

	public BigDecimal getMaxSharp() {
		return maxSharp;
	}

	public void setMaxSharp(BigDecimal maxSharp) {
		this.maxSharp = maxSharp;
	}

	public BigDecimal getMinSharp() {
		return minSharp;
	}

	public void setMinSharp(BigDecimal minSharp) {
		this.minSharp = minSharp;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getxData() {
		return xData;
	}

	public void setxData(BigDecimal xData) {
		this.xData = xData;
	}

	public BigDecimal getyData() {
		return yData;
	}

	public void setyData(BigDecimal yData) {
		this.yData = yData;
	}

}
