package org.mvc.ty.mybatis.common;

import org.mvc.ty.common.vo.UserInformationVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Common {

	/**
	 * 获取全部用户信息
	 *
	 * <br>
	 * create by on TY <br>
	 * 2018年1月7日 下午7:17:44
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryAll();

	/**
	 * 添加用户
	 *
	 * <br>
	 * create by on TY <br>
	 * 2018年1月7日 下午7:17:52
	 * 
	 * @param paramMap
	 * @return
	 */
	int insertUser(Map<String, Object> paramMap);

	/**
	 * 获取用户信息
	 *
	 * <br>
	 * create by on TY <br>
	 * 2018年1月7日 下午7:18:51
	 * 
	 * @param paramMpa
	 * @return
	 */
	UserInformationVO getUserInfo(Map<String, String> paramMap);

	/**
	 * 添加菜单节点
	 * @param paramMap
	 * @return
	 */
	int addMenuNode(Map<String,Object> paramMap);

	/**
	 * 添加标题节点
	 * @param paramMap
	 * @return
	 */
	int addTitleNode(Map<String,Object> paramMap);

	/**
	 * 添加页面节点
	 * @param paramMap
	 * @return
	 */
	int addUrlNode(Map<String,Object> paramMap);

	/**
	 * 添加权限资源
	 * @param paramMap
	 * @return
	 */
	int addPermission(Map<String,Object> paramMap);

	/**
	 * 获取全部用户信息
	 * 账户 名称
	 */
	List<?> getAllUserInfo();

	/**
	 * 获取用户权限页面
	 */
	List getRolePermissionPage();

	/**
	 * 获取角色的所有权限
	 * @return
	 */
	Set getRolePermission(Map<String,Object> paramMap);

	/**
	 * 删除菜单
	 * @param paramMap
	 * @return
	 */
	int delMenu(Map<String,String> paramMap);

	/**
	 * 删除标题
	 * @param paramMap
	 * @return
	 */
	int delTitle(Map<String,String> paramMap);

	/**
	 * 删除
	 * @param paramMap
	 * @return
	 */
	int delUrl(Map<String,String> paramMap);

	/**
	 * 编辑节点
	 * @param paramMap
	 * @return
	 */
	int edtNodeMenu(Map<String,Object> paramMap);
	int edtNodeTitle(Map<String,Object> paramMap);
	int edtNodeUrl(Map<String,Object> paramMap);

	/**
	 * 添加角色权限
	 * @param paramMap
	 * @return
	 */
	int addRolePermission(Map<String,Object> paramMap);

	/**
	 * 删除角色权限
	 * @param paramMap
	 * @return
	 */
	int delRolePermission(Map<String,Object> paramMap);

	/**
	 * 添加用户信息
	 * @param paramMap
	 * @return
	 */
	int addUserInfo(Map<String,Object> paramMap);
}
