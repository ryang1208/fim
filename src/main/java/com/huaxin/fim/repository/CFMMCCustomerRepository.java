package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.CFMMCCustomer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资金导入
 * @Description:TODO
 * @author lihuijun
 *
 * @date:  2017年3月10日 下午4:58:30
 *
 */
@Repository("cFMMCCustomerRepository")
@EntityClass(entityClass = CFMMCCustomer.class)
public interface CFMMCCustomerRepository extends CrudRepository<CFMMCCustomer, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from CFMMCCustomer c where c.date=:date and(c.investerID=:investerID) ")
	public void deleteByDate(@Param("date") String date, @Param("investerID") String investerID);

	@Query("select c from CFMMCCustomer c where c.date=:date ")
	public List<CFMMCCustomer> findByDate(@Param("date") String date);
}
