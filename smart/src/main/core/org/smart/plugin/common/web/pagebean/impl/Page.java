package org.smart.plugin.common.web.pagebean.impl;

import java.util.List;

import org.smart.plugin.common.web.pagebean.IPage;

public class Page<T> implements IPage<T> {
	private static final long serialVersionUID = 4797865277662075470L;
	protected String gridId;
	protected Integer start;
	protected Integer limit;
	protected Integer total;
	protected List<T> list;

	public Page() {
	}

	public Page(List<T> list) {
		this.list = list;
	}

	public Integer getStart() {
		return this.start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public List<T> getList() {
		return this.list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getGridId() {
		return this.gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}
}