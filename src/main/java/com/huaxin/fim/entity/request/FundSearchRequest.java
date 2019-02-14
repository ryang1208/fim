package com.huaxin.fim.entity.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基金信息查询条件参数对象
 * @author liumd
 *
 */
public class FundSearchRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyWords;// 关键词
	private String keyValue; // 关键词值
	private String yieldRatio; // 收益率
	private String yieldRatioBegin; // 收益率开始 
	private String yieldRatioEnd; // 收益率结束
	
	private String drawDownRatio; // 回撤率
	private String drawDownRatioBegin; // 回撤率开始
	private String drawDownRatioEnd; // 回撤率结束
	private String riskReturnRatioBegin; // 风报比开始
	private String riskReturnRatioEnd; // 风报比结束
	private String[] initialAsset; // 发行规模
	private String[] futureStrategy; // 期货类投资策略
	private String[] securityStrategy; // 证券类投资策略
	private String[] ohterStrategy; // 其它投资策略
	private List<Map<String,Integer>> initialAssetList; // 发行规模
	private String initialAssetStr; // 发行规模
	
	private String futureStrategyStr; // 期货类投资策略
	private String securityStrategyStr; // 证券类投资策略
	private String ohterStrategyStr; // 其它投资策略
	private String strategyListStr;	// 投资策略
	private String[] strategyList;	// 投资策略列表
	
	private String createYear; // 成立年限
	private String createYearStr; // 成立年限
	private String createYearBegin; // 成立年限（开始）
	private String createYearEnd; // 成立年限（结束）
	private String[] productStatus; // 产品状态
	private String productStatusStr; // 产品状态
	private String isAttention; //
	private String isIndependent;//是否自主发行 
	private String isParentProduct;//是否自主发行 
	private String loginID;//登录账户
	private String myAttentionStr;//我关注的产品
	private String productID;//产品ID
	private String userId;// 登录账户
	
	private String beginDate;// 产品存续期开始
	private String endDate; // 产品存续期结束
	private String sharpRatio; // 回撤率
	private String sharpRatioBegin; // 回撤率开始
	private String sharpRatioEnd; // 回撤率结束
	private String calmaRatio; // 回撤率
	private String calmaRatioBegin; // 回撤率开始
	private String calmaRatioEnd; // 回撤率结束
	
	private String[] productTypes; // 产品类型
	private String productTypeStr; // 产品类型
	
	public String[] getProductTypes() {
		return productTypes;
	}
	public void setProductTypes(String[] productTypes) {
		this.productTypes = productTypes;
	}
	public String getProductTypeStr() {
		return productTypeStr;
	}
	public void setProductTypeStr(String productTypeStr) {
		this.productTypeStr = productTypeStr;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInitialAssetStr() {
		return initialAssetStr;
	}
	public void setInitialAssetStr(String initialAssetStr) {
		this.initialAssetStr = initialAssetStr;
	}
	public List<Map<String, Integer>> getInitialAssetList() {
		return initialAssetList;
	}
	public void setInitialAssetList(List<Map<String, Integer>> initialAssetList) {
		this.initialAssetList = initialAssetList;
	}
	public String getMyAttentionStr() {
		return myAttentionStr;
	}
	public void setMyAttentionStr(String myAttentionStr) {
		this.myAttentionStr = myAttentionStr;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getCreateYearStr() {
		return createYearStr;
	}
	public void setCreateYearStr(String createYearStr) {
		this.createYearStr = createYearStr;
	}
	
	public String getIsIndependent() {
		return isIndependent;
	}
	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}
	public String getIsParentProduct() {
		return isParentProduct;
	}
	public void setIsParentProduct(String isParentProduct) {
		this.isParentProduct = isParentProduct;
	}
	public String getFutureStrategyStr() {
		return futureStrategyStr;
	}
	public void setFutureStrategyStr(String futureStrategyStr) {
		this.futureStrategyStr = futureStrategyStr;
	}
	public String getSecurityStrategyStr() {
		return securityStrategyStr;
	}
	public void setSecurityStrategyStr(String securityStrategyStr) {
		this.securityStrategyStr = securityStrategyStr;
	}
	public String getOhterStrategyStr() {
		return ohterStrategyStr;
	}
	public void setOhterStrategyStr(String ohterStrategyStr) {
		this.ohterStrategyStr = ohterStrategyStr;
	}
	public String getCreateYearBegin() {
		return createYearBegin;
	}
	public void setCreateYearBegin(String createYearBegin) {
		this.createYearBegin = createYearBegin;
	}
	public String getCreateYearEnd() {
		return createYearEnd;
	}
	public void setCreateYearEnd(String createYearEnd) {
		this.createYearEnd = createYearEnd;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getYieldRatio() {
		return yieldRatio;
	}
	public void setYieldRatio(String yieldRatio) {
		this.yieldRatio = yieldRatio;
	}
	public String getYieldRatioBegin() {
		return yieldRatioBegin;
	}
	public void setYieldRatioBegin(String yieldRatioBegin) {
		this.yieldRatioBegin = yieldRatioBegin;
	}
	public String getYieldRatioEnd() {
		return yieldRatioEnd;
	}
	public void setYieldRatioEnd(String yieldRatioEnd) {
		this.yieldRatioEnd = yieldRatioEnd;
	}
	public String getDrawDownRatio() {
		return drawDownRatio;
	}
	public void setDrawDownRatio(String drawDownRatio) {
		this.drawDownRatio = drawDownRatio;
	}
	public String getDrawDownRatioBegin() {
		return drawDownRatioBegin;
	}
	public void setDrawDownRatioBegin(String drawDownRatioBegin) {
		this.drawDownRatioBegin = drawDownRatioBegin;
	}
	public String getDrawDownRatioEnd() {
		return drawDownRatioEnd;
	}
	public void setDrawDownRatioEnd(String drawDownRatioEnd) {
		this.drawDownRatioEnd = drawDownRatioEnd;
	}
	public String getRiskReturnRatioBegin() {
		return riskReturnRatioBegin;
	}
	public void setRiskReturnRatioBegin(String riskReturnRatioBegin) {
		this.riskReturnRatioBegin = riskReturnRatioBegin;
	}
	public String getRiskReturnRatioEnd() {
		return riskReturnRatioEnd;
	}
	public void setRiskReturnRatioEnd(String riskReturnRatioEnd) {
		this.riskReturnRatioEnd = riskReturnRatioEnd;
	}
	public String[] getInitialAsset() {
		return initialAsset;
	}
	public void setInitialAsset(String[] initialAsset) {
		this.initialAsset = initialAsset;
	}
	public String[] getFutureStrategy() {
		return futureStrategy;
	}
	public void setFutureStrategy(String[] futureStrategy) {
		this.futureStrategy = futureStrategy;
	}
	public String[] getSecurityStrategy() {
		return securityStrategy;
	}
	public void setSecurityStrategy(String[] securityStrategy) {
		this.securityStrategy = securityStrategy;
	}
	public String[] getOhterStrategy() {
		return ohterStrategy;
	}
	public void setOhterStrategy(String[] ohterStrategy) {
		this.ohterStrategy = ohterStrategy;
	}
	public String getCreateYear() {
		return createYear;
	}
	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}
	public String[] getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String[] productStatus) {
		this.productStatus = productStatus;
	}
	public String getIsAttention() {
		return isAttention;
	}
	public void setIsAttention(String isAttention) {
		this.isAttention = isAttention;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductStatusStr() {
		return productStatusStr;
	}
	public void setProductStatusStr(String productStatusStr) {
		this.productStatusStr = productStatusStr;
	}
	public String getSharpRatio() {
		return sharpRatio;
	}
	public void setSharpRatio(String sharpRatio) {
		this.sharpRatio = sharpRatio;
	}
	public String getSharpRatioBegin() {
		return sharpRatioBegin;
	}
	public void setSharpRatioBegin(String sharpRatioBegin) {
		this.sharpRatioBegin = sharpRatioBegin;
	}
	public String getSharpRatioEnd() {
		return sharpRatioEnd;
	}
	public void setSharpRatioEnd(String sharpRatioEnd) {
		this.sharpRatioEnd = sharpRatioEnd;
	}
	public String getCalmaRatio() {
		return calmaRatio;
	}
	public void setCalmaRatio(String calmaRatio) {
		this.calmaRatio = calmaRatio;
	}
	public String getCalmaRatioBegin() {
		return calmaRatioBegin;
	}
	public void setCalmaRatioBegin(String calmaRatioBegin) {
		this.calmaRatioBegin = calmaRatioBegin;
	}
	public String getCalmaRatioEnd() {
		return calmaRatioEnd;
	}
	public void setCalmaRatioEnd(String calmaRatioEnd) {
		this.calmaRatioEnd = calmaRatioEnd;
	}
	public String[] getStrategyList() {
		return strategyList;
	}
	public void setStrategyList(String[] strategyList) {
		this.strategyList = strategyList;
	}
	public String getStrategyListStr() {
		return strategyListStr;
	}
	public void setStrategyListStr(String strategyListStr) {
		this.strategyListStr = strategyListStr;
	}
	
}
