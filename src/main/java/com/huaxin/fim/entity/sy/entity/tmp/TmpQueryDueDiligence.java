package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;

/**
 * 现场尽调管理导出实体类
 * @author shengting
 *
 */

public class TmpQueryDueDiligence implements Serializable{

	private static final long serialVersionUID = 1L;

	// 投顾名称
	private String companyName;
	
	// 起始日期
	private String startDate;
	
	// 結束日期
	private String endDate;
	
	// 业务经理(ID)
	private String managerID;
	
	//尽调方式
	private String dueDiligenceMode;
	
	public TmpQueryDueDiligence(){}
	
	public TmpQueryDueDiligence(String companyName, String startDate,
			String endDate,String managerID) {
		super();
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerID = managerID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	
	public String getDueDiligenceMode() {
		return dueDiligenceMode;
	}

	public void setDueDiligenceMode(String dueDiligenceMode) {
		this.dueDiligenceMode = dueDiligenceMode;
	}
}
