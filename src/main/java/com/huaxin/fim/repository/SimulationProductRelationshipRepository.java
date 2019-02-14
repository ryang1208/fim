package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.SimulationProductRelationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Forbid(forbiddenMethods = { "deleteAll" })
@Repository(value = "simulationProductRelationshipRepository")
@EntityClass(entityClass = SimulationProductRelationship.class)
public interface SimulationProductRelationshipRepository extends CrudRepository<SimulationProductRelationship, Long> {
	
}	
