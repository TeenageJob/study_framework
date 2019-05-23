package org.plugin.security.init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.activedirectory.ActiveDirectoryRealm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.plugin.cache.redis.RedisCacheManager;
import org.plugin.security.SecurityConfig;
import org.plugin.security.SecurityConstant;
import org.plugin.security.SmartSecurity;
import org.plugin.security.realm.SmartCasRealm;
import org.plugin.security.realm.SmartJdbcRealm;
import org.plugin.security.session.dao.SmartSessionDao;
import org.plugin.security.session.filter.SmartAccessControlFilter;
import org.plugin.security.session.listener.SmartSessionListener;
import org.plugin.security.session.online.SmartSessionFactory;
import org.plugin.security.session.scheduler.QuartzSessionValidationScheduler2;
import org.plugin.security.thread.SmartSecurityDataContext;

/**
 * 安全过滤器（扩展 ShiroFilter）
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:44:49
 * @since 1.0.0x
 */
public class SecurityFilter extends ShiroFilter {

	@Override
	protected ServletRequest wrapServletRequest(HttpServletRequest request) {
		SmartSecurityDataContext.init(request);
		return super.wrapServletRequest(request);
	}

	@Override
	public void init() throws Exception {
		super.init();
		// 获取安全管理器
		WebSecurityManager webSecurityManager = super.getSecurityManager();
		// 设置数据源
		setRealms(webSecurityManager);
		// 设置casSubjectFactory
		// 参考http://blog.csdn.net/ii_bat/article/details/53349394
		// setCas((DefaultWebSecurityManager) webSecurityManager);
		// 设置session
		setSession((DefaultWebSecurityManager) webSecurityManager);
		// 设置缓存
		setCache(webSecurityManager);

	}

	private void setCas(DefaultSecurityManager webSecurityManager) {
		CasSubjectFactory subjectFactory = new CasSubjectFactory();
		webSecurityManager.setSubjectFactory(subjectFactory);
	}

	private void setSession(DefaultWebSecurityManager securityManager) {
		// 默认websession管理器
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

		// 在无状态应用中禁用将Subject状态持久化到会话
		// sessionManager 创建会话 sessionIdCookie 的模板
		sessionManager.setSessionIdCookieEnabled(true);
		SimpleCookie sessionIdCookie = new SimpleCookie();
		sessionIdCookie.setHttpOnly(true);
		sessionIdCookie.setMaxAge(-1);//浏览器关闭
		sessionIdCookie.setName("sid");
		sessionManager.setSessionIdCookie(sessionIdCookie);

		// 创建rememberMe cookie
		SimpleCookie rememberMeCookie = new SimpleCookie();
		rememberMeCookie.setHttpOnly(true);
		rememberMeCookie.setMaxAge(2592000);// 3天
		// 创建remember Manager
		CookieRememberMeManager rememberMe = new CookieRememberMeManager();
		rememberMe.setCookie(rememberMeCookie);
		rememberMe.setCipherKey(org.apache.shiro.codec.Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		securityManager.setRememberMeManager(rememberMe);

		// 配置session监听
		Collection<SessionListener> listeners = new ArrayList<>();
		listeners.add(new SmartSessionListener());
		sessionManager.setSessionListeners(listeners);
		// 创建session DAO层
		SmartSessionDao sessionDao = new SmartSessionDao(new RedisCacheManager());
		sessionDao.setActiveSessionsCacheName("sessionCache");
		sessionDao.setSessionIdGenerator(new JavaUuidSessionIdGenerator());// 默认就是它
		sessionManager.setSessionDAO(sessionDao); // 设置session全局变量
		sessionManager.setGlobalSessionTimeout(1800000);// 设置全局session过期时间
		sessionManager.setSessionValidationSchedulerEnabled(true); // 设置会话验证调度器
		sessionManager.setSessionValidationInterval(100);// 检验时间间隔
 
		QuartzSessionValidationScheduler2 quartzSessionValidationScheduler = new QuartzSessionValidationScheduler2();
		quartzSessionValidationScheduler.setSessionManager(sessionManager);
		sessionManager.setSessionValidationScheduler(quartzSessionValidationScheduler);
		sessionManager.setDeleteInvalidSessions(true);// 过期删除会话
		// 在线会话工厂
		sessionManager.setSessionFactory(new SmartSessionFactory());

		securityManager.setSessionManager(sessionManager); // 拦截器
		new SmartAccessControlFilter(sessionDao);
	}

	private void setRealms(WebSecurityManager webSecurityManager) {
		// 获取数据源
		String securityRealms = SecurityConfig.getRealms();
		if (securityRealms != null) {
			String[] securityRealmArray = securityRealms.split(",");
			if (securityRealmArray.length > 0) {
				Set<Realm> realms = new LinkedHashSet<Realm>();
				for (String securityRealm : securityRealmArray) {
					if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)) {
						addJdbcRealm(realms);
					} else if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_AD)) {
						addAdRealm(realms);
					} else if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)) {
						addCustomRealm(realms);
					}
				}
				RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
				realmSecurityManager.setRealms(realms);
			}
		}
	}

	private void addJdbcRealm(Set<Realm> realms) {
		SmartJdbcRealm smartJdbcRealm = new SmartJdbcRealm();
		realms.add(smartJdbcRealm);
	}

	private void addAdRealm(Set<Realm> realms) {
		ActiveDirectoryRealm realm = new ActiveDirectoryRealm();
		realm.setUrl(SecurityConfig.getAdUrl());
		realm.setSystemUsername(SecurityConfig.getAdSystemUsername());
		realm.setSystemPassword(SecurityConfig.getAdSystemPassword());
		realm.setSearchBase(SecurityConfig.getAdSearchBase());
		realms.add(realm);
	}

	private void addCustomRealm(Set<Realm> realms) {
		SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
		/**
		 * 添加casRealm
		 */
		SmartCasRealm smartCasRealm = new SmartCasRealm(smartSecurity);
		// SmartCustomRealm smartCustomRealm = new
		// SmartCustomRealm(smartSecurity);
		// realms.add(smartCustomRealm);
		realms.add(smartCasRealm);
	}

	private void setCache(WebSecurityManager webSecurityManager) {
		if (SecurityConfig.isCacheable()) {
			CachingSecurityManager cachingSecurityManager = (CachingSecurityManager) webSecurityManager;
			/**
			 * 注释shiro自带缓存
			 */
			// CacheManager cacheManager = new MemoryConstrainedCacheManager();
			EhCacheManager ehCacheManager = new EhCacheManager();
			ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
			CacheManager cacheManager = ehCacheManager;
			cachingSecurityManager.setCacheManager(cacheManager);
		}
	}
}
