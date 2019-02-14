package com.huaxin.fim.entity.sy.entity.tmp;


import com.huaxin.fim.entity.entity.InvestmentFundManager;
import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentTradeGroup;

import java.io.Serializable;
import java.util.List;

/**
 * 团队介绍
 * @author xieky
 *
 */
public class InvestmentTeamIntroduction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String investmentID;
	
	private List<InvestmentTradeGroup> investmentTradeGroupList;
	
	private List<InvestmentFundManager> fundManagerList;

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public List<InvestmentTradeGroup> getInvestmentTradeGroupList() {
		return investmentTradeGroupList;
	}

	public void setInvestmentTradeGroupList(List<InvestmentTradeGroup> investmentTradeGroupList) {
		this.investmentTradeGroupList = investmentTradeGroupList;
	}

	public List<InvestmentFundManager> getFundManagerList() {
		return fundManagerList;
	}

	public void setFundManagerList(List<InvestmentFundManager> fundManagerList) {
		this.fundManagerList = fundManagerList;
	}
	
}
