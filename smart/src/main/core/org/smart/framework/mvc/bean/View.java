package org.smart.framework.mvc.bean;

import java.util.HashMap;
import java.util.Map;
import org.smart.framework.core.bean.BaseBean;
import org.smart.framework.util.ConstantUtil;
import org.smart.framework.util.ValidataUtil;

/**
 * 封装视图对象
 *
 * @author TY
 * @Time 2017年9月20日 下午9:39:27
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class View extends BaseBean {

	private String path; // 视图路径
	private Map<String, Object> data; // 相关数据
	private boolean redirect = false; // 重定向标志

	public View(String path) {
		if(path.contains(ConstantUtil.REDIRECT)){
			redirect=true;
		}
		if (!path.contains(".jsp")) {
			this.path = path + ConstantUtil.POINT + ConstantUtil.PAGE_POSTFIX_JSP;
		}
		data = new HashMap<String, Object>();
	}

	public View(String path, String postfix) {
		if (!ValidataUtil.isPagePostfix(postfix)) {
			throw new RuntimeException("未知的页面，无法识别：请检查页面后缀是否正确");
		}
		this.path = path + ConstantUtil.POINT + postfix;
		data = new HashMap<String, Object>();
	}

	public View put(String key, Object value) {
		data.put(key, value);
		return this;
	}

	public boolean isRedirect() {
		return path.startsWith(ConstantUtil.SPRIT_S) || redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
