package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 母子基金对应关系表（1:N对应）
 */
@Entity
@Table(name = "t_products_relationship", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "parent_product_id", "product_id"})})
public class ProductsRelationship implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// 母基金ID
	@Column(name = "parent_product_id")
	private int parent_ProductID;
	
	// 子基金ID
	@Column(name = "product_id")
	private int productID;
	
	// 比例
	@Column(name = "product_ratio", precision = 5, scale = 4)
	@Digits(integer = 1, fraction = 4)
	private BigDecimal productRatio;
	
	// 起始日期
	@Column(name = "start_date", length = 8)
	@Length(min = 0, max = 8)
	private String startDate;
	
	// 结束日期
	@Column(name = "end_date", length = 8)
	@Length(min = 0, max = 8)
	private String endDate;
	
	// 插入日期
	@Column(name = "insert_date", length = 8)
	@Length(min = 0, max = 8)
	private String insertDate;
	
	// 类型(1:母基金投资在子基金占比；2:子基金投资在母基金占比)
	@Column(name = "type", length = 2)
	@Length(min = 1, max = 2)
	private String type;
	
	// 是否人工录入
	@Column(name = "is_manual", length = 2)
	@Length(min = 1, max = 2)
	private String isManual; 

    public String getIsManual() {
		return isManual;
	}

	public void setIsManual(String isManual) {
		this.isManual = isManual;
	}

	@Transient
    private String parentProductIDStr;
   
    @Transient
    private String productIDStr;
    
    @Transient
    private String productName;


	public int getParent_ProductID() {
		return parent_ProductID;
	}

	public void setParent_ProductID(int parent_ProductID) {
		this.parent_ProductID = parent_ProductID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getProductRatio() {
		return productRatio;
	}

	public void setProductRatio(BigDecimal productRatio) {
		this.productRatio = productRatio;
	}

	public String getParentProductIDStr() {
		return parentProductIDStr;
	}

	public void setParentProductIDStr(String parentProductIDStr) {
		this.parentProductIDStr = parentProductIDStr;
	}

	public String getProductIDStr() {
		return productIDStr;
	}

	public void setProductIDStr(String productIDStr) {
		this.productIDStr = productIDStr;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
