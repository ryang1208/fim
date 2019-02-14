package com.huaxin.fim.api;

import java.io.File;
import java.util.List;

import com.dev.framework.core.annotation.FileGateway;
import com.huaxin.fim.entity.entity.MailReceiveLog;

/**
 * 查询导入日志（通过邮件接收过的）业务处理接口
 * @author liumd
 *
 */
@FileGateway
public interface MailReceiveLogService {

	/**
	 * 根据日期获取导入文件日志
	 * @param date
	 * @return
	 */
	public List<MailReceiveLog> getLogList(String date);
	
	/**
	 * 下载指定日期错误日志
	 * @param date
	 * @return
	 */
	public File downLoadErrorLog(String date); 
}
