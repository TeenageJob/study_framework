package org.mvc.ty.common.vo;

import org.smart.framework.core.bean.BaseBean;

public class RoleMenuVO extends BaseBean {

	private String role;//角色
	private String menu;//菜单
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
}
