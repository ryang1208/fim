package com.huaxin.fim.entity.sy.entity.operateLog;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 
 * <br>
 * 创建日期：2015年11月2日 下午4:43:39 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author 李辉
 * @since 1.0
 * @version 1.0
 */
@Entity
@Table(name = "t_operate_log")
public class OperateLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="seq_t_operate_log")
	@Column(name = "id")
	private Long id;

	// 日志类型
	@Column(name = "log_type", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String logType;

	// 操作功能
	@Column(name = "function", nullable = false, length = 255)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 255)
	private String function;

	// 操作内容
	@Column(name = "operate_content", nullable = false, length = 500)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 500)
	private String operateContent;

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

	// 操作人IP
	@Column(name = "login_ip", length = 30)
	@Length(min = 0, max = 30)
	private String logonIp;

	@Column(name = "module", length = 80)
	@Length(min = 0, max = 80)
	private String module;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogonIp() {
		return logonIp;
	}

	public void setLogonIp(String logonIp) {
		this.logonIp = logonIp;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getOperateContent() {
		return operateContent;
	}

	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
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

}
