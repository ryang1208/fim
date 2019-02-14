package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * 客户基本资料
 */
@Entity
@Table(name = "t_raw_cfmmc_customer")
public class CFMMCCustomer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	//日期
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	//客户名称
	@Column(name = "customer_name", nullable = false, length = 200)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 200)
	private String customerName;
	//身份证
	@Column(name = "identification",  length = 50)
	@Length(min = 0, max = 50)
	private String identification;
	//客户内部资金账户 
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;
	//所在地
	@Column(name = "location",  length = 40)
	@Length(min = 0, max = 40)
	private String location;
	//通讯地址
	@Column(name = "postal_address",  length = 200)
	@Length(min = 0, max = 200)
	private String postalAddress;
	//邮政编码
	@Column(name = "post_code",  length = 6)
	@Length(min = 0, max = 6)
	private String postCode;
	//联系电话
	@Column(name = "contact_number",  length = 40)
	@Length(min = 0, max = 40)
	private String contactNumber;
	//开户和销户标志
	@Column(name = "openAndClose_account_sign",  length = 10)
	@Length(min = 0, max = 10)
	private String openAndCloseAccountSign;
	//是否为交易会员
	@Column(name = "is_exchange_member", nullable = false, length = 10)
	@Length(min = 0, max = 10)
	private String isExchangeMember;
	//客户类型
	@Column(name = "customer_type",  length = 10)
	@Length(min = 0, max = 10)
	private String customerType;
	//客户期货期权内部资金账户开户日期
	@Column(name = "account_openDate",  length = 10)
	@Length(min = 0, max = 10)
	private String accountOpenDate;
	//组织机构代码证号
	@Column(name = "organization_code",  length = 40)
	@Length(min = 0, max = 40)
	private String organizationCode;
	//营业执照号
	@Column(name = "business_license",  length = 40)
	@Length(min = 0, max = 40)
	private String businessLicense;
	//开户代理人名称
	@Column(name = "openAccount_agentName",  length = 100)
	@Length(min = 0, max = 100)
	private String openAccountAgentName;
	//开户代理人身份证
	@Column(name = "openAccount_id",  length = 50)
	@Length(min = 0, max = 50)
	private String openAccountID;
	//账户休眠状态
	@Column(name = "account_dormantState", length = 10)
	@Length(min = 0, max = 10)
	private String accountDormantState;
    //境外客户标识
	@Column(name = "overseas_customers",  length = 10)
	@Length(min = 1, max = 10)
	private String overseasCustomers;
	//国籍/地区
	@Column(name = "nationality",  length = 10)
	@Length(min = 0, max = 10)
	private String nationality;
	//护照号码，港澳台通行证号码，或外国人永久居留证号码	
	@Column(name = "passportNO",  length = 50)
	@Length(min = 0, max = 50)
	private String passportNO;
	//商业登记证号	
	@Column(name = "business_registration_certificateNO",  length = 50)
	@Length(min = 0, max = 50)
	private String businessRegistrationCertificateNO;
	//是否为二级代理商
	@Column(name = "is_secondLevel_Agent", length = 10)
	@Length(min = 0, max = 10)
	private String isSecondLevelAgent;
	//二级代理商编号
	@Column(name = "secondLevel_agentNO",  length = 10)
	@Length(min = 0, max = 10)
	private String secondLevelAgentNO;
	//是否为期货公司子公司经营的资产管理业务
	@Column(name = "is_assetManagement_business",  length = 10)
	@Length(min = 0, max = 10)
	private String isAssetManagementBusiness;
	//客户证券现货内部资金账户 
	@Column(name = "customer_securities_investerID",  length = 18)
	@Length(min = 0, max = 18)
	private String customerSecuritiesInvesterID;
	//客户证券现货内部资金账户开户日期
	@Column(name = "customer_securities_openDate",  length = 10)
	@Length(min = 0, max = 10)
	private String customerSecuritiesOpenDate;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getInvesterID() {
		return investerID;
	}
	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getOpenAndCloseAccountSign() {
		return openAndCloseAccountSign;
	}
	public void setOpenAndCloseAccountSign(String openAndCloseAccountSign) {
		this.openAndCloseAccountSign = openAndCloseAccountSign;
	}
	public String getIsExchangeMember() {
		return isExchangeMember;
	}
	public void setIsExchangeMember(String isExchangeMember) {
		this.isExchangeMember = isExchangeMember;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getAccountOpenDate() {
		return accountOpenDate;
	}
	public void setAccountOpenDate(String accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getOpenAccountAgentName() {
		return openAccountAgentName;
	}
	public void setOpenAccountAgentName(String openAccountAgentName) {
		this.openAccountAgentName = openAccountAgentName;
	}
	public String getOpenAccountID() {
		return openAccountID;
	}
	public void setOpenAccountID(String openAccountID) {
		this.openAccountID = openAccountID;
	}
	public String getAccountDormantState() {
		return accountDormantState;
	}
	public void setAccountDormantState(String accountDormantState) {
		this.accountDormantState = accountDormantState;
	}
	public String getOverseasCustomers() {
		return overseasCustomers;
	}
	public void setOverseasCustomers(String overseasCustomers) {
		this.overseasCustomers = overseasCustomers;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassportNO() {
		return passportNO;
	}
	public void setPassportNO(String passportNO) {
		this.passportNO = passportNO;
	}
	public String getBusinessRegistrationCertificateNO() {
		return businessRegistrationCertificateNO;
	}
	public void setBusinessRegistrationCertificateNO(String businessRegistrationCertificateNO) {
		this.businessRegistrationCertificateNO = businessRegistrationCertificateNO;
	}
	public String getIsSecondLevelAgent() {
		return isSecondLevelAgent;
	}
	public void setIsSecondLevelAgent(String isSecondLevelAgent) {
		this.isSecondLevelAgent = isSecondLevelAgent;
	}
	public String getSecondLevelAgentNO() {
		return secondLevelAgentNO;
	}
	public void setSecondLevelAgentNO(String secondLevelAgentNO) {
		this.secondLevelAgentNO = secondLevelAgentNO;
	}
	public String getIsAssetManagementBusiness() {
		return isAssetManagementBusiness;
	}
	public void setIsAssetManagementBusiness(String isAssetManagementBusiness) {
		this.isAssetManagementBusiness = isAssetManagementBusiness;
	}
	public String getCustomerSecuritiesInvesterID() {
		return customerSecuritiesInvesterID;
	}
	public void setCustomerSecuritiesInvesterID(String customerSecuritiesInvesterID) {
		this.customerSecuritiesInvesterID = customerSecuritiesInvesterID;
	}
	public String getCustomerSecuritiesOpenDate() {
		return customerSecuritiesOpenDate;
	}
	public void setCustomerSecuritiesOpenDate(String customerSecuritiesOpenDate) {
		this.customerSecuritiesOpenDate = customerSecuritiesOpenDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
