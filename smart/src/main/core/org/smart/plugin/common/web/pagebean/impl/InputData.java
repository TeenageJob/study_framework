package org.smart.plugin.common.web.pagebean.impl;

import java.util.HashMap;
import java.util.Map;

import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.web.pagebean.IInputData;

public class InputData implements IInputData {
	//储存数据集合
	private HashMap<String, Object> inputs = new HashMap<>();

	public Map<String, Object> getInputsData() {
		return this.inputs;
	}

	public void setData(String id, Object value) {
		this.inputs.put(id, value);
	}

	public void removeData(String id) {
		this.inputs.remove(id);
	}

	public Object getData(String id) {
		return MapUtil.getObj(inputs, id);
	}
}
