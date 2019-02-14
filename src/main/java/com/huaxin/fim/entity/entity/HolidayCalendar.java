package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/*
 * 交易日历表
 */
@Entity
@Table(name = "t_holiday_calendar", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date"})})
public class HolidayCalendar implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// 日期
	@Column(name = "date", length = 8)
	@Length(min = 0, max = 8)
	private String date;
	
	// 是否为假日
	@Column(name = "is_holiday", length = 2)
	private String isHoliday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}
	
    
}
