package org.plugin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.core.ConfigHelper;

/**
 * 从配置文件中获取相关属性
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:41:20
 * @since 1.0.0
 */
public final class SecurityConfig {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

	private static SmartSecurity smartSecurity;

	/**
	 * 获取security类
	 *
	 * <br>
	 * create by on TY 2017年11月10日 下午8:21:50
	 * 
	 * @return String
	 */
	public static String getRealms() {
		return ConfigHelper.getString(SecurityConstant.REALMS);
	}

	public static SmartSecurity getSmartSecurity() {
		if(smartSecurity==null) {
			// 获取custom类
			String className = ConfigHelper.getString(SecurityConstant.SMART_SECURITY);
			Class<?> cls = null;
			try {
				cls = Class.forName(className);
			} catch (ClassNotFoundException e) {
				logger.error("无法从 " + SecurityConstant.SMART_SECURITY + " 配置中找到对应的类", e);
			}
			if (cls != null) {
				try {
					smartSecurity = (SmartSecurity) cls.newInstance();
				} catch (Exception e) {
					logger.error(SmartSecurity.class.getSimpleName() + " 实例化异常", e);
				}
			}
		}
		return smartSecurity;
	}

	public static IInterceptUrl getInterceptUrl() {
		// 获取custom类
		String className = ConfigHelper.getString(SecurityConstant.INTERCEPTURL);
		Class<?> cls = null;
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.error("无法从 " + SecurityConstant.INTERCEPTURL + " 配置中找到对应的类", e);
		}
		IInterceptUrl interceptUrl = null;
		if (cls != null) {
			try {
				interceptUrl = (IInterceptUrl) cls.newInstance();
			} catch (Exception e) {
				logger.error(SmartSecurity.class.getSimpleName() + " 实例化异常", e);
			}
		}
		return interceptUrl;
	}

	/**
	 * 获取用户
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:39:43
	 * 
	 * @return String
	 */
	public static String getJdbcAuthcQuery() {
		return ConfigHelper.getString(SecurityConstant.JDBC_AUTHC_QUERY);
	}

	/**
	 * 获取角色
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:40:35
	 * 
	 * @return
	 */
	public static String getJdbcRolesQuery() {
		return ConfigHelper.getString(SecurityConstant.JDBC_ROLES_QUERY);
	}

	/**
	 * 获取权限
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:40:50
	 * 
	 * @return
	 */
	public static String getJdbcPermissionsQuery() {
		return ConfigHelper.getString(SecurityConstant.JDBC_PERMISSIONS_QUERY);
	}

	/**
	 * 获取url
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:41:02
	 * 
	 * @return
	 */
	public static String getAdUrl() {
		return ConfigHelper.getString(SecurityConstant.AD_URL);
	}

	public static String getAdSystemUsername() {
		return ConfigHelper.getString(SecurityConstant.AD_SYSTEM_USERNAME);
	}

	public static String getAdSystemPassword() {
		return ConfigHelper.getString(SecurityConstant.AD_SYSTEM_PASSWORD);
	}

	public static String getAdSearchBase() {
		return ConfigHelper.getString(SecurityConstant.AD_SEARCH_BASE);
	}

	public static boolean isCacheable() {
		return ConfigHelper.getBoolean(SecurityConstant.CACHEABLE);
	}
}
