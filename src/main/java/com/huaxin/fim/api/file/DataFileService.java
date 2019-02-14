package com.huaxin.fim.api.file;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;

@Gateway
public interface DataFileService {

	//文件上传
	public Map<String, Object> fileUpload(List<File> fileList);

	//文件解析
	public Map<String, List<String>> fileAnalysis(String fileType, String filePath, String productIds, Integer dataSource);

	//指数解析
	public Map<String, List<String>> fileIndexAnalysis(String fileType, String filePath, String productIds, Integer dataSource,
                                                       String indexId, String indexName);

	//文件状态轮训
	public String getFileStatus(String str);

	public void productQuota(String[] productIds, String currentTime);

}
