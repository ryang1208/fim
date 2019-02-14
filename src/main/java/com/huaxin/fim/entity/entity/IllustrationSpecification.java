package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/*
 * 图例说明表对应实体类
 * liumd
 */
@Entity
@Table(name = "t_illustration_specification")
public class IllustrationSpecification implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_illustration_specification") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 图例名称
	@Column(name = "illustration_name", nullable = false, length = 50)
	@Length(min = 1, max = 50)
	private String illustrationName;
	
	// 图例说明
	@Column(name = "specification")
	private String specification;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIllustrationName() {
		return illustrationName;
	}

	public void setIllustrationName(String illustrationName) {
		this.illustrationName = illustrationName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
}
