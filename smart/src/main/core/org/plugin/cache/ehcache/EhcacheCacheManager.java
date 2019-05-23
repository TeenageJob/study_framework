package org.plugin.cache.ehcache;

import org.apache.commons.lang.StringUtils;
import org.plugin.cache.smart.Cache;
import org.plugin.cache.smart.SmartCacheManager;
import org.plugin.cache.CacheException;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

public class EhcacheCacheManager implements SmartCacheManager {

	private final CacheManager cacheManager;

	//初始化加载classpath路径下的ehcache.xml
	public EhcacheCacheManager() {
		cacheManager = CacheManager.newInstance("classpath:ehcache.xml");
	}

	@Override
	public final <K, V> Cache<K, V> getCache(String name) throws CacheException {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("参数 name 非法！");
		}
		try {
			Ehcache cache = cacheManager.getEhcache(name);
			if (cache == null) {
				cacheManager.addCache(name);
				cache = cacheManager.getCache(name);
			}
			return new EhcacheCache<K, V>(cache);
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@Override
	public void destroy() {
		cacheManager.clearAll();
	}
}