package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductFile.class)
public interface ProductFileRepository extends CrudRepository<ProductFile, Long> {
	
	/**
	 * 根据登录用户及日期获取文件信息
	 * @param createUserId
	 * @param date
	 * @param filePath
	 * @return
	 */
	public List<ProductFile> findByCreateUserIdAndDateAndFilePath(String createUserId, String date, String filePath);

	/**
	 * 根据产品代码获取产品上传文件列表
	 * @param productId
	 * @return
	 */
	public List<ProductFile> findByProductId(String productId);

	public List<ProductFile> findByCreateUserIdAndDateAndFilePathAndFileName(String createUserId, String date, String filePath, String fileName);

	public List<ProductFile> findByCreateUserIdAndFileNameAndProductId(String createUserId, String fileName, String productId);
	
}	
