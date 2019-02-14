package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Datadictionary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = Datadictionary.class)
@Named("datadictionaryRepository")
public interface DatadictionaryRepository extends CrudRepository<Datadictionary, Long> {
	
	@Query(value = "select f from Datadictionary f where dataType = :dataType or :dataType is null "
			+ " order by serno")
	public List<Datadictionary> findByDataType(@Param("dataType") String dataType);
	
	public Datadictionary findByDataTypeAndDataValue(String dataType, String dataVale);

	/**
	 * 查询所有投资策略基础数据
	 */
	@Query("select di from Datadictionary d,Datadictionary di "
			+ "where d.dataCode = di.dataType and d.dataType = 'InvestementStrategyType' "
			+ "order by d.id, di.serno")
	public List<Datadictionary> findAllInvestmentStrategy();


	@Query(value = "select new com.quantdo.iwin.entity.Datadictionary(i.id,i.dataType,i.dataTypeDescribe) "
			+ "from Datadictionary i where i.dataType = :dataType or :dataType is null "
			+ "GROUP BY i.dataType " )
	public List<Datadictionary> findDataType(@Param("dataType") String dataType);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from Datadictionary where dataType = :dataType ")
	public void deleteDatadictionaryByDataType(@Param("dataType") String dataType);

	/**
	 * 数据重复查询
	 */
	@Query("select m from Datadictionary m where m.dataType = :dataType AND (m.dataCode = :dataCode or m.dataValue = :dataValue) "
			+ "AND m.id <> :id  ")
	public Datadictionary findDatadictionaryByDataCodeAndId(@Param("dataType") String dataType, @Param("dataCode") String dataCode,
                                                            @Param("dataValue") String dataValue, @Param("id") Long id);

	/**
	 *
	 */
	@Query("select m from Datadictionary m where m.dataType = :dataType ")
	public List<Datadictionary> findDataByDataType(@Param("dataType") String dataType);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from Datadictionary where dataCode = :dataCode ")
	public void deleteDatadictionaryByDataCode(@Param("dataCode") String dataCode);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "update Datadictionary set  dataCode= :dataCode ,dataDescribe = :dataDescribe,"
			+ "dataValue = :dataValue,serno = :serno  where id = :id ")
	public void updateDatadictionary(@Param("dataCode") String dataCode, @Param("dataDescribe") String dataDescribe,
                                     @Param("dataValue") String dataValue, @Param("serno") int serno, @Param("id") Long id);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "INSERT INTO t_iwin_data_dictionary(data_code,data_describe,data_type,data_type_describe,data_value,ser_no) "
			+ "VALUES(:dataCode,:dataDescribe,:dataType,:dataTypeDescribe,:dataValue,:serno)",nativeQuery = true)
	public void saveDatadictionary(@Param("dataCode") String dataCode, @Param("dataDescribe") String dataDescribe, @Param("dataType") String dataType,
                                   @Param("dataTypeDescribe") String dataTypeDescribe, @Param("dataValue") String dataValue, @Param("serno") int serno);

	public Datadictionary findByDataTypeAndDataDescribe(String dataType, String dataDescribe);
	
}
	