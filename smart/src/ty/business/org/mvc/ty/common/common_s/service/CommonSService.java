package org.mvc.ty.common.common_s.service;

import java.util.Map;

import org.mvc.ty.common.vo.MenusVO;

public interface CommonSService {

	/**
	 * 登录
	 *
	 * <br>create by on TY
	 * 2017年12月6日 上午9:05:14
	 * @param paramMap
	 * @return
	 */
	boolean login(Map<String,String> paramMap);
	
	/**
	 * 获取用户登录信息
	 *
	 * <br>create by on TY
	 * <br>2018年1月7日 下午7:16:40
	 * @param paramMap
	 * @return
	 */
	MenusVO getLoginInfo();
	/**
	 * 登出
	 *
	 * <br>create by on TY
	 * <br>2017年12月13日 下午4:15:00
	 * @return
	 */
	boolean loginOut();
	
	/**
	 * 用户注册
	 *
	 * <br>create by on TY
	 * <br>2017年12月13日 下午4:15:52
	 * @param paramMap
	 * @return
	 */
	boolean register(Map<String, Object> paramMap);


}
