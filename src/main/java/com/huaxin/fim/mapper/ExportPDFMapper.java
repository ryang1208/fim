package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.export.ExportFund;
import org.apache.ibatis.annotations.Param;

/**
 * 导出PDF查询页面基础信息
 * 
 * @Description:TODO
 * @author lihuijun
 *
 * @date: 2017年3月8日 下午6:37:16
 *
 */
public interface ExportPDFMapper {

	/**
	 * 描述: 查询基金基础信息
	 * 创建时间 2017年4月11日 下午5:33:40
	 */
	public ExportFund queryFundInfo(@Param("productId") Long productId);

}
