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
 * 基金产品对应的实体类
 */
@Entity
@Table(name = "t_bond_evaluate" , uniqueConstraints = {
		@UniqueConstraint(columnNames = {"date","bond_id"}) }	)
public class BondEvaluate implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	// 债券代码
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	// 债券内部编码
	@Column(name = "bond_id", length = 50)
	@Length(min = 0, max = 50)
	@NotNull
	@NotBlank
	private String bondId;
	// 债项评级
	@Column(name = "rating", length = 30)
	@Length(min = 0, max = 30)
	private String rating;
	
	// 评价机构
	@Column(name = "organization", length = 30)
	@Length(min = 0, max = 30)
	@NotNull
	@NotBlank
	private String organization;

	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBondId() {
		return bondId;
	}
	public void setBondId(String bondId) {
		this.bondId = bondId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
