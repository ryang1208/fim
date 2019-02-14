package com.huaxin.fim.entity.sy.entity.tmp;


import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentOwnershipStructure;

import java.io.Serializable;
import java.util.List;

/**
 * 公司运营情况
 * @author xieky
 *
 */
public class InvestmentOperationSituation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//投顾ID
	private String investmentID;
	
	// 公司简介
	private String gsjj;
	
	// 公司运营框架
	private String gsyykj;	
	
	// 公司运营框架图
	private String gsyykjt;	
	
	// 风控架构图
	private String fkjgt;
	
	//风控体系介绍
	private String fktxjs;
	
	//风控体系介绍
	private String fkxtjs;
	
	//交易系统介绍
	private String jyxtjs;

	//
	private List<InvestmentOwnershipStructure> investmentOwnershipStructureList;
	
	public String getGsjj() {
		return gsjj;
	}

	public void setGsjj(String gsjj) {
		this.gsjj = gsjj;
	}

	public String getGsyykj() {
		return gsyykj;
	}

	public void setGsyykj(String gsyykj) {
		this.gsyykj = gsyykj;
	}

	public String getFkjgt() {
		return fkjgt;
	}

	public void setFkjgt(String fkjgt) {
		this.fkjgt = fkjgt;
	}

	public String getFktxjs() {
		return fktxjs;
	}

	public void setFktxjs(String fktxjs) {
		this.fktxjs = fktxjs;
	}

	public String getFkxtjs() {
		return fkxtjs;
	}

	public void setFkxtjs(String fkxtjs) {
		this.fkxtjs = fkxtjs;
	}

	public String getJyxtjs() {
		return jyxtjs;
	}

	public void setJyxtjs(String jyxtjs) {
		this.jyxtjs = jyxtjs;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public List<InvestmentOwnershipStructure> getInvestmentOwnershipStructureList() {
		return investmentOwnershipStructureList;
	}

	public void setInvestmentOwnershipStructureList(List<InvestmentOwnershipStructure> investmentOwnershipStructureList) {
		this.investmentOwnershipStructureList = investmentOwnershipStructureList;
	}

	public String getGsyykjt() {
		return gsyykjt;
	}

	public void setGsyykjt(String gsyykjt) {
		this.gsyykjt = gsyykjt;
	}

}
