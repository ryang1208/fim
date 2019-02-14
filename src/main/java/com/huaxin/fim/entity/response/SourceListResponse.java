package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 指标统计原数据对象
 * @author sust
 *
 */
public class SourceListResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String productID;
	private String date;
	private BigDecimal numerator ;//分子(数据)
	private BigDecimal denominator ;//分母
	
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getNumerator() {
		return numerator;
	}
	public void setNumerator(BigDecimal numerator) {
		this.numerator = numerator;
	}
	public BigDecimal getDenominator() {
		return denominator;
	}
	public void setDenominator(BigDecimal denominator) {
		this.denominator = denominator;
	}

}
