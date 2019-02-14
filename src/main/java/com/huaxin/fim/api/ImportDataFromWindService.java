package com.huaxin.fim.api;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;

@Gateway
public interface ImportDataFromWindService {

    /** 执行 */
    public void execute(String scheduleName) throws ServiceException;
}
