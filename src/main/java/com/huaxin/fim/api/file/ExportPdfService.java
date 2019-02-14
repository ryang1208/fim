package com.huaxin.fim.api.file;

import java.util.List;

import com.dev.framework.core.annotation.FileGateway;
import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.request.ExportPDFRequest;
import com.huaxin.fim.entity.response.ProductMarketTypeResponse;

/**
 * 
 *
 * 描述: 前端Web页面导出pdf文件
 *
 * @author 李会军
 * 
 * @date 2017年3月31日 上午10:15:22 
 *
 */
@FileGateway
public interface ExportPdfService {

	/**
	 * 
	 * @param productId
	 * @param paramList
	 * @param pageSize
	 * @param productMarketType(产品市场类型)
	 * @return
	 * @throws ServiceException
	 */
	public List<?> exportPdfFromWeb(Long productId, List<ExportPDFRequest> paramList, int pageSize, ProductMarketTypeResponse productMarketType)throws ServiceException;

	/**
	 * 基金对比分析导出pdf
	 * @param productIds
	 * @param indexId
	 * @param periodType
	 * @return
	 * @throws ServiceException
	 */
	public List<?> exportContrastPdfFromWeb(String productIds, List<ExportPDFRequest> paramList, String indexId, String periodType)throws ServiceException;

	/**
	 * 母基金导出pdf
	 * @param productId
	 * @param paramList
	 * @param pageSize
	 * @param productMarketType(产品市场类型)
	 * @return
	 * @throws ServiceException
	 */
	public List<?> exportParentPdf(Long productId, List<ExportPDFRequest> paramList, int pageSize, ProductMarketTypeResponse productMarketType)throws ServiceException;

	/**
	 * 子基金导出净值pdf
	 * @param productId
	 * @param paramList
	 * @param pageSize
	 * @param productMarketType(产品市场类型)
	 * @return
	 * @throws ServiceException
	 */
	public List<?> exportNetValuePdfFromInterface(Long productId, List<ExportPDFRequest> paramList, int pageSize, ProductMarketTypeResponse productMarketType)throws ServiceException;

	/**
	 * 子基金导出证券pdf
	 * @param productId
	 * @param paramList
	 * @param pageSize
	 * @param productMarketType(产品市场类型)
	 * @return
	 * @throws ServiceException
	 */
	public List<?> exportSecurityPdfFromInterface(Long productId, List<ExportPDFRequest> paramList, int pageSize, ProductMarketTypeResponse productMarketType)throws ServiceException;

	
}
