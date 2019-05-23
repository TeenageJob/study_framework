package org.plugin.security.session.online;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SmartSession;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.smart.framework.util.IpUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据会话上下文创建相应的 OnlineSession。
 */
public class SmartSessionFactory implements SessionFactory {

	@Override
	public Session createSession(SessionContext initData) {
		SmartSession session = new SmartSession();//自定义session
		if (initData != null && initData instanceof WebSessionContext) {
			WebSessionContext sessionContext = (WebSessionContext) initData;
			HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
			if (request != null) {
				session.setUrl(request.getServletPath());
				session.setHost(IpUtils.getIpAddr(request));
				session.setUserAgent(request.getHeader("User-Agent"));//声明了浏览器用于 HTTP 请求的用户代理头的值
				session.setSystemHost(request.getLocalAddr() + ":" + request.getLocalPort());
			}
		}
		return session;
	}
}
