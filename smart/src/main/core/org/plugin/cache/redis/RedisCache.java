package org.plugin.cache.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.plugin.cache.smart.Cache;
import org.plugin.cache.CacheException;
import org.smart.framework.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class RedisCache<K, V> implements Cache<K, V> {

    private Jedis jedis;

    public RedisCache(Jedis jedis) {
        if (jedis == null) {
            throw new IllegalArgumentException("参数 jedis 非法！");
        }
        this.jedis = jedis;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) throws CacheException {
        try {
            if (key == null) {
                return null;
            } else {
                return (V) SerializeUtil.unserialize(jedis.get(key.toString().getBytes()));
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) throws CacheException {
        if(value==null){
            throw new CacheException("value sent to redis cannot be null");
        }
        try {
            return (V)jedis.set(key.toString().getBytes(), SerializeUtil.serialize(value));
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(K key) throws CacheException {
        try {
            return (V) jedis.del(key.toString());
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public void clear() throws CacheException {
        try {
            jedis.flushAll();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public long size() {
        try {
            return jedis.dbSize();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<K> keys() {
        try {
            Set<K> keys = (Set<K>) jedis.keys("*");
            if (CollectionUtils.isNotEmpty(keys)) {
                return Collections.unmodifiableSet(new LinkedHashSet<K>(keys));
            } else {
                return Collections.emptySet();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public Collection<V> values() {
        try {
            Set<K> keys = keys();
            if (CollectionUtils.isNotEmpty(keys)) {
                List<V> values = new ArrayList<V>(keys.size());
                for (K key : keys) {
                    V value = get(key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }
}
