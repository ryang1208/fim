package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 接入日志信息
 */
@Entity
@Table(name = "t_data_access_log")
public class DataAccessLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	// 接入日期
	@Column(name = "access_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String accessDate;

	// 文件日期
	@Column(name = "file_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String fileDate;

	// 文件来源(参考DataAccessFileSourceEnum)
	@Column(name = "file_source", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String fileSource;
	
	// 日志信息
	@Column(name = "log_info", length = 5000)
	@Length(min = 0, max = 5000)
	private String logInfo;

	// 操作时间
	@Column(name = "operate_time", length = 8)
	@Length(min = 0, max = 8)
	private String operateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(String accessDate) {
		this.accessDate = accessDate;
	}

	public String getFileDate() {
		return fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	public String getFileSource() {
		return fileSource;
	}

	public void setFileSource(String fileSource) {
		this.fileSource = fileSource;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	
	@Transient
	private String moreThenYesterdayNum;
	
	@Transient
	private String lessThenYesterdayNum;
	
	@Transient
	private String errorInfo; 

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getMoreThenYesterdayNum() {
		return moreThenYesterdayNum;
	}

	public void setMoreThenYesterdayNum(String moreThenYesterdayNum) {
		this.moreThenYesterdayNum = moreThenYesterdayNum;
	}

	public String getLessThenYesterdayNum() {
		return lessThenYesterdayNum;
	}

	public void setLessThenYesterdayNum(String lessThenYesterdayNum) {
		this.lessThenYesterdayNum = lessThenYesterdayNum;
	}
}
