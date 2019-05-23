package org.smart.plugin.common.web.pagebean.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.web.pagebean.ISelectData;

public class SelectData implements ISelectData {

	private Map<String, List<?>> map = new HashMap<>();

	@Override
	public Map<String, List<?>> getSelectData() {
		return this.map;
	}

	@Override
	public List<?> getSelectDataById(String id) {
		if ("" == MapUtil.getObj(map, id))
			return null;
		return (List<?>) MapUtil.getObj(map, id);
	}

	@Override
	public void setSelectDataById(String id, List<?> list) {
		this.map.put(id, list);
	}

	@Override
	public void removeSelectDataById(String id) {
		this.map.remove(id);
	}

}
