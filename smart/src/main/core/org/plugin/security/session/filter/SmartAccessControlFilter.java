package org.plugin.security.session.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SmartSession;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.plugin.security.SecurityConstant;

/**
 * 拦截器
 * 
 * @author TY
 * @Time 2017年12月15日 下午4:59:06
 * @since 1.0.0
 */
public class SmartAccessControlFilter extends AccessControlFilter {

	private SessionDAO sessionDAO;

	public SmartAccessControlFilter(SessionDAO sessionDAO) {
		super();
		this.sessionDAO = sessionDAO;
	}

	public String getForceLogoutUrl() {
		return SecurityConstant.FORCELOGOUTURL;
	}

	


	/**
	 * 表示是否允许访问
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		if (subject == null || subject.getSession(false) == null) {
			return true;
		}
		Session session = sessionDAO.readSession(subject.getSession().getId());
		if (session != null && session instanceof SmartSession) {
			SmartSession onlineSession = (SmartSession) session;
			request.setAttribute(SecurityConstant.ONLINE_SESSION, onlineSession);

			if (onlineSession.getStatus() == SmartSession.OnlineStatus.force_logout) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 表示当访问拒绝时是否已经处理了
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if (subject != null) {
			subject.logout();
		}
		saveRequestAndRedirectToLogin(request, response);
		return true;
	}

	/**
	 * 重定向到登录页面
	 */
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		WebUtils.issueRedirect(request, response, getForceLogoutUrl());
	}

}
