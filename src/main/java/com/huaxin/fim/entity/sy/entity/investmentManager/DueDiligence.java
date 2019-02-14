package com.huaxin.fim.entity.sy.entity.investmentManager;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 现场尽调管理
 * @author shengting
 *
 */
@Entity
@Table(name = "t_due_diligence", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_id","date","due_diligence_name"})} )
public class DueDiligence implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 投顾ID
	@Column(name = "company_id", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String companyID;
	
	// 投顾名称
	@Column(name = "company_name", nullable = false, length = 200)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 200)
	private String companyName;
	
	// 日期
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	// 状态(0:无效、1:有效)
	@Column(name = "status", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String status;
	
	// 业务经理(ID)
	@Column(name = "manager_id", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String managerID;
		
	// 尽调人
	@Column(name = "due_diligence_name", nullable = true, length = 50)
	@Length(min = 0, max = 50)
	private String dueDiligenceName;
			
	// 问题汇总
	@Column(name = "problem_desc", nullable = true, length = 1000)
	@Length(min = 0, max = 1000)
	private String problemDesc;	
			
	// 解决方案
	@Column(name = "resolve_plan", nullable = true, length = 1000)
	@Length(min = 0, max = 1000)
	private String resolvePlan;	
			
	// 拜访总结
	@Column(name = "conclusion", nullable = true, length = 1000)
	@Length(min = 0, max = 1000)
	private String conclusion;	

	//尽调方式
	@Column(name = "due_diligence_mode", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String dueDiligenceMode;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public String getproblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	
	public String getConclusion() {
		return conclusion;
	}

	public void setconclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getResolvePlan() {
		return resolvePlan;
	}

	public void setResolvePlan(String resolvePlan) {
		this.resolvePlan = resolvePlan;
	}

	public String getStatus() {
		return status;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getDueDiligenceMode() {
		return dueDiligenceMode;
	}

	public void setDueDiligenceMode(String dueDiligenceMode) {
		this.dueDiligenceMode = dueDiligenceMode;
	}
	
}
