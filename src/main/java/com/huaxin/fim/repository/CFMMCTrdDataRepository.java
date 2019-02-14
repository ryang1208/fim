package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.CFMMCtrddata;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 成交明细导入
 * 
 * @Description:TODO
 * @author wangdl
 *
 * @date: 2017年3月10日 下午4:58:30
 *
 */
@Repository("cFMMCTrdDataRepository")
@EntityClass(entityClass = CFMMCtrddata.class)
public interface CFMMCTrdDataRepository extends CrudRepository<CFMMCtrddata, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CFMMCtrddata c where c.date=:date and (c.investerID=:investerID) ")
	public void deleteByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Query("select c from CFMMCtrddata c where c.date=:date ")
	public List<CFMMCtrddata> findByDate(@Param("date") String date);

	@Query("select c from CFMMCtrddata c where c.date=:date and (c.investerID=:investerID) "
			+ "and (c.transactionSerialNO=:transactionSerialNO) and (c.bs=:bs) ")
	public CFMMCtrddata findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID,
                                                @Param("transactionSerialNO") String transactionSerialNO, @Param("bs") int bs);

}
