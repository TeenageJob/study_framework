package org.mvc.ty.common.common_s.service;

import java.util.Map;

import org.mvc.ty.common.vo.MenusVO;

public interface CommonFQService {
	
	
	/**
	 * 登录
	 *
	 * <br>create by on TY
	 * 2017年11月21日 下午3:16:51
	 * @param params
	 */
	boolean login(Map<String,String> paramMap);
	
	/**
	 * 获取登录信息
	 *
	 * <br>create by on TY
	 * <br>2018年1月7日 下午7:15:17
	 * @param paramMap
	 * @return
	 */
	MenusVO getLoginInfo();
	
	/**
	 * 登出
	 *
	 * <br>create by on TY
	 * <br>2017年12月13日 下午4:14:07
	 * @return
	 */
	boolean loginOut();

}
