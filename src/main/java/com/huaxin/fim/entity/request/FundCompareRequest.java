package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 基金对比筛查条件对象
 * 
 * @author wangdl
 *
 */
public class FundCompareRequest implements Serializable {
	private static final long serialVersionUID = -6060579374621048806L;
	private String periodType;
	private String beginDate;
	private String endDate;
	private String productId;
	private String[] productIdArray;	
	private String type;
	private String indexId;
	private String infoKpi;
	private String treyorKpi;
	public String getInfoKpi() {
		return infoKpi;
	}
	public void setInfoKpi(String infoKpi) {
		this.infoKpi = infoKpi;
	}
	public String getTreyorKpi() {
		return treyorKpi;
	}
	public void setTreyorKpi(String treyorKpi) {
		this.treyorKpi = treyorKpi;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getProductIdArray() {
		return productIdArray;
	}
	public void setProductIdArray(String[] productIdArray) {
		this.productIdArray = productIdArray;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

}
