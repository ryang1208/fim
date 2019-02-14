package com.huaxin.fim.entity.sy.entity.basicInfo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 基金净值
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_fund_product_networth", uniqueConstraints = {@UniqueConstraint(columnNames = {"fund_product_id","valuation_date"})} )
public class FundProductNetWorth implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 基金产品代码
	@Column(name = "fund_product_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String fundProductID;
		
	// 估值日
	@Column(name = "valuation_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String valuationDate;
	
	// 单位净值
	@Column(name = "unit_networth", nullable = false, precision = 19, scale = 3)
	@NotNull
	@Digits(integer = 16, fraction = 3)
	private BigDecimal unitNetWorth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	public BigDecimal getUnitNetWorth() {
		return unitNetWorth;
	}

	public void setUnitNetWorth(BigDecimal unitNetWorth) {
		this.unitNetWorth = unitNetWorth;
	}
}
