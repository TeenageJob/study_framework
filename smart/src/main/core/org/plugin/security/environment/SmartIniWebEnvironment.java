package org.plugin.security.environment;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.util.ClassUtils;
import org.apache.shiro.web.env.IniWebEnvironment;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.plugin.security.IInterceptUrl;
import org.plugin.security.SecurityConfig;
import org.plugin.security.SecurityConstant;
import org.plugin.security.filter.SmartCasFilter;
import org.plugin.security.filter.SmartDefaultFilterChainManager;
import org.plugin.xmlparsing.SmartXMLParsing;
import org.plugin.xmlparsing.dom4j.DOM4J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.XMLConstant;
import org.smart.framework.util.CollectionUtil;

public class SmartIniWebEnvironment extends IniWebEnvironment {
	private static final Logger logger = LoggerFactory.getLogger(SmartIniWebEnvironment.class);

	@Override
	protected FilterChainResolver createFilterChainResolver() {
		// 在此处扩展自己的FilterChainResolver
		// 1、创建FilterChainResolver
		PathMatchingFilterChainResolver filterChainResolver = new PathMatchingFilterChainResolver();
		// 2、创建FilterChainManager
		SmartDefaultFilterChainManager filterChainManager = new SmartDefaultFilterChainManager();
		// 3、注册Filter
		/*
		 * anon(AnonymousFilter.class), authc(FormAuthenticationFilter.class),
		 * authcBasic(BasicHttpAuthenticationFilter.class),
		 * logout(LogoutFilter.class),
		 * noSessionCreation(NoSessionCreationFilter.class),
		 * perms(PermissionsAuthorizationFilter.class), port(PortFilter.class),
		 * rest(HttpMethodPermissionFilter.class),
		 * roles(RolesAuthorizationFilter.class), ssl(SslFilter.class),
		 * user(UserFilter.class);
		 */
		filterChainManager.addFilter("cas", new SmartCasFilter());
		for (DefaultFilter filter : DefaultFilter.values()) {
			filterChainManager.addFilter(filter.name(), (Filter) ClassUtils.newInstance(filter.getFilterClass()));
		}
		// filterChainManager.addFilter("ssl", new SslFilter());
		// 4、通过XML注册URL-Filter的映射关系
		addFilterUrlByXML(filterChainManager);
		// 5、通过数据库注册URL-Filter的映射关系
		addFilterUrlBySQL(filterChainManager);
		/*
		 * 参数chainName filterName chainSpecificFilterConfig url 拦截器名 拦截内容
		 * filterChainManager.addToChain("/login.jsp", "authc");
		 * filterChainManager.addToChain("/unauthorized.jsp", "anon");
		 * filterChainManager.addToChain("/**", "authc");
		 * filterChainManager.addToChain("/**",
		 * "roles","admin");admin=user:*,menu:*
		 */

		// 5、设置Filter的属性
		//cas拦截器
		SmartCasFilter casFilter = (SmartCasFilter) filterChainManager.getFilter("cas");
		casFilter.setFailureUrl(SecurityConstant.LOGINURL);
		casFilter.setSuccessUrl(SecurityConstant.SECCESSURL);

		//登出拦截器
		LogoutFilter logoutFilter=(LogoutFilter)filterChainManager.getFilter("logout");
		logoutFilter.setRedirectUrl(SecurityConstant.LOUGUOT);

		RolesAuthorizationFilter rolesFilter = (RolesAuthorizationFilter) filterChainManager.getFilter("roles");
		rolesFilter.setUnauthorizedUrl(SecurityConstant.UNAUTHORIZED);
		rolesFilter.setLoginUrl(SecurityConstant.CASLOGINURL);
		
		PermissionsAuthorizationFilter perFilter = (PermissionsAuthorizationFilter) filterChainManager
				.getFilter("perms");
		perFilter.setUnauthorizedUrl(SecurityConstant.UNAUTHORIZED);

		filterChainResolver.setFilterChainManager(filterChainManager);
		return filterChainResolver;
	}

	private void addFilterUrlBySQL(SmartDefaultFilterChainManager filterChainManager) {
		logger.debug("数据库注册URL-Filter的映射关系。。。。。。");
		IInterceptUrl interceptUrl = SecurityConfig.getInterceptUrl();
		Map<String, String> urls = interceptUrl.getInterceptURL();
		for (Map.Entry<String, String> url : urls.entrySet()) {
			filterChainManager.addToChain(url.getKey(), XMLConstant.PERMS, url.getValue());
		}
	}

	private void addFilterUrlByXML(SmartDefaultFilterChainManager filter) {
		logger.debug("XML注册URL-Filter的映射关系。。。。。。");
		DOM4J dom4j = new DOM4J();
		SmartXMLParsing smartXMLParsing = dom4j.getXMLInfo("shiro.xml");
		Element element = (Element) smartXMLParsing.getRootNod();
		listNodes(element, filter);
	}

	private void listNodes(Element node, SmartDefaultFilterChainManager filter) {
		// 首先获取当前节点的所有属性节点
		@SuppressWarnings("unchecked")
		List<Attribute> list = node.attributes();
		if (node.getName().equals(XMLConstant.ANY)) {
			// 遍历属性节点
			if (CollectionUtil.isNotEmpty(list)) {
				filter.addToChain(list.get(0).getValue(), list.get(1).getValue());
			}
		} else if (node.getName().equals(XMLConstant.ROLE)) {
			if (CollectionUtil.isNotEmpty(list)) {
				filter.addToChain(list.get(0).getValue(), XMLConstant.ROLES, list.get(1).getValue());
			}
		}
		// 使用递归
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			listNodes(e, filter);
		}
	}

}
