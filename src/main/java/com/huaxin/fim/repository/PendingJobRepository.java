package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.PendingJob;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 *  <br>
 * 
 *  @author 
 * @since 1.0
 * @version 1.0
 */

	
@Repository(value = "pendingJobRepository")
@EntityClass(entityClass = PendingJob.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface PendingJobRepository extends CrudRepository<PendingJob, Long> {	

	@Query("select pj from PendingJob pj  where pj.isWorking=1 "
			+ "AND (pj.date =:date or :date is null) "
			+ "AND (pj.productID =:productID or :productID is null) "
			+ "AND (pj.KPIType =:KPIType)")
	public List<PendingJob> findByCondition(@Param("date") String date, @Param("productID") String productID, @Param("KPIType") Integer KPIType);
	
	@Query("select pj from PendingJob pj  where pj.isWorking=1 "
			+ "AND (pj.date =:date or :date is null) "
			+ "AND (pj.productID =:productID or :productID is null) "
			+ "AND (pj.KPIType =:KPIType)")
	public PendingJob findByConditions(@Param("date") String date, @Param("productID") String productID, @Param("KPIType") Integer KPIType);
	
	@Query("select pj from PendingJob pj  "
			+ "where (pj.date =:date) "
			+ "AND (pj.productID =:productID) "
			+ "AND (pj.KPIType =:KPIType)")
	public PendingJob findByDateAndProductIDAndKPIType(@Param("date") String date, @Param("productID") String productID, @Param("KPIType") Integer KPIType);
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from t_pending_job where (product_id = :productID or :productID is null) and date <:date and is_working = '1'",nativeQuery=true)
	public void delAllPendingJobKey(@Param("productID") String productID, @Param("date") String date);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from t_pending_job  where date =:date  "
			+ "AND product_id =:productID  "
			+ "AND KPI_type =:KPIType",nativeQuery=true)
	public void delPendingJobByCondition(@Param("date") String date, @Param("productID") Integer productID, @Param("KPIType") Integer KPIType);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from t_pending_job where product_id = :productID and (date = :date) ",nativeQuery=true)
	public void delAllPendingJobByIDAndDate(@Param("productID") String productID, @Param("date") String date);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="update PendingJob set isWorking = :isWorking where productID = :productID")
	public void updatePendingJobByID(@Param("productID") String productID, @Param("isWorking") String isWorking);

	public List<PendingJob> findByProductIDAndIsWorking(@Param("productID") String productID, @Param("isWorking") String isWorking);
	
	public List<PendingJob> findByIsWorking(@Param("isWorking") String isWorking);
}
