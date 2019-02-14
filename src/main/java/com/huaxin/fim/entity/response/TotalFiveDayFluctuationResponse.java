package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 基金对比分析净值5日滚动波动率
 * @author sust
 *
 */
public class TotalFiveDayFluctuationResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal netValue;
	private String productName;
	private String productId;
	private BigDecimal fiveDayFluctuation;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getNetValue() {
		return netValue;
	}
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}
	public BigDecimal getFiveDayFluctuation() {
		return fiveDayFluctuation;
	}
	public void setFiveDayFluctuation(BigDecimal fiveDayFluctuation) {
		this.fiveDayFluctuation = fiveDayFluctuation;
	}
	
	
}
