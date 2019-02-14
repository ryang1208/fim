package com.huaxin.fim.entity.sy.entity.investmentManager;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * 投顾状态变更备注
 * @author xieky
 *
 */
@Entity
@Table(name = "t_investment_manager_status_remark", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class InvestmentManagerStatusRemark implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "investment_id", length = 10)
	@Length(min = 0, max = 10)
	private String investmentID;
	
	//操作日期
	@Column(name = "operate_date", length = 10)
	@Length(min = 0, max = 10)
	private String operateDate;
	
	//操作时间
	@Column(name = "operate_time", length = 10)
	@Length(min = 0, max = 10)
	private String operateTime;
	
	@Column(name = "operate_id", length = 50)
	@Length(min = 0, max = 50)
	private String operateID;
	
	//目标操作状态
	@Column(name = "status", length = 1)
	@Length(min = 0, max = 1)
	private String status;
	
	//备注
	@Column(name = "remark", length = 1000)
	@Length(min = 0, max = 1000)
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperateID() {
		return operateID;
	}

	public void setOperateID(String operateID) {
		this.operateID = operateID;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}
	
}
