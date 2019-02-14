package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.PositionCloseDetails;
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
@Repository(value = "positionCloseDetailsRepository")
@EntityClass(entityClass = PositionCloseDetails.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface PositionCloseDetailsRepository extends CrudRepository<PositionCloseDetails, Long> {

	@Query("select pc from PositionCloseDetails pc,ProductInvesterRelationship pr,iWinProduct p where "
			+ "pc.investerID = pr.investerID AND pr.productID = p.id  AND pc.brokerID = pr.brokerID "
			+ "AND (p.productName =:productName or :productName is null) "
			+ "AND (pc.date <=:endDate or :endDate is null) "
			+ "AND (pc.date >=:beginDate or :beginDate is null) order by pc.date desc,pc.contact asc")
	public List<PositionCloseDetails> findByCondition(@Param("productName") String productName, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	public List<PositionCloseDetails> findAll();

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from PositionCloseDetails p "
			+ "where p.date=:date and (p.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from PositionCloseDetails p "
			+ "where p.investerID=:investerID and (p.date >=:date) and (p.date <=:endDate)")
	public void delByPrimaryKeyDate(@Param("date") String date, @Param("investerID") String investerID,
                                    @Param("endDate") String endDate);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from PositionCloseDetails p "
			+ "where p.date=:date and (p.investerID=:investerID) and (p.dataSource=:dataSource)")
	public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("investerID") String investerID, @Param("dataSource") Integer dataSource);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_position_close_details where concat(date,'#',broker_id,'#',invester_id) in "
			+ "(select concat(rf.date,'#',rf.broker_id,'#',rf.invester_id) "
			+ "from t_raw_qdiam_position_close_details rf where rf.date = :date)",nativeQuery = true)
	public void delQDIAMByDate(@Param("date") String date);
	
}
