package org.plugin.security.session.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartSessionListener extends SessionListenerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SmartSessionListener.class);
	public void onStart(Session session) {
		logger.debug("用户："+session.getHost()+"连接进入。。。。。。");
	}

	public void onStop(Session session) {
		logger.debug("用户："+session.getHost()+"断开连接。。。。。。");
	}

	public void onExpiration(Session session) {
		logger.debug("用户："+session.getHost()+"连接发生错误。。。。。。");
	}

}
