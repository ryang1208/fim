package com.huaxin.fim.api.standard.rpc;

import com.dev.framework.core.annotation.Gateway;

import javax.validation.constraints.NotNull;

@Gateway
public interface TestRpcService {
	public int add(int a, int b);
	public String getMsg(@NotNull String name);
}
