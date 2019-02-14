package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.CTPInvesterFund;
import com.huaxin.fim.entity.entity.InvesterFund;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * 创建日期：2015年7月21日 下午7:14:10 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "ctpInvesterFundRepository")
@EntityClass(entityClass = CTPInvesterFund.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface CTPInvesterFundRepository extends CrudRepository<CTPInvesterFund, Long> {

	@Query("select pc from InvesterFund pc,ProductInvesterRelationship pr,iWinProduct p where "
			+ "pc.investerID = pr.investerID AND pr.productID = p.id "
			+ "AND (p.productName like %:productName% or :productName is null) "
			+ "AND (pc.date <=:endDate or :endDate is null) " + "AND (pc.date >:beginDate or :beginDate is null)")
	public List<InvesterFund> findByCondition(@Param("productName") String productName,
											  @Param("beginDate") String beginDate, @Param("endDate") String endDate);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CTPInvesterFund i " + "where i.date=:date and (i.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Query(value = "SELECT MIN(DATE) FROM t_invester_fund t "
			+ "LEFT JOIN t_product_invester_relationship t1 "
			+ "ON t1.invester_id = t.invester_id "
			+ "WHERE t1.product_id=:productId OR :productId IS NULL", nativeQuery = true)
	public String getMinDate(@Param("productId") String productId);

	@Query("select c from CTPInvesterFund c where c.date=:date and(c.investerID=:investerID) ")
	public List<CTPInvesterFund> findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from InvesterFund p "
			+ "where p.date=:date and (p.dataSource=:dataSource) and (p.investerID=:investerID) ")
	public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource, @Param("investerID") String investerID);
	
}
