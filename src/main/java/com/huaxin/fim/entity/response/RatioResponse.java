package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 按类别返回图表对象的值&比例(前N大品种、合约、行业)
 * @author sust
 *
 */
public class RatioResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private String productName;
	private String type;
	private BigDecimal value;
	private BigDecimal ratio;
	private BigDecimal indexValue;
	private String contact;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public BigDecimal getRatio() {
		return ratio;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public BigDecimal getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(BigDecimal indexValue) {
		this.indexValue = indexValue;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
