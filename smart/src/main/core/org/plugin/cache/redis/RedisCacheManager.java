package org.plugin.cache.redis;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang.StringUtils;
import org.plugin.cache.smart.Cache;
import org.plugin.cache.CacheException;
import org.plugin.cache.smart.SmartCacheManager;

import redis.clients.jedis.Jedis;

public class RedisCacheManager implements SmartCacheManager {

	@SuppressWarnings("rawtypes")
	private final ConcurrentMap<String, Cache> cacheMap;

	@SuppressWarnings("rawtypes")
	public RedisCacheManager() {
		this.cacheMap = new ConcurrentHashMap<String, Cache>();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("参数 name 非法！");
		}
		try {
			Cache<K, V> cache = cacheMap.get(name);
			if (cache == null) {
				String host = SmartProps.getHost();
				int port = SmartProps.getPort();
				Jedis jedis = new Jedis(host, port);
				//jedis.auth(SmartProps.getPassword());
				cache = new RedisCache<K, V>(jedis);
				cacheMap.putIfAbsent(name, cache);
			}
			return cache;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}
	
	@Override
	public void destroy() {
		cacheMap.clear();
	}
}
