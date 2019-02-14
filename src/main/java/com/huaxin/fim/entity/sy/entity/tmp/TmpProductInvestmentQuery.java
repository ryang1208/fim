package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;
import java.util.List;

public class TmpProductInvestmentQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fundProductID;//产品ID
	
	private String status;//注册状态
	
	private String companyName;//投顾名称
	
	private String operateStartDate;//注册开始日期
	
	private String operateEndDate;//注册结束日期
	
	private List<String> statusList;//注册状态多選項

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOperateStartDate() {
		return operateStartDate;
	}

	public void setOperateStartDate(String operateStartDate) {
		this.operateStartDate = operateStartDate;
	}

	public String getOperateEndDate() {
		return operateEndDate;
	}

	public void setOperateEndDate(String operateEndDate) {
		this.operateEndDate = operateEndDate;
	}
	
}
