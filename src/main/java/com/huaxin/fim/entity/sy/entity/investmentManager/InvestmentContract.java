package com.huaxin.fim.entity.sy.entity.investmentManager;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * 投顾联系人
 * 
 * @author xieky
 *
 */
@Entity
@Table(name = "t_investment_contract", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class InvestmentContract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	// 投顾ID
	@Column(name = "investment_id", nullable = false, length = 200)
	@Length(min = 0, max = 20)
	private String investmentID;

	// 联系人
	@Column(name = "contract_name", nullable = false, length = 200)
	@Length(min = 0, max = 200)
	private String contractName;

	// 职务
	@Column(name = "post", length = 200)
	@Length(min = 0, max = 200)
	private String post;

	// 电话
	@Column(name = "phone", length = 50)
	@Length(min = 0, max = 50)
	private String phone;

	// 邮件
	@Column(name = "email", length = 200)
	@Length(min = 0, max = 200)
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

}
