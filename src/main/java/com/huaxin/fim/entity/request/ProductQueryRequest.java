package com.huaxin.fim.entity.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基金产品查询条件
 * @author xieky
 *
 */
public class ProductQueryRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//基金产品
	private String productName;
	
	//组合产品
	private String portfolioFund;
	
	//投顾名称
	private String investmentID;
	
	//基金经理
	private String fundManager;
	
	//发行规模
	private String initialAsset;
	
	//产品状态
	private String productStatus;
	
	//发行规模多选项
	private List<Map<String,Integer>> initialAssetList;

	//产品状态多选项
	private List<String> productStatusList;
	
	private String futureStrategyList;//期货投资策略
	
	private List<String> futureStrategyListAll;

	private String securitiesStrategyList;//证券类交易策略
	
	private List<String> securitiesStrategyListAll;
	
	private String otherStrategyList;//其他类交易策略
	
	private List<String> otherStrategyListAll;
	
	private List<String> strategyAllList;//策略集合
	
	private String isIndependent;//是否自主发行

	private List<String> investmentIdList;//投顾列表
	
	private String strategyList;		// 投资策略
	
	private String productType; //产品类型
	
	private List<String> productTypeList; //产品类型多选
		
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<String> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<String> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getFundManager() {
		return fundManager;
	}

	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}

	public String getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}

	public String getFutureStrategyList() {
		return futureStrategyList;
	}

	public void setFutureStrategyList(String futureStrategyList) {
		this.futureStrategyList = futureStrategyList;
	}

	public List<String> getFutureStrategyListAll() {
		return futureStrategyListAll;
	}

	public void setFutureStrategyListAll(List<String> futureStrategyListAll) {
		this.futureStrategyListAll = futureStrategyListAll;
	}

	public String getSecuritiesStrategyList() {
		return securitiesStrategyList;
	}

	public void setSecuritiesStrategyList(String securitiesStrategyList) {
		this.securitiesStrategyList = securitiesStrategyList;
	}

	public List<String> getSecuritiesStrategyListAll() {
		return securitiesStrategyListAll;
	}

	public void setSecuritiesStrategyListAll(List<String> securitiesStrategyListAll) {
		this.securitiesStrategyListAll = securitiesStrategyListAll;
	}

	public String getOtherStrategyList() {
		return otherStrategyList;
	}

	public void setOtherStrategyList(String otherStrategyList) {
		this.otherStrategyList = otherStrategyList;
	}

	public List<String> getOtherStrategyListAll() {
		return otherStrategyListAll;
	}

	public void setOtherStrategyListAll(List<String> otherStrategyListAll) {
		this.otherStrategyListAll = otherStrategyListAll;
	}

	public List<String> getStrategyAllList() {
		return strategyAllList;
	}

	public void setStrategyAllList(List<String> strategyAllList) {
		this.strategyAllList = strategyAllList;
	}

	public List<Map<String,Integer>> getInitialAssetList() {
		return initialAssetList;
	}

	public void setInitialAssetList(List<Map<String,Integer>> initialAssetList) {
		this.initialAssetList = initialAssetList;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPortfolioFund() {
		return portfolioFund;
	}

	public void setPortfolioFund(String portfolioFund) {
		this.portfolioFund = portfolioFund;
	}

	public String getIsIndependent() {
		return isIndependent;
	}

	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}

	public List<String> getInvestmentIdList() {
		return investmentIdList;
	}

	public void setInvestmentIdList(List<String> investmentIdList) {
		this.investmentIdList = investmentIdList;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public List<String> getProductStatusList() {
		return productStatusList;
	}

	public void setProductStatusList(List<String> productStatusList) {
		this.productStatusList = productStatusList;
	}

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	
}
