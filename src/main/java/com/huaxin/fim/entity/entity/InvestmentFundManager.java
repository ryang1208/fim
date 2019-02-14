package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * 投顾基金经理数据
 * @author sust
 *
 */
@Entity
@Table(name = "t_investment_fund_manager", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class InvestmentFundManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//投顾ID
	@Column(name = "investment_id",length = 20)
	@Length(min = 1, max = 20)
	private String investmentID;
	
	//姓名
	@Column(name = "name", length = 100)
	@Length(min = 1, max = 100)
	private String name;
	
	//专业
	@Column(name = "major", length = 200)
	@Length(min = 0, max = 200)
	private String major;
	
	//学历
	@Column(name = "education", length = 30)
	@Length(min = 0, max = 30)
	private String education;
	
	//毕业院校
	@Column(name = "school", length = 100)
	@Length(min = 0, max = 100)
	private String school;
		
	//入职日期
	@Column(name = "hire_date", length = 8)
	@Length(min = 0, max = 8)
	private String hireDate;
	
	//职位
	@Column(name = "position", length = 100)
	@Length(min = 0, max = 100)
	private String position;
	
	//是否取得证券投资资格
	@Column(name = "has_security_qualification", length = 2)
	@Length(min = 0, max = 2)
	private String hasSecurityQualification;
	
	//简历
	@Column(name = "curriculum_vitae")
	private String curriculumVitae;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHasSecurityQualification() {
		return hasSecurityQualification;
	}

	public void setHasSecurityQualification(String hasSecurityQualification) {
		this.hasSecurityQualification = hasSecurityQualification;
	}

	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}
	
}