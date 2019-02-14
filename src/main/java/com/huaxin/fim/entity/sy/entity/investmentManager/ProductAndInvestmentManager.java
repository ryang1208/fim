package com.huaxin.fim.entity.sy.entity.investmentManager;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 投资管理人
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_product_investment_manager", uniqueConstraints = {@UniqueConstraint(columnNames = {"investment_manager_id","fund_product_id"})} )
public class ProductAndInvestmentManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 管理人id
	@Column(name = "investment_manager_id", nullable = false)
	@NotNull
	@NotBlank
	private String investmentManagerId;
	
	// 产品代码
	@Column(name = "fund_product_id", nullable = false)
	@NotNull
	@NotBlank
	private String fundProductId;
	
	//状态  0报名  1通过  2初审不通过 3不通过
	@Column(name = "status", nullable = false)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 1)
	private String status;
	
	// 配置比例
	@Column(name = "set_scale", length = 100)
	@Length(min = 0, max = 100)
	private String setScale;
	
	//产品要素表名称
	@Column(name = "remark", length = 100)
	@Length(min = 0, max = 100)
	private String remark;
	
	//产品要素表名称
	@Column(name = "product_detail_name", length = 100)
	@Length(min = 0, max = 100)
	private String productDetailName;
	
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
	
	// 初审备注信息
	@Column(name = "first_trial_remark", length = 200)
	@Length(min = 0, max = 200)
	private String firstTrialRemark;
	
	// 终审备注信息
	@Column(name = "final_trial_remark", length = 200)
	@Length(min = 0, max = 200)
	private String finalTrialRemark;

	public String getFirstTrialRemark() {
		return firstTrialRemark;
	}

	public void setFirstTrialRemark(String firstTrialRemark) {
		this.firstTrialRemark = firstTrialRemark;
	}

	public String getFinalTrialRemark() {
		return finalTrialRemark;
	}

	public void setFinalTrialRemark(String finalTrialRemark) {
		this.finalTrialRemark = finalTrialRemark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvestmentManagerId() {
		return investmentManagerId;
	}

	public void setInvestmentManagerId(String investmentManagerId) {
		this.investmentManagerId = investmentManagerId;
	}

	public String getFundProductId() {
		return fundProductId;
	}

	public void setFundProductId(String fundProductId) {
		this.fundProductId = fundProductId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getProductDetailName() {
		return productDetailName;
	}

	public void setProductDetailName(String productDetailName) {
		this.productDetailName = productDetailName;
	}

	public String getSetScale() {
		return setScale;
	}

	public void setSetScale(String setScale) {
		this.setScale = setScale;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
