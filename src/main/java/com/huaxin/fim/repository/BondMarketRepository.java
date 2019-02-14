package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.BondMarket;
import com.huaxin.fim.entity.entity.PositionSummary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * <br>
 * 创建日期：2018年3月27日 <br>
 * 
 * @author sust
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "bondMarketRepository")
@EntityClass(entityClass = PositionSummary.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface BondMarketRepository extends CrudRepository<BondMarket, Long> {

    @Query("select b from BondMarket b "
            + "where b.date <= :endDate "
            + "and (b.bondId = :bondId or :bondId is null) "
            + "order by b.bondId,b.date desc")
    public List<BondMarket> findListByDateAndBondID(@Param("bondId") String bondId, @Param("endDate") String endDate);


    @Query(value = "select * from t_bond_market where bond_id = :bondId order by id desc limit 1",nativeQuery = true)
    public BondMarket findLatestByBondId(@Param("bondId") String bondId);


    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_bond_market(date,bond_id,par_value) values(:date,:bondId,:parValue)",nativeQuery = true)
    public void insert(@Param("date") String date, @Param("bondId") String bondId, @Param("parValue") BigDecimal parValue);
}
