package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 产品注册对象
 * @author sust
 *
 */
public class ProductRegisterRequest implements Serializable{

	private static final long serialVersionUID = -6060579374621048806L;
	private String systemId;
	private String requestType;
	private String productName;
	private String productInvestmentManager;
	private String productType;
	private String CalculateNetValue;
	private String productStatus;
	private String ProductCode;
	private String initialAsset;
	private String strategy_list;
	private String investerIds;
	private String childProductIds;
	private String productManagerName;
	private String education;
	private String school;
	private String hireDate;
	private String position;
	private String hasSecurityQualification;
	private String curriculumVitae;
	
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductInvestmentManager() {
		return productInvestmentManager;
	}
	public void setProductInvestmentManager(String productInvestmentManager) {
		this.productInvestmentManager = productInvestmentManager;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCalculateNetValue() {
		return CalculateNetValue;
	}
	public void setCalculateNetValue(String calculateNetValue) {
		CalculateNetValue = calculateNetValue;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getInitialAsset() {
		return initialAsset;
	}
	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}
	public String getStrategy_list() {
		return strategy_list;
	}
	public void setStrategy_list(String strategy_list) {
		this.strategy_list = strategy_list;
	}
	public String getInvesterIds() {
		return investerIds;
	}
	public void setInvesterIds(String investerIds) {
		this.investerIds = investerIds;
	}
	public String getChildProductIds() {
		return childProductIds;
	}
	public void setChildProductIds(String childProductIds) {
		this.childProductIds = childProductIds;
	}
	public String getProductManagerName() {
		return productManagerName;
	}
	public void setProductManagerName(String productManagerName) {
		this.productManagerName = productManagerName;
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
