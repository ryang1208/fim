package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 投赢汇Job执行配置表
 *  
 * @author Jiabing
 *
 */
@Entity
@Table(name = "t_job_config")
public class IWinJobConfig implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_job_config_id") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	public Long getId() {return id;}
	public void setId(Long id) {	this.id = id;}
	
	// Job名称
	@Column(name = "job_name", length = 32)
	@Length(min = 1, max = 32)
	private String jobName;
	
	public void setjobName(String jobName) {	this.jobName = jobName;	}
	public String getJobName() {return this. jobName;}

	
	// Job组名
	@Column(name = "job_group", length = 32)
	@Length(min = 1, max = 32)
	private String jobGroup;
	
	public void setJobGroup(String jobGroup) {	this.jobGroup = jobGroup;	}
	public String getJobGroup() { return this.jobGroup ;}
	
	// Schedule名称
	@Column(name = "schedule_name", length = 32)
	@Length(min = 1, max = 32)
	private String scheduleName;
	
	public void setScheduleName(String scheduleName) {	this.scheduleName = scheduleName;	}
	public String getScheduleName() {return this.scheduleName;}
	
	// Schedule cron 执行表达式
	@Column(name = "schedule_cron_expression", length = 32)
	@Length(min = 1, max = 32)
	private String scheduleCronExpression;
	
	public void setScheduleCronExpression(String scheduleCronExpression) {	this.scheduleCronExpression = scheduleCronExpression;	}
	public String getScheduleCronExpression() {return this.scheduleCronExpression;}
	
	// 是否启用
	@Column(name = "is_run")
	private int isRun;
	
	public int getIsRun() {return this.isRun;}
	public void setIsRun(int isRun) {	this.isRun = isRun;}
	
	// 注释说明
	@Column(name = "comments", length = 128)
	@Length(min = 1, max = 128)
	private String comments;
	
	// 参数
	@Column(name = "parameter", length = 500)
	private String parameter;
	
	public String getComments() {return this.comments;}
	public void setComments(String comments) {	this.comments = comments;}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
}
