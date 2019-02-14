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
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 信息发布类
 * @author xieky
 *
 */

@Entity
@Table(name = "t_system_message")
public class SystemMessage  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 发布信息标题
	@Column(name = "title", nullable = false, length = 200)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 200)
	private String title;
	
	// 发布信息
	@Column(name = "message",length = 1000)
	@Length(min = 0, max = 1000)
	private String message;

	
	// 发布人
	@Column(name = "release_man", length = 20)
	@Length(min = 0, max = 20)
	private String releaseMan;
	
	@Column(name = "accept_man", length = 20)
	@Length(min = 0, max = 20)
	private String acceptMan;
	
	// 发布时间
	@Column(name = "release_date", length = 20)
	@Length(min = 0, max = 20)
	private String releaseDate;
	
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
	
	//开始日期
	@Transient
	private String beginDate;
	
	//结束日期
	@Transient
	private String endDate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReleaseMan() {
		return releaseMan;
	}

	public void setReleaseMan(String releaseMan) {
		this.releaseMan = releaseMan;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAcceptMan() {
		return acceptMan;
	}

	public void setAcceptMan(String acceptMan) {
		this.acceptMan = acceptMan;
	}

}
