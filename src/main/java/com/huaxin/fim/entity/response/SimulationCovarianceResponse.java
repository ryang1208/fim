package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * 模拟组合构建成分基金协方差返回对象
 * 
 * @author liumd
 *
 */
public class SimulationCovarianceResponse {

	private String productId;
	private String productname;
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	private BigDecimal covValue;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public BigDecimal getCovValue() {
		return covValue;
	}
	public void setCovValue(BigDecimal covValue) {
		this.covValue = covValue;
	}
	
}
