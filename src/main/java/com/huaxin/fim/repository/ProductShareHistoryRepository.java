package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductShareHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "productShareHistoryRepository")
@EntityClass(entityClass = ProductShareHistory.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface ProductShareHistoryRepository extends CrudRepository<ProductShareHistory, Long>{
	
	@Query(value="SELECT id,product_id,DATE,init_share "
			+ "FROM t_product_share_history "
			+ "WHERE product_id = :productId "
			+ "AND (date >= :date or date is null)"
			+ "GROUP BY init_share "
			+ "ORDER BY DATE" ,nativeQuery = true)
	public List<ProductShareHistory> getListByProductID(@Param("productId") String productId, @Param("date") String date);
	
	
}
