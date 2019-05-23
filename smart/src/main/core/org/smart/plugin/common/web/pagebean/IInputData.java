package org.smart.plugin.common.web.pagebean;

import java.util.Map;

public interface IInputData {
	
	Map<String, Object> getInputsData();

	void setData(String id, Object value);

	void removeData(String id);

	Object getData(String id);
}
