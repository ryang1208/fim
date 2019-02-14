package com.huaxin.fim.entity.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 模拟组合查询条件参数对象
 * @author liumd
 *
 */
public class FundSearchSimulationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yieldRatio; // 收益率
	private String yieldRatioBegin; // 收益率开始 
	private String yieldRatioEnd; // 收益率结束
	private String drawDownRatio; // 回撤率
	private String drawDownRatioBegin; // 回撤率开始
	private String drawDownRatioEnd; // 回撤率结束
	private String[] initialAsset; // 发行规模
	
	private String[] futureStrategy; // 期货类投资策略
	private String[] securityStrategy; // 证券类投资策略
	private String[] ohterStrategy; // 其它投资策略
	private String[] strategyList;	// 投资策略集合
	
	private List<Map<String,Integer>> initialAssetList; // 发行规模
	private String initialAssetStr; // 发行规模
	
	private String futureStrategyStr; // 期货类投资策略
	private String securityStrategyStr; // 证券类投资策略
	private String ohterStrategyStr; // 其它投资策略
	private String strategyStr;		// 投资策略
	
	private String beginDate;// 产品存续期开始
	private String endDate; // 产品存续期结束
	private String sharpRatio; // 回撤率
	private String sharpRatioBegin; // 回撤率开始
	private String sharpRatioEnd; // 回撤率结束
	private String productName;
	
	private String createUserId;// 创建人ID
	
	
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public List<Map<String, Integer>> getInitialAssetList() {
		return initialAssetList;
	}
	public void setInitialAssetList(List<Map<String, Integer>> initialAssetList) {
		this.initialAssetList = initialAssetList;
	}
	public String getInitialAssetStr() {
		return initialAssetStr;
	}
	public void setInitialAssetStr(String initialAssetStr) {
		this.initialAssetStr = initialAssetStr;
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
	public String[] getStrategyList() {
		return strategyList;
	}
	public void setStrategyList(String[] strategyList) {
		this.strategyList = strategyList;
	}
	public String getStrategyStr() {
		return strategyStr;
	}
	public void setStrategyStr(String strategyStr) {
		this.strategyStr = strategyStr;
	}
	
	
}
