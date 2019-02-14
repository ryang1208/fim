package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.SimulationProductNetValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Forbid(forbiddenMethods = { "deleteAll" })
@Repository(value = "simulationProductNetValueRepository")
@EntityClass(entityClass = SimulationProductNetValue.class)
public interface SimulationProductNetValueRepository extends CrudRepository<SimulationProductNetValue, Long> {
	
}	
