package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.RawFundValuation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = RawFundValuation.class)
public interface RawFundValuationRepository extends CrudRepository<RawFundValuation,Long> {


    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value="delete from RawFundValuation p "
            + "where p.ywrq=:date and p.productId=:productId")
    public void delByYwrqAndProductId(@Param("date") String date, @Param("productId") String productId);


}
