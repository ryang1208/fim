package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易类型返回图表对象
 * @author sust
 *
 */
public class FundCompareResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal oneMonth;
	private BigDecimal threeMonth;
	private BigDecimal sixMonth;
	private BigDecimal oneYear;
	private BigDecimal untilNow;
	private BigDecimal thisYear;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getOneMonth() {
		return oneMonth;
	}
	public void setOneMonth(BigDecimal oneMonth) {
		this.oneMonth = oneMonth;
	}
	public BigDecimal getThreeMonth() {
		return threeMonth;
	}
	public void setThreeMonth(BigDecimal threeMonth) {
		this.threeMonth = threeMonth;
	}
	public BigDecimal getSixMonth() {
		return sixMonth;
	}
	public void setSixMonth(BigDecimal sixMonth) {
		this.sixMonth = sixMonth;
	}
	public BigDecimal getOneYear() {
		return oneYear;
	}
	public void setOneYear(BigDecimal oneYear) {
		this.oneYear = oneYear;
	}
	public BigDecimal getUntilNow() {
		return untilNow;
	}
	public void setUntilNow(BigDecimal untilNow) {
		this.untilNow = untilNow;
	}
	public BigDecimal getThisYear() {
		return thisYear;
	}
	public void setThisYear(BigDecimal thisYear) {
		this.thisYear = thisYear;
	}
	
	
	
}
