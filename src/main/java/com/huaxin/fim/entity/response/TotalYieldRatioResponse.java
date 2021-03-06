package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 基金对比分析累计收益率
 * @author liumd
 *
 */
public class TotalYieldRatioResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal amount;
	private String productName;
	private String productId;
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
