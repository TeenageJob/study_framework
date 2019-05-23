package org.mvc.ty.start.menu;

import java.util.List;
import java.util.Map;

import org.mvc.ty.common.vo.MenuVO;
import org.mvc.ty.common.vo.RoleMenuVO;

public interface IMenu {

	/**
	 * 获取菜单信息
	 *
	 * <br>create by on TY
	 * <br>2018年1月9日 下午1:09:40
	 * @return
	 */
	Map<String, MenuVO> getInfo();
	/**
	 * 获取角色-菜单信息
	 *
	 * <br>create by on TY
	 * <br>2018年1月9日 下午1:09:50
	 * @return
	 */
	List<RoleMenuVO> getRoleMenu();
	
}
