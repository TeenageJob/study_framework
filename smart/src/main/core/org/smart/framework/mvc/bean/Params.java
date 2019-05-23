package org.smart.framework.mvc.bean;

import java.util.Map;
import org.smart.framework.core.bean.BaseBean;
import org.smart.framework.util.CastUtil;
import org.smart.framework.util.MapUtil;

/**
 * 封装请求参数
 *
 * @author TY
 * @Time 2017年9月20日 下午9:39:06
 * @since 1.0.0
 */
public class Params extends BaseBean {

	/**
	 * create by ty on TY 2017年11月10日 下午2:15:54
	 */
	private static final long serialVersionUID = 9080653310317689837L;
	private final Map<String, Object> fieldMap;

	public Params(Map<String, Object> fieldMap) {
		this.fieldMap = fieldMap;
	}

	public Map<String, Object> getFieldMap() {
		return fieldMap;
	}

	public String getString(String name) {
		return CastUtil.castString(get(name));
	}

	public double getDouble(String name) {
		return CastUtil.castDouble(get(name));
	}

	public long getLong(String name) {
		return CastUtil.castLong(get(name));
	}

	public int getInt(String name) {
		return CastUtil.castInt(get(name));
	}

	public Object get(String name) {
		return MapUtil.getObj(fieldMap, name);
	}

	public void put(String key,Object value){
		this.fieldMap.put(key,value);
	}
}
