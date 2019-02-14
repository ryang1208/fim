package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 母子基金风格分析回传参数对象
 * 
 * @author wucq
 *
 */
public class ParentPositionAnalysisResponse {

	private String date;
	private String productId;
	private String productName;
	private BigDecimal totalAsset;	
	private BigDecimal today;
	
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

	public BigDecimal getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(BigDecimal totalAsset) {
		this.totalAsset = totalAsset;
	}

	public BigDecimal getToday() {
		return today;
	}

	public void setToday(BigDecimal today) {
		this.today = today;
	}
	
}
