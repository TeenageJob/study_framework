package org.smart.plugin.common.web.pagebean;

import java.io.Serializable;
import java.util.List;

public interface IPage<T> extends Serializable {
	Integer getStart();

	void setStart(Integer arg0);

	Integer getLimit();

	void setLimit(Integer arg0);

	List<T> getList();

	void setList(List<T> arg0);

	Integer getTotal();

	void setTotal(Integer arg0);

	String getGridId();

	void setGridId(String arg0);
}