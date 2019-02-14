package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.CFMMCCusFund;
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
 * 
 * @Description:TODO
 * @author lihuijun
 *
 * @date: 2017年3月10日 下午4:58:30
 *
 */
@Repository("cFMMCCusFundRepository")
@EntityClass(entityClass = CFMMCCusFund.class)
public interface CFMMCCusFundRepository extends CrudRepository<CFMMCCusFund, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CFMMCCusFund c where c.date=:date and(c.investerID=:investerID) ")
	public void deleteByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Query("select c from CFMMCCusFund c where c.date=:date ")
	public List<CFMMCCusFund> findByDate(@Param("date") String date);

	@Query("select c from CFMMCCusFund c where c.date=:date and(c.investerID=:investerID) ")
	public CFMMCCusFund findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Query(value="SELECT SUM(tf.in_and_out_amount)  depositWithdrawToday,SUM(tt.commission) commissionToady "
			+ "FROM t_raw_cfmmc_fundchg tf LEFT JOIN t_raw_cfmmc_trddata tt "
			+ "ON tf.invester_id = tt.invester_id AND tf.date = tt.date "
			+ "WHERE tf.invester_id = :investerID AND tf.date = :date "
			+ "GROUP BY tf.invester_id,tf.date ", nativeQuery = true)
	public List<Object[]> findByDepositWithdrawToday(@Param("date") String date,
                                                     @Param("investerID") String investerID);
}
