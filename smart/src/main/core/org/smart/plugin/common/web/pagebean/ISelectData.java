package org.smart.plugin.common.web.pagebean;

import java.util.List;
import java.util.Map;

public interface ISelectData {
	
	Map<String,List<?>> getSelectData();
	
	List<?> getSelectDataById(String id);
	
	void setSelectDataById(String id,List<?> list);
	
	void removeSelectDataById(String id);
}
