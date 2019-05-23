package org.mvc.ty.common.vo;

import java.util.HashMap;
import java.util.Map;

import org.smart.framework.core.bean.BaseBean;

/**
 * 菜单VO <br>
 * 用于存储用户所拥有的菜单
 * 
 * @author TY
 * @Time 2018年1月7日 下午3:35:59
 * @since 1.0.0
 */
public class MenusVO extends BaseBean{

	// 经办人信息
	UserInformationVO userInformationVO;
	Map<String,MenuVO> menu = new HashMap<>();// 菜单项
	
	public UserInformationVO getUserInformationVO() {
		return userInformationVO;
	}

	public void setUserInformationVO(UserInformationVO userInformationVO) {
		this.userInformationVO = userInformationVO;
	}

	public Map<String, MenuVO> getMenu() {
		return menu;
	}

	public void setMenu(Map<String, MenuVO> menu) {
		this.menu = menu;
	}


}
