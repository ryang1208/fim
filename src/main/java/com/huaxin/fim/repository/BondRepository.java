package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Bond;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <br>
 * 创建日期：2018年3月27日 <br>
 *
 * @author sust
 * @version 1.0
 * @since 1.0
 */
@Repository(value = "bondRepository")
@EntityClass(entityClass = Bond.class)
@Forbid(forbiddenMethods = {"deleteAll"})
public interface BondRepository extends CrudRepository<Bond, Long> {

    public Bond findByBondIdAndExchangeId(String bondId, String exchangeId);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_bond(bond_id,exchange_id,bond_inner_id,bond_name,value_date," +
            "due_date,interest_rate_type,bond_type,coupon_rate,pay_interest_frequency) " +
            "values(:bondId,:exchangeId,:bondInnerId,:bondName,:valueDate,:dueDate," +
            ":interestRateType,:bondType,:couponRate,:payInterestFrequency)", nativeQuery = true)
    public void insert(@Param("bondId") String bondId, @Param("exchangeId") String exchangeId, @Param("bondInnerId") String bondInnerId,
                       @Param("bondName") String bondName, @Param("valueDate") String valueDate, @Param("dueDate") String dueDate,
                       @Param("interestRateType") String interestRateType, @Param("bondType") String bondType,
                       @Param("couponRate") BigDecimal couponRate, @Param("payInterestFrequency") int payInterestFrequency);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "update t_bond set bond_inner_id =:bondInnerId,bond_name=:bondName,value_date=:valueDate,due_date=:dueDate," +
            "interest_rate_type=:interestRateType,bond_type=:bondType,coupon_rate=:couponRate," +
            "pay_interest_frequency=:payInterestFrequency where id = :id", nativeQuery = true)
    public void update(@Param("bondInnerId") String bondInnerId, @Param("bondName") String bondName, @Param("valueDate") String valueDate,
                       @Param("dueDate") String dueDate, @Param("interestRateType") String interestRateType, @Param("bondType") String bondType,
                       @Param("couponRate") BigDecimal couponRate, @Param("payInterestFrequency") int payInterestFrequency, @Param("id") long id);

}
