package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.RowCDSShareSummary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = {"deleteAll"})
@EntityClass(entityClass = RowCDSShareSummary.class)
public interface RowCDSShareSummaryRepository extends CrudRepository<RowCDSShareSummary, Long> {

    public List<RowCDSShareSummary> findByUpdateDate(String updateDate);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_raw_cds_share_summary(product_id,date,client_name,data_source,client_type," +
            "update_date,hoding_share,frozen_share,pledge_share,available_share," +
            "client_product_id,client_product_code) Values(:productId,:date,:clientName," +
            ":datasource,:clientType,:updateDate,:hodingShare,:frozenShare," +
            ":pledgeShare,:availableShare,:clientProductId,:clientProductCode)", nativeQuery = true)
    public void insert(@Param("productId") String prodcutId, @Param("date") String date, @Param("clientName") String clientName,
                       @Param("datasource") int datasource, @Param("clientType") String clientType, @Param("updateDate") String updateDate,
                       @Param("hodingShare") BigDecimal hodingShare, @Param("frozenShare") BigDecimal frozenShare,
                       @Param("pledgeShare") BigDecimal pledgeShare, @Param("availableShare") BigDecimal availableShare,
                       @Param("clientProductId") String clientProductId, @Param("clientProductCode") String clientProductCode);
}
