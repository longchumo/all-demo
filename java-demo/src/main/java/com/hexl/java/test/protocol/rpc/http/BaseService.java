package com.hexl.java.test.protocol.rpc.http;

import java.util.Map;

public interface BaseService {

	public Object execute(Map<String,Object> args);
}
