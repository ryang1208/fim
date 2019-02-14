package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FundEvaluationReport;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("fundEvaluationReportRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FundEvaluationReport.class)
public interface FundEvaluationReportRepository extends CrudRepository<FundEvaluationReport, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from FundEvaluationReport i "
			+ "where (i.date>=:startDate or :startDate is null)  and (i.date<=:endDate or :endDate is null)"
			+ "and (i.productId =:productId or :productId is null)")
	public void deleteByDateAndProduct(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("productId") String productId);
}
	