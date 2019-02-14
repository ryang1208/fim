package com.huaxin.fim.entity.sy.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 记录短信服务商发送记录
 * 
 * @author konglingqi
 *
 */

@Entity
@Table(name = "t_shortMsg_record")
public class ShortMsgRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	// 短信随机码
	@Column(name = "msg_code", length = 4)
	@Length(min = 0, max = 4)
	private String msgCode;

	// 短信的发送日期
	@Column(name = "send_date",  length = 8)
	@Length(min = 0, max = 8)
	private String sendDate;

	// 短信的发送时间
	@Column(name = "send_time",  length = 8)
	@Length(min = 0, max = 8)
	private String sendTime;
	
	
	// 短信的确认日期
	@Column(name = "confirm_date", length = 8)
	@Length(min = 0, max = 8)
	private String confirmDate;
	
	
	// 短信的确认时间
	@Column(name = "confirm_time",  length = 8)
	@Length(min = 0, max = 8)
	private String confirmTime;

	// 用户ID
	@Column(name = "client_id",  length = 100)
	@Length(min = 0, max = 100)
	private String clientID;
	
	//手机号码
	@Column(name = "mobilePhone", length = 20)
	@Length(min = 0, max = 20)
	private String mobilePhone;
	


	public long getId() {
		return id;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
