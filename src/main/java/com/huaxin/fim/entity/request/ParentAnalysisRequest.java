package com.huaxin.fim.entity.request;

import java.io.Serializable;
import java.util.List;

/**
 * 母子基金业务分析查询请求查询对象
 * @author liumd
 *
 */
public class ParentAnalysisRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String parentProductId; // 母基金产品代码
	private List<String> childProductIds; // 子基金产品代码列表
	private String periodType; // 统计周期类型
	private String[] productIds; // 产品代码集合
	private String beginDate;
	private String endDate;
	private String xkpi;
	private String ykpi;
	private String zkpi;
	private String riskValue; // 风险价值百分比（95%，99%）
	private String riskType; // 风险价值周期（5日，10日，20日）
	
	private String indexID;	// 指数代码
	
	private String kpiCode;	
	private String relationKpi;
	private String date;
	public String getKpiCode() {
		return kpiCode;
	}
	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}	
	
	public String getRelationKpi() {
		return relationKpi;
	}
	public void setRelationKpi(String relationKpi) {
		this.relationKpi = relationKpi;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRiskValue() {
		return riskValue;
	}
	public void setRiskValue(String riskValue) {
		this.riskValue = riskValue;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getXkpi() {
		return xkpi;
	}
	public void setXkpi(String xkpi) {
		this.xkpi = xkpi;
	}
	public String getYkpi() {
		return ykpi;
	}
	public void setYkpi(String ykpi) {
		this.ykpi = ykpi;
	}
	public String getZkpi() {
		return zkpi;
	}
	public void setZkpi(String zkpi) {
		this.zkpi = zkpi;
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
	public String[] getProductIds() {
		return productIds;
	}
	public void setProductIds(String[] productIds) {
		this.productIds = productIds;
	}
	public String getParentProductId() {
		return parentProductId;
	}
	public void setParentProductId(String parentProductId) {
		this.parentProductId = parentProductId;
	}
	public List<String> getChildProductIds() {
		return childProductIds;
	}
	public void setChildProductIds(List<String> childProductIds) {
		this.childProductIds = childProductIds;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public String getIndexID() {
		return indexID;
	}
	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}
	
}
