package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.IndexInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("indexInfoRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = IndexInfo.class)
public interface IndexInfoRepository extends CrudRepository<IndexInfo, Long> {
	@Query("select m from IndexInfo m where m.indexName Like %:indexName% or :indexName is null ")
	public List<IndexInfo> findIndexInfo(@Param("indexName") String indexName);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from IndexInfo where indexName = :indexName ")
	public void deleteIndexInfoByIndexName(@Param("indexName") String indexName);

	/**
	 * �������л�׼ָ��
	 */
	@Query("select new com.quantdo.iwin.entity.IndexInfo(i.indexName,i.id) "
			+ "from IndexInfo i where i.isStandardIndex = '1'")
	public List<IndexInfo> findStandardIndex();

	/**
	 * 指数重复查询
	 */
	@Query("select m from IndexInfo m where m.indexName = :indexName "
			+ "AND m.id <> :id  ")
	public IndexInfo findIndexInfoByIndexNameAndId(@Param("indexName") String indexName, @Param("id") Long id);
	
}
	