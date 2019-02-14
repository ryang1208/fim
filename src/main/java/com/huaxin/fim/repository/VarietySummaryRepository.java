package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.VarietySummary;
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
 * 创建日期：2015年7月21日 下午7:14:10 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author 
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "varietySummaryRepository")
@EntityClass(entityClass = VarietySummary.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface VarietySummaryRepository extends CrudRepository<VarietySummary, Long> {

	@Query("select d from VarietySummary d,ProductInvesterRelationship r,iWinProduct p where "
			+ "d.investerID = r.investerID AND p.id = r.productID "
			+ "AND (p.productName like %:productName% or :productName is null) "
			+ "AND (d.date <=:endDate or :endDate is null) "
			+ "AND (d.date >:beginDate or :beginDate is null)")
	public List<VarietySummary> findByCondition(@Param("productName") String productName, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	public List<VarietySummary> findAll();
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from VarietySummary v "
			+ "where v.date=:date and (v.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Query(value = "SELECT MIN(DATE) FROM t_variety_summary t "
			+ "LEFT JOIN t_product_invester_relationship tp ON tp.invester_id = t.invester_id "
			+ "WHERE tp.product_id=:productId OR :productId IS NULL", nativeQuery = true)
	public String getMinDate(@Param("productId") String productId);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_variety_summary "
			+ "WHERE date between :startDate and :endDate and data_source =:dataSource  ", nativeQuery = true)
	public void delByDate(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("dataSource") Integer dataSource);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_variety_summary "
			+ "WHERE date  =:date  and data_source =:dataSource and invester_id=:investerID ", nativeQuery = true)
	public void delByDateAnddataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_variety_summary "
			+ "WHERE date  =:date  and invester_id=:investerID ", nativeQuery = true)
	public void delByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

}
