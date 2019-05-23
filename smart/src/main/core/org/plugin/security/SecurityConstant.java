package org.plugin.security;

/**
 * 常量接口
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:41:37
 * @since 1.0.0
 */
public interface SecurityConstant {
	/** 域，Shiro 从 Realm 获取安全数据 */
	String REALMS = "smart.plugin.security.realms";
	/**
	 * security.realms 包括三种：jdbc、ad、custom
	 */
	String REALMS_JDBC = "jdbc";
	String REALMS_AD = "ad";
	String REALMS_CUSTOM = "custom";

	/** 查询配置地址 */
	String SMART_SECURITY = "smart.plugin.security.custom";
	/** 拦截url注册 */
	String INTERCEPTURL = "smart.plugin.security.intercepturl";

	/** 获取用户 根据用户名获取密码 */
	String JDBC_AUTHC_QUERY = "smart.plugin.security.jdbc.authc_query";
	/** 获取角色 根据用户名获取角色名集合 */
	String JDBC_ROLES_QUERY = "smart.plugin.security.jdbc.roles_query";
	/** 获取权限 根据角色名获取权限名集合 */
	String JDBC_PERMISSIONS_QUERY = "smart.plugin.security.jdbc.permissions_query";

	/** 管理员 */
	String AD_URL = "smart.plugin.security.ad.url";
	/** 管理员账户 */
	String AD_SYSTEM_USERNAME = "smart.plugin.security.ad.system_username";
	/** 管理员密码 */
	String AD_SYSTEM_PASSWORD = "smart.plugin.security.ad.system_password";
	String AD_SEARCH_BASE = "smart.plugin.security.ad.search_base";
	/** shiro缓存 */
	String CACHEABLE = "smart.plugin.security.cacheable";

	/**
	 * 当前在线会话
	 */
	String ONLINE_SESSION = "online_session";

	/**
	 * 仅清空本地缓存 不清空数据库的
	 */
	String ONLY_CLEAR_CACHE = "online_session_only_clear_cache";

	/**
	 * 设置WebEnvironment 接口的实现类
	 */
	String SHIRO_ENVIRONMENTCLASS = "shiroEnvironmentClass";
	String SHIRO_ENVIRONMENTCLASS_IMPL = "org.plugin.security.environment.SmartIniWebEnvironment";
	/**
	 * 设置shiro配置文件路径
	 */
	String SHIRO_CONFIG_LOCATIONS = "shiroConfigLocations";
	String SHIRO_CONFIG_LOCATION_PATH = "/WEB-INF/shiro.ini";

	/**
	 * 强制退出后的url
	 */
	String FORCELOGOUTURL = "/common/index.do";

	/**
	 * 登录路径
	 */
	String LOGINURL = "/common/login.do";

	/**
	 * 没有权限路径
	 */
	String UNAUTHORIZED = "/common/unauthorized.do";

	/**
	 * shiro.xml路径
	 */
	String SHIRO_XML = "src/main/webapp/WEB-INF/shiro.xml";

	/**
	 * shiro中用户信息
	 */
	String USERNAME_KEY = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY";
	
	/**
	 * 登录url
	 */
	String CASLOGINURL = "https://server:8443/cas/login?service=http://client/smart/common/login.do";

	/**
	 * 登录成功url
	 */
	String SECCESSURL = "http://client/smart/common/index.do";

	/**
	 * 登出URL
	 */
	String LOUGUOT="https://server:8443/cas/logout?service=http://client/smart/common/index.do";	
}
