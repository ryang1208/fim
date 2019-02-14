package com.huaxin.fim.entity.sy.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 渠道信息
 * @author xieky
 *
 */
@Entity(name="channelInformation")
@Table(name="t_channel_information", uniqueConstraints = {@UniqueConstraint(columnNames = {"channel_name"})} )
public class ChannelInformation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//渠道名称
	@Column(name = "channel_name", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 100)
	private String channelName;
	
	//渠道联系人
	@Column(name = "channel_contact", length = 50)
	@Length(min = 0, max = 50)
	private String channelContact;
	
	//电话
	@Column(name = "channel_phone", length = 20)
	@Length(min = 0, max = 20)
	private String channelPhone;
	
	//邮箱
	@Column(name = "channel_email", length = 50)
	@Length(min = 0, max = 50)
	private String channelEmail;
	
	//职位
	@Column(name = "channel_position", length = 50)
	@Length(min = 0, max = 50)
	private String channelPosition;
	
	//渠道用户状态
	@Column(name = "channel_status", length = 1)
	@Length(min = 0, max = 1)
	private String channelStatus;
	
	//备注
	@Column(name = "remark", length = 200)
	@Length(min = 0, max = 200)
	private String remark;
	
	//业务经理
	@Column(name = "service_manager_id", length = 50)
	@Length(min = 0, max = 50)
	private String serviceManagerID;
	
	//渠道登录ID
	@Column(name = "channel_login_id",length = 50)
	@Length(min = 0, max = 50)
	private String channelLoginID;
	
	//主机构
	@Column(name = "organization_id", length = 8)
	@Length(min = 0, max = 30)
	private String organizationId;	
			
	public String getOrganizationId() {
		return organizationId;
	}
	
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	//登录用户密码 用作临时存储
	@Transient
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelContact() {
		return channelContact;
	}

	public void setChannelContact(String channelContact) {
		this.channelContact = channelContact;
	}

	public String getChannelEmail() {
		return channelEmail;
	}

	public void setChannelEmail(String channelEmail) {
		this.channelEmail = channelEmail;
	}

	public String getChannelPosition() {
		return channelPosition;
	}

	public void setChannelPosition(String channelPosition) {
		this.channelPosition = channelPosition;
	}

	public String getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(String channelStatus) {
		this.channelStatus = channelStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getChannelLoginID() {
		return channelLoginID;
	}

	public void setChannelLoginID(String channelLoginID) {
		this.channelLoginID = channelLoginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceManagerID() {
		return serviceManagerID;
	}

	public void setServiceManagerID(String serviceManagerID) {
		this.serviceManagerID = serviceManagerID;
	}

	public String getChannelPhone() {
		return channelPhone;
	}

	public void setChannelPhone(String channelPhone) {
		this.channelPhone = channelPhone;
	}

}
