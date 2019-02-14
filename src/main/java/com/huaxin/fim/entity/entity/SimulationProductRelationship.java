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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 模拟组合构建产品关系表（设置权重比例）
 * @author liumd
 *
 */
@Entity
@Table(name = "t_simulation_product_relationship")
public class SimulationProductRelationship implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="seq_t_simulation_product_relationship")	
	@Column(name = "id")
	private long id;
	
	private static final long serialVersionUID = 1L;
	// 组合产品代码
	@Column(name = "simulate_product_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String simulateProductId;
	
	// 成分产品代码
	@Column(name = "product_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String productId;
	
	// 权重
	@Column(name = "weight", precision = 7, scale = 4)
	@Digits(integer = 3, fraction = 4)
	private BigDecimal weight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSimulateProductId() {
		return simulateProductId;
	}

	public void setSimulateProductId(String simulateProductId) {
		this.simulateProductId = simulateProductId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
}
