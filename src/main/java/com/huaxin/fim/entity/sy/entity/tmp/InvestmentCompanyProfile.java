package com.huaxin.fim.entity.sy.entity.tmp;


import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentContract;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 投顾公司概况
 * @author xieky
 *
 */
public class InvestmentCompanyProfile implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String investmentID;//投顾公司ID
	
	private String companyName;//公司名称
	
	private BigDecimal registeredCapital;//注册资本
	
	private BigDecimal paidInCapital;//实收资本
	
	private String companyEstablishment;//成立时间
	
	private String companyNumber;//公司团队人数
	
	private String businessLicense;//营业执照
	
	private String legalRepresentative;//法人代表
	
	private String companyUrl;//公司网址
	
	private String companyDomicile;//公司住所
	
	private String province;//联系地址 省
	
	private String city;//联系地址 市
	
	private String companyAddress;//联系地址 详细地址
	
	private String investmentCode;//管理人编码
	
	private String hasQualification;//是否具有投顾资格
	
	private String hasGFCooperation;//是否与国富期货有合作
	
	private String cooperation;//合作情况
	
	private List<InvestmentContract> investmentContractList;//联系人信息

	private String departmentSet;//部门设置
	
	private String status;//投顾状态
	
	private String investmentType;//投顾类型
		
	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(BigDecimal registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public BigDecimal getPaidInCapital() {
		return paidInCapital;
	}

	public void setPaidInCapital(BigDecimal paidInCapital) {
		this.paidInCapital = paidInCapital;
	}

	public String getCompanyEstablishment() {
		return companyEstablishment;
	}

	public void setCompanyEstablishment(String companyEstablishment) {
		this.companyEstablishment = companyEstablishment;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getInvestmentCode() {
		return investmentCode;
	}

	public void setInvestmentCode(String investmentCode) {
		this.investmentCode = investmentCode;
	}

	public String getHasQualification() {
		return hasQualification;
	}

	public void setHasQualification(String hasQualification) {
		this.hasQualification = hasQualification;
	}

	public String getHasGFCooperation() {
		return hasGFCooperation;
	}

	public void setHasGFCooperation(String hasGFCooperation) {
		this.hasGFCooperation = hasGFCooperation;
	}

	public String getCooperation() {
		return cooperation;
	}

	public void setCooperation(String cooperation) {
		this.cooperation = cooperation;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public List<InvestmentContract> getInvestmentContractList() {
		return investmentContractList;
	}

	public void setInvestmentContractList(List<InvestmentContract> investmentContractList) {
		this.investmentContractList = investmentContractList;
	}

	public String getCompanyDomicile() {
		return companyDomicile;
	}

	public void setCompanyDomicile(String companyDomicile) {
		this.companyDomicile = companyDomicile;
	}

	public String getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(String departmentSet) {
		this.departmentSet = departmentSet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
