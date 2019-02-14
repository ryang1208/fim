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
 * 财务核算-交易日设置
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_trading_day")
public class TradingDay implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	//非交易日名称 
	@Column(name = "name", nullable = false, length = 15)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 15)
	private String name;
	
	// 开始日期
	@Column(name = "start_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 8)
	private String startDate;
	
	// 结束日期
	@Column(name = "end_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 8)
	private String endDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
