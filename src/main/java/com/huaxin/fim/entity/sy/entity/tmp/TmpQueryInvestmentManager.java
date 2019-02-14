package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 投顾页面查询优化
 * @author xieky
 *
 */
public class TmpQueryInvestmentManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String companyEstablishment;//成立时间
	
	private String paidInCapital;//实收资本
	
	private String companyNumber;//公司人数
	
	private String companyDomicile;//公司住所
	
	//成立时间多选项
	private List<Map<String,String>> companyEstablishmentList;

	//实收资本多选项
	private List<Map<String,Integer>> paidInCapitalList;
	
	//公司人数多选项
	private List<Map<String,Integer>> companyNumberList;
	
	//公司住所多选项
	private List<String> companyDomicileList;
	
	private String companyName;//公司名称
	
	private String serviceManagerID;//业务经理ID
	
	private String xhljycl;//期货投资策略
	
	private List<String> xhljyclAllList;

	private String zqljycl;//证券类交易策略
	
	private List<String> zqljyclAllList;
	
	private String qtljycl;//其他类交易策略
	
	private List<String> qtljyclAllList;
	
	private String strategyList;	// 投资策略
	
	private List<String> strategyallList;//策略集合
	
	private String investmentManagerStatus;//投顾状态
	
	private List<String> investmentManagerStatusList;//投顾状态列表
	
	private String startDate;//开始时间
	
	private String endDate;//结束时间
	
	private String investmentType;
	
	private List<String> investmentManagerTypeList;//投顾类型
	
	
	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public List<String> getInvestmentManagerTypeList() {
		return investmentManagerTypeList;
	}

	public void setInvestmentManagerTypeList(List<String> investmentManagerTypeList) {
		this.investmentManagerTypeList = investmentManagerTypeList;
	}

	public String getCompanyEstablishment() {
		return companyEstablishment;
	}

	public void setCompanyEstablishment(String companyEstablishment) {
		this.companyEstablishment = companyEstablishment;
	}

	public String getPaidInCapital() {
		return paidInCapital;
	}

	public void setPaidInCapital(String paidInCapital) {
		this.paidInCapital = paidInCapital;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getCompanyDomicile() {
		return companyDomicile;
	}

	public void setCompanyDomicile(String companyDomicile) {
		this.companyDomicile = companyDomicile;
	}

	public List<Map<String, Integer>> getPaidInCapitalList() {
		return paidInCapitalList;
	}

	public void setPaidInCapitalList(List<Map<String, Integer>> paidInCapitalList) {
		this.paidInCapitalList = paidInCapitalList;
	}

	public List<Map<String, Integer>> getCompanyNumberList() {
		return companyNumberList;
	}

	public void setCompanyNumberList(List<Map<String, Integer>> companyNumberList) {
		this.companyNumberList = companyNumberList;
	}

	public List<String> getCompanyDomicileList() {
		return companyDomicileList;
	}

	public void setCompanyDomicileList(List<String> companyDomicileList) {
		this.companyDomicileList = companyDomicileList;
	}

	public List<Map<String,String>> getCompanyEstablishmentList() {
		return companyEstablishmentList;
	}

	public void setCompanyEstablishmentList(List<Map<String,String>> companyEstablishmentList) {
		this.companyEstablishmentList = companyEstablishmentList;
	}

	public String getServiceManagerID() {
		return serviceManagerID;
	}

	public void setServiceManagerID(String serviceManagerID) {
		this.serviceManagerID = serviceManagerID;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getXhljycl() {
		return xhljycl;
	}

	public void setXhljycl(String xhljycl) {
		this.xhljycl = xhljycl;
	}

	public List<String> getXhljyclAllList() {
		return xhljyclAllList;
	}

	public void setXhljyclAllList(List<String> xhljyclAllList) {
		this.xhljyclAllList = xhljyclAllList;
	}

	public String getZqljycl() {
		return zqljycl;
	}

	public void setZqljycl(String zqljycl) {
		this.zqljycl = zqljycl;
	}

	public List<String> getZqljyclAllList() {
		return zqljyclAllList;
	}

	public void setZqljyclAllList(List<String> zqljyclAllList) {
		this.zqljyclAllList = zqljyclAllList;
	}

	public String getQtljycl() {
		return qtljycl;
	}

	public void setQtljycl(String qtljycl) {
		this.qtljycl = qtljycl;
	}

	public List<String> getQtljyclAllList() {
		return qtljyclAllList;
	}

	public void setQtljyclAllList(List<String> qtljyclAllList) {
		this.qtljyclAllList = qtljyclAllList;
	}

	public List<String> getStrategyallList() {
		return strategyallList;
	}

	public void setStrategyallList(List<String> strategyallList) {
		this.strategyallList = strategyallList;
	}

	public String getInvestmentManagerStatus() {
		return investmentManagerStatus;
	}

	public void setInvestmentManagerStatus(String investmentManagerStatus) {
		this.investmentManagerStatus = investmentManagerStatus;
	}

	public List<String> getInvestmentManagerStatusList() {
		return investmentManagerStatusList;
	}

	public void setInvestmentManagerStatusList(List<String> investmentManagerStatusList) {
		this.investmentManagerStatusList = investmentManagerStatusList;
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

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	
}
