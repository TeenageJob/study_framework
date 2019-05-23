package org.smart.plugin.common.web.pagebean;

import java.util.List;
import java.util.Map;

public interface ITableData {
	Map<String, IPage<?>> getTablesPageData();

	IPage<?> getTablePageData(String id);

	List<?> getTableListData(String id);

	void setTableList(String id, List<?> list);

	void setPage(String id, IPage<?> list);

	void setTablePage(String id, IPage<?> page);

	void removeTableData(String id);
}
