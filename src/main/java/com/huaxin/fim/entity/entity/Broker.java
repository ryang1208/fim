package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * 投赢汇经纪公司表对应的实体类
 */
@Entity
@Table(name = "t_broker", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "broker_name", "broker_type"})})
public class Broker implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_brokerInvester") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 经纪公司名称
	@Column(name = "broker_name", nullable = false, length = 100)
	@Length(min = 1, max = 100)
	private String brokerName;
	
	// 经纪公司类型
	@Column(name = "broker_type", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String brokerType;
	
	// 保证金监控中心代码
	@Column(name = "CFMMC_code", length = 32)
	@Length(min = 0, max = 32)
	private String cfmmcCode;
	
	// QDIAM代码
	@Column(name = "QDIAM_code", length = 32)
	@Length(min = 0, max = 32)
	private String qdiamCode;
	
	public String getBrokerType() {
		return brokerType;
	}

	public void setBrokerType(String brokerType) {
		this.brokerType = brokerType;
	}

	public String getCfmmcCode() {
		return cfmmcCode;
	}

	public void setCfmmcCode(String cfmmcCode) {
		this.cfmmcCode = cfmmcCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getQdiamCode() {
		return qdiamCode;
	}

	public void setQdiamCode(String qdiamCode) {
		this.qdiamCode = qdiamCode;
	}

	
	
}
