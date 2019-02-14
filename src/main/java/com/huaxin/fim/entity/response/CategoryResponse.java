package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易类型返回图表对象
 * @author sust
 *
 */
public class CategoryResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal firstCategory;
	private BigDecimal secondCategory;
	private BigDecimal thirdCategory;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(BigDecimal firstCategory) {
		this.firstCategory = firstCategory;
	}
	public BigDecimal getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(BigDecimal secondCategory) {
		this.secondCategory = secondCategory;
	}
	public BigDecimal getThirdCategory() {
		return thirdCategory;
	}
	public void setThirdCategory(BigDecimal thirdCategory) {
		this.thirdCategory = thirdCategory;
	}
	
}
