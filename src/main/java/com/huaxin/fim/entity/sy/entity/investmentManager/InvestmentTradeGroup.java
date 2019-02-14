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
 * 交易团队介绍
 * @author xieky
 *
 */
@Entity
@Table(name = "t_investment_trade_group", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class InvestmentTradeGroup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	//投顾ID
	@Column(name = "investment_id",length = 200)
	@Length(min = 0, max = 20)
	private String investmentID;
	
	//姓名
	@Column(name = "name", length = 200)
	@Length(min = 0, max = 100)
	private String name;
	
	//职务
	@Column(name = "post", length = 200)
	@Length(min = 0, max = 200)
	private String post;
	
	//职责
	@Column(name = "operating_duty", length = 200)
	@Length(min = 0, max = 1000)
	private String operatingDuty;
	
	//具体资料
	@Column(name = "specific_information")
	@Length(min = 0)
	private String specificInformation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getOperatingDuty() {
		return operatingDuty;
	}

	public void setOperatingDuty(String operatingDuty) {
		this.operatingDuty = operatingDuty;
	}

	public String getSpecificInformation() {
		return specificInformation;
	}

	public void setSpecificInformation(String specificInformation) {
		this.specificInformation = specificInformation;
	}
	
}
