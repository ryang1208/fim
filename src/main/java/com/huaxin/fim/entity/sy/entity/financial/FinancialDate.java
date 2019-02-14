package com.huaxin.fim.entity.sy.entity.financial;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 财务核算-核算日期
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_financial_date")
public class FinancialDate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	//非交易日名称 
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	//是否交易日
	@Column(name = "is_trading_day", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 1)
	private String isTradingDay;
	
	//是否核算归档
	@Column(name = "is_calculate", nullable = false, length = 1)
	@Length(min = 0, max = 1)
	private String isCalculate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIsTradingDay() {
		return isTradingDay;
	}

	public void setIsTradingDay(String isTradingDay) {
		this.isTradingDay = isTradingDay;
	}

	public String getIsCalculate() {
		return isCalculate;
	}

	public void setIsCalculate(String isCalculate) {
		this.isCalculate = isCalculate;
	}

}
