package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductPeriodStatistics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;
import java.util.Set;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductPeriodStatistics.class)
@Named("productPeriodStatisticsRepository")
public interface ProductPeriodStatisticsRepository extends CrudRepository<ProductPeriodStatistics, Long> {
	
	public List<ProductPeriodStatistics> findAll();

	/**
	 * 获取相关KPI
	 */
	@Query(value = "select p from ProductPeriodStatistics p "
			+ "where p.KPI = :KPI "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.date")
	public List<ProductPeriodStatistics> findProductKPIsByProductIdAndKPI(@Param("productID") String productID, @Param("KPI") String KPI);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ProductPeriodStatistics p "
			+ "where p.date >=:date and (p.productID = :productID)")
	public void delByDates(@Param("date") Set<String> date, @Param("productID") String productID);

	/**
	 * 获取某产品指定指标最新单日数据
	 */
	@Query("select p from ProductPeriodStatistics p "
			+ "where p.productID = :productID and p.KPI in (:yearKpis)")
	public List<ProductPeriodStatistics> findByMaxDateProductIDAndKPIs(@Param("productID") String productID,
                                                                       @Param("yearKpis") List<String> yearKpis);
	
	/**
	 * 获取所有有指标的产品列表
	 */
	@Query(value=" SELECT                              "
			+"     t.product_id                      "
			+"   FROM                                 "
			+"     t_product_period_statistics t            "
			+"   GROUP BY t.product_id  ",nativeQuery=true)
	public List<String> findProductIDList();
	
}	