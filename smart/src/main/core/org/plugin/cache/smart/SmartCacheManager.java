package org.plugin.cache.smart;

import org.plugin.cache.CacheException;

public interface SmartCacheManager {

	/**
	 * 根据名称获取 Cache 对象
	 *
	 * @param name
	 *            Cache 名称
	 * @return Cache 对象
	 * @throws CacheException
	 */
	<K, V> Cache<K, V> getCache(String name) throws CacheException;

	/**
	 * 销毁缓存
	 *
	 * <br>
	 * create by on TY <br>
	 * 2018年1月7日 下午9:46:02
	 */
	void destroy();
}