package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.SimulationProductPeriodKpiStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Forbid(forbiddenMethods = { "deleteAll" })
@Repository(value = "simulationProductPeriodKPIStatisticsRepository")
@EntityClass(entityClass = SimulationProductPeriodKpiStatistics.class)
public interface SimulationProductPeriodKPIStatisticsRepository extends CrudRepository<SimulationProductPeriodKpiStatistics, Long> {
	
}	
