package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.https.ResponseDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "responseDetailRepository")
@EntityClass(entityClass = ResponseDetail.class)
public interface ResponseDetailRepository extends CrudRepository<ResponseDetail, Long> {
	
	@Query(value = "select d from ResponseDetail d "
			+ "where d.ywrq = :ywrq "
			+ "and d.rawDataSource = :dataSource ")
	public List<ResponseDetail> findByYwrqAndDataSource(@Param("ywrq") String ywrq, @Param("dataSource") Integer dataSource);
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ResponseDetail p "
			+ "where p.ywrq=:date and p.productId=:productId")
	public void delByYwrqAndProductId(@Param("date") String date, @Param("productId") String productId);
}
