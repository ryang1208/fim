package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.SimulationProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Forbid(forbiddenMethods = { "deleteAll" })
@Repository(value = "simulationProductRepository")
@EntityClass(entityClass = SimulationProduct.class)
public interface SimulationProductRepository extends CrudRepository<SimulationProduct, Long> {
	
	/**
	 * 根据产品名称获取组合产品信息
	 * @param productName
	 * @return
	 */
	public List<SimulationProduct> findByProductName(String productName);
}	
