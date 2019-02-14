package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 模拟组合产品详细页面回传参数对象
 * @author liumd
 *
 */
public class SimulationProductResponse {

	
	private String date;
	private String productId;
	private String productName;
	private BigDecimal data;
	private BigDecimal maxData;
	
	private BigDecimal yieldRatio;
	private BigDecimal sharpRatio;
	private BigDecimal volatilityRatio;
	
	public BigDecimal getYieldRatio() {
		return yieldRatio;
	}
	public void setYieldRatio(BigDecimal yieldRatio) {
		this.yieldRatio = yieldRatio;
	}
	public BigDecimal getSharpRatio() {
		return sharpRatio;
	}
	public void setSharpRatio(BigDecimal sharpRatio) {
		this.sharpRatio = sharpRatio;
	}
	public BigDecimal getVolatilityRatio() {
		return volatilityRatio;
	}
	public void setVolatilityRatio(BigDecimal volatilityRatio) {
		this.volatilityRatio = volatilityRatio;
	}
	
	public BigDecimal getMaxData() {
		return maxData;
	}
	public void setMaxData(BigDecimal maxData) {
		this.maxData = maxData;
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
	public BigDecimal getData() {
		return data;
	}
	public void setData(BigDecimal data) {
		this.data = data;
	}
	

}
