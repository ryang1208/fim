package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.RawQDIAMPositionCloseDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *  <br>
 * 创建日期：2015年7月21日 下午7:14:10 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author 
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "rawQDIAMPositionCloseDetailsRepository")
@EntityClass(entityClass = RawQDIAMPositionCloseDetails.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface RawQDIAMPositionCloseDetailsRepository extends CrudRepository<RawQDIAMPositionCloseDetails, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from RawQDIAMPositionCloseDetails p where p.date = :date")
	public void delByDate(@Param("date") String date);
	
	@Query(value = "select max(f.date) from RawQDIAMPositionCloseDetails f")
	public String getMaxDate();
	
}
