package org.plugin.sso.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.plugin.sso.tool.SmartProps;

public class SmartInitializerImpl implements SmartInitializer {

	@Override
	public void init(ServletContext servletContext) {
		if (SmartProps.isSSO()) {
			//cas服务路径
			String casServerUrlPrefix = SmartProps.getCasServerUrlPrefix();
			String casServerLoginUrl = SmartProps.getCasServerLoginUrl();
			//客户端访问路径
			String serverName = SmartProps.getServerName();//CAS客户端的服务器名称
			String filterMapping = SmartProps.getFilterMapping();

			servletContext.addListener(SingleSignOutHttpSessionListener.class);

			FilterRegistration.Dynamic singleSignOutFilter = servletContext.addFilter("SingleSignOutFilter",
					SingleSignOutFilter.class);
			singleSignOutFilter.setInitParameter("ignorePattern", SmartProps.getIgnorePatternUrl());
			singleSignOutFilter.setInitParameter("casServerUrlPrefix", casServerUrlPrefix);
			singleSignOutFilter.addMappingForUrlPatterns(null, false, filterMapping);

			FilterRegistration.Dynamic authenticationFilter = servletContext.addFilter("AuthenticationFilter",
					AuthenticationFilter.class);
			authenticationFilter.setInitParameter("casServerLoginUrl", casServerLoginUrl);
			authenticationFilter.setInitParameter("serverName", serverName);
			//忽略登录路径正则表达式
			//authenticationFilter.setInitParameter("ignorePattern", SmartProps.getIgnorePatternUrl());
			authenticationFilter.addMappingForUrlPatterns(null, false, filterMapping);

			FilterRegistration.Dynamic ticketValidationFilter = servletContext.addFilter("TicketValidationFilter",
					Cas30ProxyReceivingTicketValidationFilter.class);
			ticketValidationFilter.setInitParameter("casServerUrlPrefix", casServerUrlPrefix);
			ticketValidationFilter.setInitParameter("serverName", SmartProps.getServerName());
			ticketValidationFilter.setInitParameter("ignorePattern", SmartProps.getIgnorePatternUrl());
			ticketValidationFilter.addMappingForUrlPatterns(null, false, filterMapping);

			FilterRegistration.Dynamic requestWrapperFilter = servletContext.addFilter("RequestWrapperFilter",
					HttpServletRequestWrapperFilter.class);
			requestWrapperFilter.setInitParameter("ignorePattern", SmartProps.getIgnorePatternUrl());
			requestWrapperFilter.addMappingForUrlPatterns(null, false, filterMapping);

			FilterRegistration.Dynamic assertionThreadLocalFilter = servletContext
					.addFilter("AssertionThreadLocalFilter", AssertionThreadLocalFilter.class);
			assertionThreadLocalFilter.setInitParameter("ignorePattern", SmartProps.getIgnorePatternUrl());
			assertionThreadLocalFilter.addMappingForUrlPatterns(null, false, filterMapping);
		}
	}
}
