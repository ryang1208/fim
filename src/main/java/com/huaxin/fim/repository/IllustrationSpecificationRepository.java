package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.IllustrationSpecification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = IllustrationSpecification.class)
public interface IllustrationSpecificationRepository extends CrudRepository<IllustrationSpecification, Long> {
	
	@Query(value = "select b from IllustrationSpecification b ")
	public List<IllustrationSpecification> queryAllIllustrationInfo();
	
}	
