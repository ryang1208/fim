package com.huaxin.fim.api.standard;

import com.dev.framework.core.annotation.FileGateway;
import com.dev.framework.core.annotation.SessionAttribute;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.dev.framework.core.util.Constants.SESSION_ID;

@FileGateway
public interface FileService {
	// 上传文件，文件参数InputStream放在最后
	// 如果需要使用session，则必须定义@SessionAttribute(SESSION_ID_SESSION_ATTRIBUTE_KEY)
	// String sessionid变量
	public String uploadFile(String destPath,
                             @SessionAttribute(SESSION_ID) String sessionid, InputStream in);

	// 下载文件
	// 如果需要使用session，则必须定义@SessionAttribute(SESSION_ID_SESSION_ATTRIBUTE_KEY)
	// String sessionid变量
	public InputStream downloadFile(String fileUri,
                                    @SessionAttribute(SESSION_ID) String sessionid)
			throws FileNotFoundException;
}
