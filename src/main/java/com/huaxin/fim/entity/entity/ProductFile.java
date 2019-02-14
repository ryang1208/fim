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
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * 投赢汇经纪公司表对应的实体类
 */
@Entity
@Table(name = "t_product_file")
public class ProductFile implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product_file") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 产品代码
	@Column(name = "product_id", length = 30)
	private String productId;
	
	// 创建人ID
	@Column(name = "create_user_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String createUserId;
	
	// 创建日期
	@Column(name = "date", length = 8)
	@Length(min = 0, max = 8)
	private String date;
	
	// 文件名称
	@Column(name = "file_name", length = 100)
	@Length(min = 0, max = 100)
	private String fileName;
	
	// 文件路径
	@Column(name = "file_path", length = 100)
	@Length(min = 0, max = 100)
	private String filePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
