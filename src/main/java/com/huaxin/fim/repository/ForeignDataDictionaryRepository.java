package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Datadictionary;
import com.huaxin.fim.entity.entity.ForeignDataDictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = Datadictionary.class)
@Named("foreignDataDictionaryRepository")
public interface ForeignDataDictionaryRepository extends CrudRepository<ForeignDataDictionary, Long> {
	
	@Query(value = "select f from ForeignDataDictionary f where dataType = :dataType or :dataType is null "
			+ " order by serno")
	public List<ForeignDataDictionary> findByDataType(@Param("dataType") String dataType);
	
	public ForeignDataDictionary findByDataTypeAndDataValue(String dataType, String dataVale);

	@Query(value = "select new com.quantdo.iwin.entity.ForeignDataDictionary(i.id,i.dataType,i.dataTypeDescribe) "
			+ "from ForeignDataDictionary i where i.dataType = :dataType or :dataType is null "
			+ "GROUP BY i.dataType " )
	public List<ForeignDataDictionary> findDataType(@Param("dataType") String dataType);

	/**
	 * 数据重复查询
	 */
	@Query("select m from ForeignDataDictionary m where m.dataType = :dataType AND (m.dataCode = :dataCode or m.dataValue = :dataValue) "
			+ "AND m.id <> :id  ")
	public ForeignDataDictionary findDatadictionaryByDataCodeAndId(@Param("dataType") String dataType, @Param("dataCode") String dataCode,
                                                                   @Param("dataValue") String dataValue, @Param("id") Long id);
	
	/**
	 * 
	 */
	@Query("select m from ForeignDataDictionary m where m.dataType = :dataType ")
	public List<ForeignDataDictionary> findDataByDataType(@Param("dataType") String dataType);

	
}
	