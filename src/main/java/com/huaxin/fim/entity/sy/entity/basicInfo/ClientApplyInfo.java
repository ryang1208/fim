package com.huaxin.fim.entity.sy.entity.basicInfo;

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
 * 未复核客户信息
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_client_apply_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_type","id_number"})} )
public class ClientApplyInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 客户名
	@Column(name = "client_name", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String clientName;
		
	// 客户类型
	@Column(name = "client_type", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String clientType;
	
	// 证件类型
	@Column(name = "id_type", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String idType;
	
	// 证件有效期
	@Column(name = "id_valid_date", length = 8)
	@Length(min = 0, max = 8)
	private String idValidDate;
	
	// 证件号
	@Column(name = "id_number", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String idNumber;
	
	// 性别
	@Column(name = "gender", length = 1)
	@Length(min = 0, max = 1)
	private String gender;
	
	// 年龄
	@Column(name = "age", length = 3)
	@Length(min = 0, max = 3)
	private String age;
	
	// 出生日期
	@Column(name = "birth_date", length = 8)
	@Length(min = 0, max = 8)
	private String birthDate;
	
	// 身份资料图片
	@Column(name = "id_pic_url", length = 100)
	@Length(min = 0, max = 100)
	private String idPicUrl;
	
	// 移动电话
	@Column(name = "mobile_phone", length = 50)
	@Length(min = 0, max = 50)
	private String mobilePhone;
	
	// 电话
	@Column(name = "telephone", length = 50)
	@Length(min = 0, max = 50)
	private String telephone;
	
	// 传真
	@Column(name = "fax", length = 15)
	@Length(min = 0, max = 15)
	private String fax;
	
	// 备用联系人
	@Column(name = "alter_contact", length = 15)
	@Length(min = 0, max = 15)
	private String alterContact;
	
	// 邮箱
	@Column(name = "mail_address", length = 100)
	@Length(min = 0, max = 100)
	private String mailAddress;
	
	// 联系地址
	@Column(name = "address", length = 200)
	@Length(min = 0, max = 200)
	private String address;
	
	// 邮编
	@Column(name = "post_code", length = 10)
	@Length(min = 0, max = 10)
	private String postCode;
	
	// 微信
	@Column(name = "we_chat", length = 30)
	@Length(min = 0, max = 30)
	private String weChat;
	
	// 风险分类
	@Column(name = "risk_type", length = 1)
	@Length(min = 0, max = 1)
	private String riskType;
	
	// 风险签署书
	@Column(name = "risk_sign_pic_url", length = 100)
	@Length(min = 0, max = 100)
	private String riskSignPicUrl;
	
	// 问卷书
	@Column(name = "question_pic_url", length = 100)
	@Length(min = 0, max = 100)
	private String questionPicUrl;
	
	// 银行账号资料
	@Column(name = "bank_account_pic_url", length = 100)
	@Length(min = 0, max = 100)
	private String bankAccountPicUrl;
	
	// 操作码(11.新增 12.修改 13.删除)
	@Column(name = "oper_code", length = 2)
	@Length(min = 0, max = 2)
	private String operCode;
	
	// 申请人
	@Column(name = "applicant", length = 20)
	@Length(min = 0, max = 20)
	private String applicant;
	
	// 复核人
	@Column(name = "reviewer", length = 20)
	@Length(min = 0, max = 20)
	private String reviewer;
	
	// 唯一标识号(idtype+idnumber)
	@Column(name = "client_id",nullable=false, length = 25)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 25)
	private String clientID;
	
	// 开户日期
	@Column(name = "reg_date", length = 8)
	@Length(min = 0, max = 8)
	private String regDate;
	
	// 操作员
	@Column(name = "operator_id", length = 20)
	@Length(min = 0, max = 20)
	private String operatorID;

	// 操作日期
	@Column(name = "operate_date", length = 8)
	@Length(min = 0, max = 8)
	private String operateDate;

	// 操作时间
	@Column(name = "operate_time", length = 8)
	@Length(min = 0, max = 8)
	private String operateTime;
	
	// 是否复核
	private String status;
	
	//盐
	@Column(name = "salt", length = 20)
	@Length(min = 0, max = 20)
	private String salt;

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdValidDate() {
		return idValidDate;
	}

	public void setIdValidDate(String idValidDate) {
		this.idValidDate = idValidDate;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdPicUrl() {
		return idPicUrl;
	}

	public void setIdPicUrl(String idPicUrl) {
		this.idPicUrl = idPicUrl;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAlterContact() {
		return alterContact;
	}

	public void setAlterContact(String alterContact) {
		this.alterContact = alterContact;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskSignPicUrl() {
		return riskSignPicUrl;
	}

	public void setRiskSignPicUrl(String riskSignPicUrl) {
		this.riskSignPicUrl = riskSignPicUrl;
	}

	public String getQuestionPicUrl() {
		return questionPicUrl;
	}

	public void setQuestionPicUrl(String questionPicUrl) {
		this.questionPicUrl = questionPicUrl;
	}

	public String getBankAccountPicUrl() {
		return bankAccountPicUrl;
	}

	public void setBankAccountPicUrl(String bankAccountPicUrl) {
		this.bankAccountPicUrl = bankAccountPicUrl;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
