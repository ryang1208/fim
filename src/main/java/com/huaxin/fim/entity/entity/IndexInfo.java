package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 指数标准数据
 * 
 * @author wucq
 * @since 20171208
 * @version 1.0
 */
@Entity
@Table(name = "t_index_info")
public class IndexInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_index") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 指数标准名称
	@Column(name = "index_name", length = 10)
	private String indexName;
	
	// 是否基准指数
	@Column(name = "is_standard_index", precision = 16, scale = 4)
	@Length(min = 0, max = 2)
	private String isStandardIndex;
	
	// 是否显示指数屏
	@Column(name = "is_show_index", length = 2)
	@Length(min = 0, max = 2)
	private String isShowIndex;
	
	// 数据来源
	@Column(name = "data_source")
	private String dataSource;
	
	// string指数代码
	@Transient
	private String indexID;
	
	@Transient
	private String indexOldName;

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIsStandardIndex() {
		return isStandardIndex;
	}

	public void setIsStandardIndex(String isStandardIndex) {
		this.isStandardIndex = isStandardIndex;
	}

	public String getIsShowIndex() {
		return isShowIndex;
	}

	public void setIsShowIndex(String isShowIndex) {
		this.isShowIndex = isShowIndex;
	}

	public String getIndexID() {
		return indexID;
	}

	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}

	public IndexInfo() {
	}

	public IndexInfo(String indexName, Long indexID) {
		this.id = indexID;
		this.indexName = indexName;
		this.indexID = "" + indexID;
	}

	public String getIndexOldName() {
		return indexOldName;
	}

	public void setIndexOldName(String indexOldName) {
		this.indexOldName = indexOldName;
	}
		
}
