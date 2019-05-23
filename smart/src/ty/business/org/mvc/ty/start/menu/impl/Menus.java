package org.mvc.ty.start.menu.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvc.ty.common.vo.BusinessTitleVO;
import org.mvc.ty.common.vo.BusinessUrlVO;
import org.mvc.ty.common.vo.MenuVO;
import org.mvc.ty.common.vo.RoleMenuVO;
import org.mvc.ty.start.menu.IMenu;
import org.smart.framework.dao.DatabaseHelper;

public class Menus implements IMenu {

	/**
	 * 获取角色菜单信息
	 *
	 * <br>
	 * create by on TY <br>
	 * 2018年1月9日 下午1:08:52
	 * 
	 * @return
	 */
	public List<RoleMenuVO> getRoleMenu() {
		return DatabaseHelper.queryEntityList(RoleMenuVO.class, "select role,menu from role_menu");
	}

	private List<MenuVO> getMenuInfo() {
		return DatabaseHelper.queryEntityList(MenuVO.class,
				"select label_name,tab_id,span_class,span_style,warp_id from menu");
	}

	private List<BusinessTitleVO> getTitleInfo() {
		return DatabaseHelper.queryEntityList(BusinessTitleVO.class,
				"select label_name,title_name,id_flag,collapse,span_style,span_class from business_title");
	}

	private List<BusinessUrlVO> getUrlInfo() {
		return DatabaseHelper.queryEntityList(BusinessUrlVO.class,
				"select label_name,title_name,url,url_name,permission from business_url");
	}

	public Map<String, MenuVO> getInfo() {
		return saveMenuInfo();
	}

	public Map<String, MenuVO> saveMenuInfo() {
		List<MenuVO> menuCache = getMenuInfo();
		List<BusinessTitleVO> titleCache = getTitleInfo();
		List<BusinessUrlVO> urlCache = getUrlInfo();
		Map<String, MenuVO> menu = new HashMap<>();
		// 将全部标题存入对应的menuVO
		for (MenuVO me : menuCache) {
			for (BusinessTitleVO title : titleCache) {
				if (title.getLabel_name().equals(me.getLabel_name())) {
					me.getBusiness().put(title.getTitle_name(), title);
				}
			}
			menu.put(me.getLabel_name(), me);
		}
		// 将全部url存入对应的BusinessTitleVO
		for (BusinessUrlVO url : urlCache) {
			for (BusinessTitleVO title : titleCache) {
				if (url.getTitle_name().equals(title.getTitle_name())&&url.getLabel_name().equals(title.getLabel_name())) {
					title.getBusiness_url().add(url);
				}
			}
		}
		return menu;
	}

}
