package com.huaxin.fim.entity.request;

/**
 * 沣泛指数计算参数对象
 * 
 * @author liumd
 *
 */
public class IndexParameterRequest {

	private String beginDate; //开始日期
	private String endDate; //结束日期
	private String isParent;// 是否为母基金（1：是，0：否）
	private String indexId;// 基准ID
	private String indexName; // 基准名称
	private String futureStrategyStr; // 期货类投资策略
	private String securityStrategyStr; // 证券类投资策略
	private String ohterStrategyStr; // 其它投资策略
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
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
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
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
	
}
