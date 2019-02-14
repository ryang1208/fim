package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.IndexContent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("indexContentRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = IndexContent.class)
public interface IndexContentRepository extends CrudRepository<IndexContent, Long> {
	
	public List<IndexContent> findByDate(@Param("date") String date);

	@Query(value="Select i from IndexContent i where i.indexId = :indexId and i.date >=:beginDate and i.date <= :endDate "
			+ "order by i.date")
	public List<IndexContent> findIndexContentByIndexIdAndDate(@Param("indexId") String indexId, @Param("beginDate") String beginDate,
                                                               @Param("endDate") String endDate);


    /**
     * 根据日期删除
     * @param date
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value=" delete from   t_index_content  where date=:date",nativeQuery=true)
    public void delIndexContentByDate(@Param("date") String date);
    

}
	