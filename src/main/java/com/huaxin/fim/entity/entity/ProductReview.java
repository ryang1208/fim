package com.huaxin.fim.entity.entity;

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
 * 基金产品回顾表
 * @author sust
 *
 */
@Entity
@Table(name = "t_product_review", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class ProductReview implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	//产品ID
	@Column(name = "product_id",length = 32)
	@Length(min = 1, max = 32)
	private String productID;
	
	//回顾内容
	@Column(name = "content", length = 4000)
	@Length(min = 1, max = 4000)
	private String content;
	
	//新增人员
	@Column(name = "user_id", length = 30)
	@Length(min = 0, max = 30)
	private String userID;
	
	//新增时间
	@Column(name = "insert_time")
	private String insertTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

}