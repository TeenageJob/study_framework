package org.plugin.security;

import java.util.Map;

public interface IInterceptUrl {
	/**
	 * 获取拦截url
	 *
	 * <br>create by on TY
	 * <br>2018年1月9日 下午3:13:47
	 * @return Map<String,String> map中key为url，value为资源权限
	 */
	Map<String, String> getInterceptURL();
}
