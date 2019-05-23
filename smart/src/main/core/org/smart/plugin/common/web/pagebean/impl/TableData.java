package org.smart.plugin.common.web.pagebean.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart.plugin.common.web.pagebean.IPage;
import org.smart.plugin.common.web.pagebean.ITableData;

import com.alibaba.fastjson.annotation.JSONField;

public class TableData implements ITableData {
	private Map<String, IPage<?>> tableDatas = new HashMap<>();

	public Map<String, IPage<?>> getTablesPageData() {
		return this.tableDatas;
	}

	public IPage<?> getTablePageData(String id) {
		return null;
	}

	@JSONField(deserialize = true)
	public List<?> getTableListData(String id) {
		IPage<?> iPage = (IPage<?>) this.tableDatas.get(id);
		return iPage == null ? null : iPage.getList();
	}

	public void setTablePage(String id, IPage<?> page) {
		this.tableDatas.put(id, page);
	}

	public void removeTableData(String id) {
		this.tableDatas.remove(id);
	}

	public void setTableList(String id, List list) {
		Page<?> page = new Page<>();
		page.setList(list);
		this.tableDatas.put(id, page);
	}

	public void setPage(String id, IPage<?> page) {
		this.tableDatas.put(id, page);
	}
}
