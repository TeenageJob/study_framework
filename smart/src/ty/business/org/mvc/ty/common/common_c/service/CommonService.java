package org.mvc.ty.common.common_c.service;

import java.util.Map;

import org.mvc.ty.common.vo.MenusVO;
import org.smart.framework.mvc.bean.Params;

public interface CommonService {

	/**
	 * 登录
	 *
	 * <br>
	 * create by on TY 2017年11月21日 下午3:16:51
	 * 
	 * @param params
	 */
	void login(Params params);
	
	/**
	 * 获取登录信息
	 *
	 * <br>create by on TY
	 * <br>2018年1月7日 下午6:39:08
	 * @param params 登录用户名
	 * @return menusVO
	 */
	MenusVO getLoginInfo();

	/**
	 * 登出
	 *
	 * <br>
	 * create by on TY <br>
	 * 2017年12月13日 下午4:13:17
	 */
	void loginOut();

	/**
	 * 注册
	 *
	 * <br>
	 * create by on TY 2017年11月21日 下午3:17:36
	 * 
	 * @param params
	 */
	boolean register(Params params) throws Exception;

}
