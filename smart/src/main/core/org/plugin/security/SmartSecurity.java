package org.plugin.security;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * * Smart Security 接口 <br/>
 * 可在应用中实现该接口，或者在 smart.properties 文件中提供以下基于 SQL 的配置项：
 * <ul>
 * <li>smart.security.jdbc.authc_query：根据用户名获取密码</li>
 * <li>smart.security.jdbc.roles_query：根据用户名获取角色名集合</li>
 * <li>smart.security.jdbc.permissions_query：根据角色名获取权限名集合</li>
 * </ul>
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:42:18
 * @since 1.0.0
 */
public interface SmartSecurity {

	/**
	 * 根据用户名获取密码
	 *
	 * @param username
	 *            用户名
	 * @return 密码
	 */
	String getPassword(String username);

	/**
	 * 根据用户名获取角色名集合
	 *
	 * @param username
	 *            用户名
	 * @return 角色名集合
	 */
	Set<String> getRoleNameSet(String username);

	/**
	 * 根据角色名获取权限名集合
	 *
	 * @param roleName
	 *            角色名
	 * @return 权限名集合
	 */
	Set<String> getPermissionNameSet(String roleName);

	/**
	 * 锁住指定用户
	 *
	 * <br>
	 * create by on TY <br>
	 * 2017年12月15日 上午10:42:37
	 * 
	 * @param username
	 * @return 更新条目数
	 */
	int lockUser(String username);

	/**
	 * 创建角色
	 * @param paramMap
	 * @return
	 */
	Serializable createRole(Map paramMap);

	/**
	 * 删除角色
	 * @param roleId
	 */
	void deleteRole(Long roleId);

	/**
	 * 添加用户角色关系
	 * @param paramMap
	 */
	void addUserRole(Map paramMap);

	/**
	 * 删除用户角色关系
	 * @param paramMap
	 */
	void delUserRole(Map paramMap);
}
