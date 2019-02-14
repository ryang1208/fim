package com.huaxin.fim.entity.sy.entity.liquidation;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 持有人份额
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_share_holders")
public class ShareHolders implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 客户名称
	@Column(name = "client_name",  length = 100)
	@Length(min = 0, max = 100)
	private String clientName;
	
	// 证件类型
	@Column(name = "id_type", length = 15)
	@Length(min = 0, max = 15)
	private String idType;
	
	// 证件号码
	@Column(name = "id_number", length = 100)
	@Length(min = 0, max = 100)
	private String idNumber;
	
	// 客户类型
	@Column(name = "client_type", length = 15)
	@Length(min = 0, max = 15)
	private String clientType;
	
	// 销售商
	@Column(name = "seller", length = 20)
	@Length(min = 0, max = 20)
	private String seller;
	
	// 基金产品代码
	@Column(name = "fund_product_id", length = 10)
	@Length(min = 0, max = 10)
	private String fundProductID;
	
	// 基金名称
	@Column(name = "fund_product_name", length = 50)
	@Length(min = 0, max = 50)
	private String fundProductName;
	
	// 份额余额
	@Column(name = "share_remain", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal shareRemain;
	
	// 分红方式
	@Column(name = "bonus_type", length = 15)
	@Length(min = 0, max = 15)
	private String bonusType;
	
	// 管理人名称
	@Column(name = "admin_name", length = 100)
	@Length(min = 0, max = 100)
	private String adminName;
	
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
	
	//盐
	@Column(name = "salt", length = 20)
	@Length(min = 0, max = 20)
	private String salt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getFundProductName() {
		return fundProductName;
	}

	public void setFundProductName(String fundProductName) {
		this.fundProductName = fundProductName;
	}

	public String getBonusType() {
		return bonusType;
	}

	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public BigDecimal getShareRemain() {
		return shareRemain;
	}

	public void setShareRemain(BigDecimal shareRemain) {
		this.shareRemain = shareRemain;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
