package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 母基金业务分析图表回传参数对象
 * @author liumd
 *
 */
public class ParentAnalysisResponse {

	
	private String date;
	private String productId;
	private String productName;
	private BigDecimal data;
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
