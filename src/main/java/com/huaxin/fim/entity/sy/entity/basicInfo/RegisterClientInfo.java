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
 * 注册客户信息
 * @author konglingqi
 * 
 */
@Entity
@Table(name = "t_register_client_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"open_id"})} )
public class RegisterClientInfo implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 注册日期
	@Column(name = "reg_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String regDate;
	
	// 注册时间
	@Column(name = "reg_time", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String regTime;
	
	// 客户名称
	@Column(name = "client_name", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String clientName;
	
	// 手机号
	@Column(name = "mobile_phone", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String mobilePhone;
	
	// 证件号/合同号
	@Column(name = "id_number", length = 50)
	@Length(min = 1, max = 50)
	private String idNumber;
	

	// 微信openid
	@Column(name = "open_id", length = 100)
	@Length(min = 0, max = 100)
	private String openID;
	
	
	//审核状态
	@Column(name = "check_status", length = 1)
	@Length(min = 0, max = 1)
	private String checkStatus;
	
	// 微信昵称
	@Column(name = "weixin_nickname", length = 20)
	@Length(min = 0, max = 20)
	private String weixinNickname;
	
	// 问卷信息
	@Column(name = "questionnaire_score", length = 8)
	@Length(min = 0, max = 8)
	private String questionnaireScore;
	
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
	
	// 用户状态(0未注册未绑定 1已注册 2已绑定)
	@Column(name = "user_status", length = 1)
	@Length(min = 0, max = 1)
	private String userStatus;
	
	// 唯一标识号(idtype+idnumber)
	@Column(name = "client_id", length = 25)
	@Length(min = 0, max = 25)
	private String clientID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getWeixinNickname() {
		return weixinNickname;
	}

	public void setWeixinNickname(String weixinNickname) {
		this.weixinNickname = weixinNickname;
	}

	public String getQuestionnaireScore() {
		return questionnaireScore;
	}

	public void setQuestionnaireScore(String questionnaireScore) {
		this.questionnaireScore = questionnaireScore;
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

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
	
	
}
