package org.smart.framework.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;

/**
 * 映射操作工具类
 *
 * @author TY
 * @Time 2017年9月20日 下午9:44:54
 * @since 1.0.0
 */
public class MapUtil {

	/**
	 * 判断 Map 是否非空
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return MapUtils.isNotEmpty(map);
	}

	/**
	 * 判断 Map 是否为空
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}

	/**
	 * 转置 Map
	 */
	public static <K, V> Map<V, K> invert(Map<K, V> source) {
		Map<V, K> target = null;
		if (isNotEmpty(source)) {
			target = new LinkedHashMap<V, K>(source.size());
			for (Map.Entry<K, V> entry : source.entrySet()) {
				target.put(entry.getValue(), entry.getKey());
			}
		}
		return target;
	}

	/**
	 * Map中是否包含某个键
	 *
	 * <br>
	 * create by on TY <br>
	 * 2017年12月8日 上午11:04:24
	 * 
	 * @param map
	 * @param key
	 * @return boolean
	 */
	public static boolean isContainKey(Map<?, ?> map, Object key) {
		if (isNotEmpty(map)) {
			return map.get(key)==null?false:true;
		}
		return false;
	}

	/**
	 * 替换Map中指定键的值 <br>
	 * 如果值为null或键存在则返回false <br>
	 * create by on TY <br>
	 * 2017年12月8日 上午10:20:48
	 * 
	 * @param Map
	 *            需要判断的Map
	 * @param key
	 *            需要替换的值的键
	 * @param value
	 *            需要替换的值
	 * @return boolean 是否成功
	 */
	public static boolean isCanPut(Map<?, ?> map, Object key, Object value) {
		if (key != null || value != null || isContainKey(map, key)) {
			return false;
		}
		return true;
	}

	/**
	 * 获取map中在值 <br>
	 * 方法已经解决了可能键不存在的问题 <br>
	 * 如果存在则返回该值，如果不存在则返回 "" <br>
	 * create by on TY <br>
	 * 2017年12月11日 上午11:15:19
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static Object getObj(Map<?, ?> map, String key) {
		if (isContainKey(map, key)) {
			return map.get(key);
		} else {
			return "";
		}
	}

	/**
	 * 查找Map中是否包含指定值
	 * 
	 * <br>
	 * create by on TY <br>
	 * 2017年12月11日 下午4:51:18
	 * 
	 * @param map 
	 * @param value
	 * @return
	 */
	public static boolean isContainValue(Map<?, ?> map, Object value) {
		if (isNotEmpty(map)) {
			for (Object key : map.keySet()) {
				Object obj = map.get(key);
				if (obj instanceof List) {
					return ((List<?>) obj).contains(value);
				} else if (obj instanceof Set) {
					return ((Set<?>) obj).contains(value);
				} else if (obj instanceof Map) {
					return isContainValue(((Map<?, ?>) obj), value);
				} else {
					return ObjectsUtil.isEquals(obj, value);
				}

			}
		}
		return false;
	}
	/**
	 * 查找Map指定键中是否包含指定值
	 *
	 * <br>create by on TY
	 * <br>2017年12月11日 下午5:16:53
	 * @param map
	 * @param id
	 * @param value
	 * @return boolean
	 */
	public static boolean isContainValue(Map<?, ?> map,Object id, Object value) {
		if (isNotEmpty(map)) {
			if(isContainKey(map, id)) {
				Object obj = map.get(id);
				if (obj instanceof List) {
					return ((List<?>) obj).contains(value);
				} else if (obj instanceof Set) {
					return ((Set<?>) obj).contains(value);
				} else if (obj instanceof Map) {
					return isContainValue(((Map<?, ?>) obj), value);
				} else {
					return ObjectsUtil.isEquals(obj, value);
				}

			}
		}
		return false;
	}

}
