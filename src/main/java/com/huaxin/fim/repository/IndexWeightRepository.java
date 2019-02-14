package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.IndexWeight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("indexWeightRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = IndexWeight.class)
public interface IndexWeightRepository extends CrudRepository<IndexWeight, Long> {
	
	public List<IndexWeight> findByDate(@Param("date") String date);
	
	@Query("select w from IndexWeight w "
			+ "where (w.date >= :startDate or :startDate is null) "
			+ "and (w.date <= :endDate or :endDate is null)")
	public List<IndexWeight> findByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
	