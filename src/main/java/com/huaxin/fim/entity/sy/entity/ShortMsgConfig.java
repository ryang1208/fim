package com.huaxin.fim.entity.sy.entity;

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
import java.math.BigDecimal;

/**
 * 短信服务配置实体类
 * @author konglingqi
 *
 */

@Entity
@Table(name = "t_shortMsg_config")
public class ShortMsgConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 是否显示验证码
	@Column(name = "show_ShortMsg", nullable = false, length = 1)
	@Length(min = 0, max = 1)
	private boolean showShortMsg;
	
	// 重发时间
	@Column(name = "resend_time", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 10)
	private BigDecimal resendTime;
	
	// 短信配置内容1
	@Column(name = "msg_content1", nullable = false, length = 100)
	@Length(min = 0, max = 100)
	private String msgContent1;
	
	// 短信配置内容2
	@Column(name = "msg_content2", nullable = false, length = 100)
	@Length(min = 0, max = 100)
	private String msgContent2;
	
	// 短信配置内容3
	@Column(name = "msg_content3", nullable = false, length = 100)
	@Length(min = 0, max = 100)
	private String msgContent3;
	
	// 短信服务商提供的apikey
	@Column(name = "apikey", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 50)
	private String apikey;
	
	// 短信超时时间
	@Column(name = "time_out", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 10)
	private BigDecimal timeOut;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isShowShortMsg() {
		return showShortMsg;
	}

	public void setShowShortMsg(boolean showShortMsg) {
		this.showShortMsg = showShortMsg;
	}

	public BigDecimal getResendTime() {
		return resendTime;
	}

	public void setResendTime(BigDecimal resendTime) {
		this.resendTime = resendTime;
	}

	public String getMsgContent1() {
		return msgContent1;
	}

	public void setMsgContent1(String msgContent1) {
		this.msgContent1 = msgContent1;
	}

	public String getMsgContent2() {
		return msgContent2;
	}

	public void setMsgContent2(String msgContent2) {
		this.msgContent2 = msgContent2;
	}

	public String getMsgContent3() {
		return msgContent3;
	}

	public void setMsgContent3(String msgContent3) {
		this.msgContent3 = msgContent3;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public BigDecimal getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(BigDecimal timeOut) {
		this.timeOut = timeOut;
	}

//	public Object getPrivilegeAccount() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
