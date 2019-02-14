package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductReview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductReviewRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductReview.class)
public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
	
	@Query("select p from ProductReview p "
			+ "WHERE p.productID = :ProductID "
			+ "order by insertTime desc")
	public List<ProductReview> findByProductID(@Param("ProductID") String ProductID);
}	
