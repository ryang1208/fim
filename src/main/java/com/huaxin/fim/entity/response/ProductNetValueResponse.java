package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易类型返回图表对象
 * @author sust
 *
 */
public class ProductNetValueResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private BigDecimal netAssetValue;
	private BigDecimal netAcumulativeValue;
	private String today;
	private String oneMonthDate;
	private String threeMonthDate;
	private String sixMonthDate;
	private String oneYearDate;
	private String thisYearDate;
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
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getOneMonthDate() {
		return oneMonthDate;
	}
	public void setOneMonthDate(String oneMonthDate) {
		this.oneMonthDate = oneMonthDate;
	}
	public String getThreeMonthDate() {
		return threeMonthDate;
	}
	public void setThreeMonthDate(String threeMonthDate) {
		this.threeMonthDate = threeMonthDate;
	}
	public String getSixMonthDate() {
		return sixMonthDate;
	}
	public void setSixMonthDate(String sixMonthDate) {
		this.sixMonthDate = sixMonthDate;
	}
	public String getOneYearDate() {
		return oneYearDate;
	}
	public void setOneYearDate(String oneYearDate) {
		this.oneYearDate = oneYearDate;
	}
	public String getThisYearDate() {
		return thisYearDate;
	}
	public void setThisYearDate(String thisYearDate) {
		this.thisYearDate = thisYearDate;
	}
	
}
