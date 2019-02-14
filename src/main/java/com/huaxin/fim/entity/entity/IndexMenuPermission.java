package com.huaxin.fim.entity.entity;


import java.io.Serializable;

public class IndexMenuPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//源数据管理
	private boolean home_1;
	private boolean fileUpload;
	
	//基金筛选
	private boolean home_3;
	private boolean fundSearch;
	
	//原始数据
	private boolean home_4;
	private boolean transactionSummary;
	private boolean transactionDetails;
	private boolean productNetValue;
	private boolean positionDetails;
	private boolean positionCloseDetails;
	private boolean positionSummary;
	private boolean investerDepositWithdrawal;
	private boolean investerFund;
	
	//用户管理
	private boolean home_7;
	private boolean userManage;
	//投资管理人
	private boolean home_8;
	private boolean investmentManager;
	private boolean investmentLog;
	private boolean investmentInfoMaintain;
	private boolean investmentinformationSum;
	//现场尽调管理
	private boolean dueDiligence;
	
	//系统管理
	private boolean home_9;
	private boolean systemMessage;//系统信息
	private boolean operateLog;//系统日志
	
	//基础信息维护
	private boolean home_2;
	private boolean fundProduct;
	private boolean fundProductNetWorth;
	private boolean fundProductForyw;
	private boolean adviserTrial;
	private boolean adviserFinal;
	private boolean investmentSet;
	
	//渠道管理
	private boolean home_5;
	private boolean channelInformation;
	
	//基金管理
	private boolean home_6;
	private boolean investmentProduct;
	
	//期货大赛
	private boolean home_10;
	private boolean complexRanking;
	
	//资金管理
	private boolean home_11;
	private boolean capitalFactorManagement;//资金要素管理
	private boolean fundTrial;//资金试算
	
	public boolean isHome_10() {
		return home_10;
	}
	public void setHome_10(boolean home_10) {
		this.home_10 = home_10;
	}
	public boolean isComplexRanking() {
		return complexRanking;
	}
	public void setComplexRanking(boolean complexRanking) {
		this.complexRanking = complexRanking;
	}
	public boolean isHome_7() {
		return home_7;
	}
	public void setHome_7(boolean home_7) {
		this.home_7 = home_7;
	}
	public boolean isUserManage() {
		return userManage;
	}
	public void setUserManage(boolean userManage) {
		this.userManage = userManage;
	}
	public boolean isHome_8() {
		return home_8;
	}
	public void setHome_8(boolean home_8) {
		this.home_8 = home_8;
	}
	public boolean isInvestmentManager() {
		return investmentManager;
	}
	public void setInvestmentManager(boolean investmentManager) {
		this.investmentManager = investmentManager;
	}
	public boolean isInvestmentLog() {
	    return investmentLog;
	}
	public void setInvestmentLog(boolean investmentLog) {
	    this.investmentLog = investmentLog;
	}
	public boolean isDueDiligence() {
		return dueDiligence;
	}
	public void setDueDiligence(boolean dueDiligence) {
		this.dueDiligence = dueDiligence;
	}
	public boolean isInvestmentInfoMaintain() {
		return investmentInfoMaintain;
	}
	public void setInvestmentInfoMaintain(boolean investmentInfoMaintain) {
		this.investmentInfoMaintain = investmentInfoMaintain;
	}
	public boolean isHome_9() {
		return home_9;
	}
	public void setHome_9(boolean home_9) {
		this.home_9 = home_9;
	}
	public boolean isSystemMessage() {
		return systemMessage;
	}
	public void setSystemMessage(boolean systemMessage) {
		this.systemMessage = systemMessage;
	}
	public boolean isInvestmentinformationSum() {
		return investmentinformationSum;
	}
	public void setInvestmentinformationSum(boolean investmentinformationSum) {
		this.investmentinformationSum = investmentinformationSum;
	}
	public boolean isOperateLog() {
		return operateLog;
	}
	public void setOperateLog(boolean operateLog) {
		this.operateLog = operateLog;
	}
	public boolean isHome_1() {
		return home_1;
	}
	public void setHome_1(boolean home_1) {
		this.home_1 = home_1;
	}
	public boolean isFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(boolean fileUpload) {
		this.fileUpload = fileUpload;
	}
	public boolean isHome_3() {
		return home_3;
	}
	public void setHome_3(boolean home_3) {
		this.home_3 = home_3;
	}
	public boolean isFundSearch() {
		return fundSearch;
	}
	public void setFundSearch(boolean fundSearch) {
		this.fundSearch = fundSearch;
	}
	public boolean isHome_4() {
		return home_4;
	}
	public void setHome_4(boolean home_4) {
		this.home_4 = home_4;
	}
	public boolean isTransactionSummary() {
		return transactionSummary;
	}
	public void setTransactionSummary(boolean transactionSummary) {
		this.transactionSummary = transactionSummary;
	}
	public boolean isTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(boolean transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public boolean isProductNetValue() {
		return productNetValue;
	}
	public void setProductNetValue(boolean productNetValue) {
		this.productNetValue = productNetValue;
	}
	public boolean isPositionDetails() {
		return positionDetails;
	}
	public void setPositionDetails(boolean positionDetails) {
		this.positionDetails = positionDetails;
	}
	public boolean isPositionCloseDetails() {
		return positionCloseDetails;
	}
	public void setPositionCloseDetails(boolean positionCloseDetails) {
		this.positionCloseDetails = positionCloseDetails;
	}
	public boolean isPositionSummary() {
		return positionSummary;
	}
	public void setPositionSummary(boolean positionSummary) {
		this.positionSummary = positionSummary;
	}
	public boolean isInvesterDepositWithdrawal() {
		return investerDepositWithdrawal;
	}
	public void setInvesterDepositWithdrawal(boolean investerDepositWithdrawal) {
		this.investerDepositWithdrawal = investerDepositWithdrawal;
	}
	public boolean isInvesterFund() {
		return investerFund;
	}
	public void setInvesterFund(boolean investerFund) {
		this.investerFund = investerFund;
	}
	public boolean isHome_2() {
		return home_2;
	}
	public void setHome_2(boolean home_2) {
		this.home_2 = home_2;
	}
	public boolean isFundProduct() {
		return fundProduct;
	}
	public void setFundProduct(boolean fundProduct) {
		this.fundProduct = fundProduct;
	}
	public boolean isFundProductNetWorth() {
		return fundProductNetWorth;
	}
	public void setFundProductNetWorth(boolean fundProductNetWorth) {
		this.fundProductNetWorth = fundProductNetWorth;
	}
	public boolean isFundProductForyw() {
		return fundProductForyw;
	}
	public void setFundProductForyw(boolean fundProductForyw) {
		this.fundProductForyw = fundProductForyw;
	}
	public boolean isAdviserTrial() {
		return adviserTrial;
	}
	public void setAdviserTrial(boolean adviserTrial) {
		this.adviserTrial = adviserTrial;
	}
	public boolean isAdviserFinal() {
		return adviserFinal;
	}
	public void setAdviserFinal(boolean adviserFinal) {
		this.adviserFinal = adviserFinal;
	}
	public boolean isInvestmentSet() {
		return investmentSet;
	}
	public void setInvestmentSet(boolean investmentSet) {
		this.investmentSet = investmentSet;
	}
	public boolean isHome_5() {
		return home_5;
	}
	public void setHome_5(boolean home_5) {
		this.home_5 = home_5;
	}
	public boolean isChannelInformation() {
		return channelInformation;
	}
	public void setChannelInformation(boolean channelInformation) {
		this.channelInformation = channelInformation;
	}
	public boolean isHome_6() {
		return home_6;
	}
	public void setHome_6(boolean home_6) {
		this.home_6 = home_6;
	}
	public boolean isInvestmentProduct() {
		return investmentProduct;
	}
	public void setInvestmentProduct(boolean investmentProduct) {
		this.investmentProduct = investmentProduct;
	}
	public boolean isHome_11() {
		return home_11;
	}
	public void setHome_11(boolean home_11) {
		this.home_11 = home_11;
	}
	public boolean isCapitalFactorManagement() {
		return capitalFactorManagement;
	}
	public void setCapitalFactorManagement(boolean capitalFactorManagement) {
		this.capitalFactorManagement = capitalFactorManagement;
	}
	public boolean isFundTrial() {
		return fundTrial;
	}
	public void setFundTrial(boolean fundTrial) {
		this.fundTrial = fundTrial;
	}
	
}
