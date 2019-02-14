package com.huaxin.fim.entity.response;

import java.io.Serializable;

/**
 * 盈亏分析返图表回对象
 * @author liumd
 *
 */
public class ProfitAndLossResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362910122243802929L;
	private String level;
	private Integer days;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
}
