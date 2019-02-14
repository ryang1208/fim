package com.huaxin.fim.api.standard;

import com.dev.framework.core.annotation.AllowAnonymous;
import com.dev.framework.core.annotation.FileGateway;

import java.io.FileNotFoundException;
import java.io.InputStream;

@FileGateway
@AllowAnonymous
public interface FileServiceForReactNative {
	// 上传文件，文件参数InputStream放在最后
	// 如果需要使用session，则必须定义@SessionAttribute(SESSION_ID_SESSION_ATTRIBUTE_KEY)
	// String sessionid变量
	public String uploadFile(String destPath, InputStream in);

	// 下载文件
	// 如果需要使用session，则必须定义@SessionAttribute(SESSION_ID_SESSION_ATTRIBUTE_KEY)
	// String sessionid变量
	public InputStream downloadFile(String fileUri)
			throws FileNotFoundException;
}
