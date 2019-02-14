package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易类型返回图表对象
 * @author sust
 *
 */
public class ProductsNetValueResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private String productId;
	private BigDecimal netAssetValue;
	private BigDecimal netAcumulativeValue;
	private BigDecimal ratio;
	private String isCalculateNetValue;
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
	public BigDecimal getNetAssetValue() {
		return netAssetValue;
	}
	public void setNetAssetValue(BigDecimal netAssetValue) {
		this.netAssetValue = netAssetValue;
	}
	public BigDecimal getNetAcumulativeValue() {
		return netAcumulativeValue;
	}
	public void setNetAcumulativeValue(BigDecimal netAcumulativeValue) {
		this.netAcumulativeValue = netAcumulativeValue;
	}
	public BigDecimal getRatio() {
		return ratio;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public String getIsCalculateNetValue() {
		return isCalculateNetValue;
	}
	public void setIsCalculateNetValue(String isCalculateNetValue) {
		this.isCalculateNetValue = isCalculateNetValue;
	}
	
	
}
