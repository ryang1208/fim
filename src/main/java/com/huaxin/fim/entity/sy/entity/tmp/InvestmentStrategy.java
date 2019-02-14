package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;

/**
 * 投资策略
 * @author xieky
 *
 */
public class InvestmentStrategy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String investmentID;
	
	//投资理念介绍
	private String tzlljs;
	
	//期货自助管理规模
	private String qhzzglgm;
		
	//期货受托管理规模
	private String qhstglgm;
		
	//证券自助管理规模
	private String zqzzglgm;
		
	//证券受托管理规模
	private String zqstglgm;
	
	//其他自助管理规模
	private String qtzzglgm;
			
	//其他受托管理规模
	private String qtstglgm;
	
	// 拟发行产品规模最高
	private String nfxcpgmzg;
	
	// 拟发行产品规模最低
	private String nfxcpgmzd;
	
	// 期货类交易策略
	private String xhljycl;
	
	// 证券类交易策略
	private String zqljycl;
	
	// 其他类交易策略
	private String qtljycl;
	
	// 投资策略
	private String strategyList;

	// 情况汇总
	private String situationSummary;
	public String getSituationSummary() {
		return situationSummary;
	}

	public void setSituationSummary(String situationSummary) {
		this.situationSummary = situationSummary;
	}

	public String getTzlljs() {
		return tzlljs;
	}

	public void setTzlljs(String tzlljs) {
		this.tzlljs = tzlljs;
	}

	public String getQhzzglgm() {
		return qhzzglgm;
	}

	public void setQhzzglgm(String qhzzglgm) {
		this.qhzzglgm = qhzzglgm;
	}

	public String getQhstglgm() {
		return qhstglgm;
	}

	public void setQhstglgm(String qhstglgm) {
		this.qhstglgm = qhstglgm;
	}

	public String getZqzzglgm() {
		return zqzzglgm;
	}

	public void setZqzzglgm(String zqzzglgm) {
		this.zqzzglgm = zqzzglgm;
	}

	public String getZqstglgm() {
		return zqstglgm;
	}

	public void setZqstglgm(String zqstglgm) {
		this.zqstglgm = zqstglgm;
	}

	public String getQtzzglgm() {
		return qtzzglgm;
	}

	public void setQtzzglgm(String qtzzglgm) {
		this.qtzzglgm = qtzzglgm;
	}

	public String getQtstglgm() {
		return qtstglgm;
	}

	public void setQtstglgm(String qtstglgm) {
		this.qtstglgm = qtstglgm;
	}

	public String getNfxcpgmzg() {
		return nfxcpgmzg;
	}

	public void setNfxcpgmzg(String nfxcpgmzg) {
		this.nfxcpgmzg = nfxcpgmzg;
	}

	public String getNfxcpgmzd() {
		return nfxcpgmzd;
	}

	public void setNfxcpgmzd(String nfxcpgmzd) {
		this.nfxcpgmzd = nfxcpgmzd;
	}

	public String getXhljycl() {
		return xhljycl;
	}

	public void setXhljycl(String xhljycl) {
		this.xhljycl = xhljycl;
	}

	public String getZqljycl() {
		return zqljycl;
	}

	public void setZqljycl(String zqljycl) {
		this.zqljycl = zqljycl;
	}

	public String getQtljycl() {
		return qtljycl;
	}

	public void setQtljycl(String qtljycl) {
		this.qtljycl = qtljycl;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	
}
