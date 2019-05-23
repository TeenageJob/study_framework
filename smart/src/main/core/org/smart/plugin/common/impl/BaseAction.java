package org.smart.plugin.common.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.smart.framework.mvc.DataContext;
import org.smart.framework.util.ConstantUtil;
import org.smart.framework.util.StringUtil;
import org.smart.plugin.common.ActivitiBPMN;
import org.smart.plugin.common.IBaseAction;
import org.smart.plugin.common.web.pagebean.IPage;
import org.smart.plugin.common.web.pagebean.IPageBean;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

public class BaseAction extends ActivitiBPMN implements IBaseAction {

	@Override
	public IPageBean setData(String id, Object value) {
		IPageBean pageBean = getPageBean();
		pageBean.setData(id, value);
		return pageBean;
	}

	@Override
	public IPageBean setData(Map<String, Object> map, boolean clear) {
		IPageBean pageBean = getPageBean();
		Iterator<String> iterator = map.keySet().iterator();

		while (true) {
			String key;
			do {
				if (!iterator.hasNext()) {
					return pageBean;
				}

				key = (String) iterator.next();
			} while (!clear && pageBean.getData(key) != null);

			pageBean.setData(key, map.get(key));
		}
	}

	@Override
	public IPageBean setList(String id, List<?> list) {
		IPageBean pageBean = getPageBean();
		pageBean.setTableList(id, list);
		return pageBean;
	}

	@Override
	public IPageBean setList(String id, IPage<?> value) {
		return null;
	}

	@Override
	public IPageBean setMessage(String message) {
		IPageBean pageBean = getPageBean();
		pageBean.setMessage(message);
		return pageBean;
	}

	@Override
	public IPageBean setMessage(String message, String messageType) {
		IPageBean pageBean = getPageBean();
		pageBean.setMessage(message);
		pageBean.setMessageType(messageType);
		return pageBean;
	}

	@Override
	public IPageBean setReadOnly(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setReadOnly(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean setDisabled(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setDisabled(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean setEnable(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setEnable(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean setTabActive(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPageBean setHide(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setHide(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean setChecked(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setChecked(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean setInvisible(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPageBean setShow(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setShow(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean resetForm(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPageBean setFocus(String id) {
		IPageBean pageBean=getPageBean();
		pageBean.setFocus(id);
		return pageBean;
	}

	@Override
	public IPageBean setRequired(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setRequed(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean setDisRequired(String ids) {
		IPageBean pageBean = getPageBean();
		if (StringUtil.isNotEmpty(ids)) {
			String[] idArray = ids.split(ConstantUtil.COMMA_S);
			for (String id : idArray) {
				pageBean.setDisRequed(id);
			}
		}
		return pageBean;
	}

	@Override
	public IPageBean getPageBean() {
		return (IPageBean) DataContext.getRequest().getAttribute("_DATA_BEAN");
	}

	@Override
	public void setSuccess(boolean success) {
		getPageBean().setSuccess(success);
	}

	@Override
	public IPageBean setSelectInputList(String id, List<?> list) {
		IPageBean pageBean=getPageBean();
		pageBean.setSelectDataById(id, list);
		return pageBean;
	}

	@Override
	public IPageBean setTreeData(String id, TreeVO treeVO) {
		IPageBean pageBean=getPageBean();
		pageBean.setTreeData(id,treeVO);
		return pageBean;
	}


}
