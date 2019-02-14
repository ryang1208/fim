package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 品种多空盈亏返回图表对象
 * @author sust
 *
 */
public class VarietyBuySellProfitResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String variety;
	private BigDecimal profitOneMonth;
	private BigDecimal profitThreeMonth;
	private BigDecimal profitSixMonth;
	private BigDecimal profitOneYear;
	private BigDecimal profitUntilNow;
	private BigDecimal profitThisYear;
	private BigDecimal lossOneMonth;
	private BigDecimal lossThreeMonth;
	private BigDecimal lossSixMonth;
	private BigDecimal lossOneYear;
	private BigDecimal lossUntilNow;
	private BigDecimal lossThisYear;
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public BigDecimal getProfitOneMonth() {
		return profitOneMonth;
	}
	public void setProfitOneMonth(BigDecimal profitOneMonth) {
		this.profitOneMonth = profitOneMonth;
	}
	public BigDecimal getProfitThreeMonth() {
		return profitThreeMonth;
	}
	public void setProfitThreeMonth(BigDecimal profitThreeMonth) {
		this.profitThreeMonth = profitThreeMonth;
	}
	public BigDecimal getProfitSixMonth() {
		return profitSixMonth;
	}
	public void setProfitSixMonth(BigDecimal profitSixMonth) {
		this.profitSixMonth = profitSixMonth;
	}
	public BigDecimal getProfitOneYear() {
		return profitOneYear;
	}
	public void setProfitOneYear(BigDecimal profitOneYear) {
		this.profitOneYear = profitOneYear;
	}
	public BigDecimal getProfitUntilNow() {
		return profitUntilNow;
	}
	public void setProfitUntilNow(BigDecimal profitUntilNow) {
		this.profitUntilNow = profitUntilNow;
	}
	public BigDecimal getProfitThisYear() {
		return profitThisYear;
	}
	public void setProfitThisYear(BigDecimal profitThisYear) {
		this.profitThisYear = profitThisYear;
	}
	public BigDecimal getLossOneMonth() {
		return lossOneMonth;
	}
	public void setLossOneMonth(BigDecimal lossOneMonth) {
		this.lossOneMonth = lossOneMonth;
	}
	public BigDecimal getLossThreeMonth() {
		return lossThreeMonth;
	}
	public void setLossThreeMonth(BigDecimal lossThreeMonth) {
		this.lossThreeMonth = lossThreeMonth;
	}
	public BigDecimal getLossSixMonth() {
		return lossSixMonth;
	}
	public void setLossSixMonth(BigDecimal lossSixMonth) {
		this.lossSixMonth = lossSixMonth;
	}
	public BigDecimal getLossOneYear() {
		return lossOneYear;
	}
	public void setLossOneYear(BigDecimal lossOneYear) {
		this.lossOneYear = lossOneYear;
	}
	public BigDecimal getLossUntilNow() {
		return lossUntilNow;
	}
	public void setLossUntilNow(BigDecimal lossUntilNow) {
		this.lossUntilNow = lossUntilNow;
	}
	public BigDecimal getLossThisYear() {
		return lossThisYear;
	}
	public void setLossThisYear(BigDecimal lossThisYear) {
		this.lossThisYear = lossThisYear;
	}
	
}
