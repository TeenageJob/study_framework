package org.mvc.ty.common.vo;

import org.smart.framework.core.bean.BaseBean;

public class BusinessUrlVO extends BaseBean {
	private String label_name;// 菜单名
	private String title_name;// 标题名
	private String url;// url地址
	private String url_name;// 业务功能名称
	private String permission;// 权限

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl_name() {
		return url_name;
	}

	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}

	public String getLabel_name() {
		return label_name;
	}

	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
