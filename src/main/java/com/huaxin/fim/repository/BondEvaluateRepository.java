package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.BondEvaluate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品指数周期
 */
@Repository("bondEvaluateRepository")
@Forbid(forbiddenMethods = {"deleteAll"})
@EntityClass(entityClass = BondEvaluate.class)
public interface BondEvaluateRepository extends CrudRepository<BondEvaluate, Long> {

    /**
     * 取得债券评级表
     */
    @Query(value = "SELECT e.date,e.bond_id,rating FROM t_bond_evaluate e "
            + "WHERE e.date < :endDate "
            + "and e.organization = :organization "
            + "ORDER BY e.bond_id,e.DATE DESC", nativeQuery = true)
    public List<Object[]> findRatingListByOrganizationAndDate(@Param("endDate") String endDate, @Param("organization") String organization);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_bond_evaluate(date,bond_id,rating,organization) values(:date,:bondId,:rating,:organization)",nativeQuery = true)
    public void insert(@Param("date") String date, @Param("bondId") String bondId, @Param("rating") String rating, @Param("organization") String organization);


}
	