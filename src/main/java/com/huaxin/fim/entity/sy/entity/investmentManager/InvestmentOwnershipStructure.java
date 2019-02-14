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
 * 投顾股权结构
 * @author xieky
 *
 */
@Entity
@Table(name = "t_investment_ownership_structure", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class InvestmentOwnershipStructure implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "investment_id", length = 200)
	@Length(min = 0, max = 20)
	private String investmentID;//投顾ID
	
	@Column(name = "shareholder", length = 200)
	@Length(min = 0, max = 100)
	private String shareholder;//股东
	
	@Column(name = "investment_quota", length = 200)
	@Length(min = 0, max = 20)
	private String investmentQuota;//出资额

	@Column(name = "investment_way", length = 200)
	@Length(min = 0, max = 20)
	private String investmentWay;//出资方式
	
	@Column(name = "shareholding_ratio", length = 200)
	@Length(min = 0, max = 20)
	private String shareholdingRatio;//持股比例

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getShareholder() {
		return shareholder;
	}

	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	public String getInvestmentQuota() {
		return investmentQuota;
	}

	public void setInvestmentQuota(String investmentQuota) {
		this.investmentQuota = investmentQuota;
	}

	public String getInvestmentWay() {
		return investmentWay;
	}

	public void setInvestmentWay(String investmentWay) {
		this.investmentWay = investmentWay;
	}

	public String getShareholdingRatio() {
		return shareholdingRatio;
	}

	public void setShareholdingRatio(String shareholdingRatio) {
		this.shareholdingRatio = shareholdingRatio;
	}
	
	
}
