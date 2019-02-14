package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Variety;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "varietyRepository")
@EntityClass(entityClass = Variety.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface VarietyRepository extends CrudRepository<Variety, Long>{

    
    @Query(value = "SELECT distinct t.variety_id FROM t_variety t WHERE (t.variety_name = :varityName ) ", nativeQuery = true)
    public List<String> getVariety(@Param("varityName") String varityName);
    
    @Query(value = "SELECT t.variety_id FROM t_variety t WHERE (t.variety_name =:varityName OR :varityName IS NULL) "
            + "AND t.exchange_id = :exchangeId ", nativeQuery = true)
    public String getVarietyByVarityNameAndId(@Param("varityName") String varityName, @Param("exchangeId") String exchangeId);
}
