package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;

/**
 * 现场尽调管理导出实体类
 * @author shengting
 *
 */

public class TmpDueDiligence implements Serializable{

	private static final long serialVersionUID = 1L;
		
	// 投顾名称
	private String companyName;
	
	// 日期
	private String date;
	
	// 状态(0:无效、1:有效)
	private String status;
	
	// 业务经理(ID)
	private String managerID;
		
	// 尽调人
	private String dueDiligenceName;
			
	// 问题汇总
	private String problemDesc;	
			
	// 解决方案
	private String resolvePlan;	
			
	// 拜访总结
	private String conclusion;	
	
	public TmpDueDiligence(){}
	
	public TmpDueDiligence(String companyName, String date,
			String status,String managerID,String dueDiligenceName,String problemDesc,String resolvePlan,String conclusion) {
		super();
		this.companyName = companyName;
		this.date = date;
		this.status = status;
		this.managerID = managerID;
		this.dueDiligenceName = dueDiligenceName;
		this.problemDesc = problemDesc;
		this.resolvePlan = resolvePlan;
		this.conclusion = conclusion;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getstatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	
	public String getDueDiligenceName() {
		return dueDiligenceName;
	}

	public void setDueDiligenceName(String dueDiligenceName) {
		this.dueDiligenceName = dueDiligenceName;
	}
	
	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	
	public String getResolvePlan() {
		return resolvePlan;
	}

	public void setResolvePlan(String resolvePlan) {
		this.resolvePlan = resolvePlan;
	}
	
	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
		
}
