package org.plugin.security.session.scheduler;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.AbstractValidatingSessionManager;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.plugin.cache.redis.RedisCacheManager;
import org.plugin.security.session.util.SerializableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.util.ReflectionUtil;

/**
 * 会话校验
 * 
 * @author TY
 * @Time 2018年1月9日 下午5:29:54
 * @since 1.0.0
 */
public class SmartSessionValidationScheduler implements SessionValidationScheduler, Runnable {

	private static final Logger logger = LoggerFactory.getLogger(SmartSessionValidationScheduler.class);

	ValidatingSessionManager sessionManager;// 校验管理器
	private ScheduledExecutorService service;//
	private long interval = 360000;//
	private boolean enabled = false;

	@Override
	public void run() {
		if (logger.isDebugEnabled()) {
			logger.debug("Executing session validation...");
		}
		long startTime = System.currentTimeMillis();

		// 分页获取会话并验证
		// String sql = "select session from sessions limit ?,?";
		// int start = 0; // 起始记录
		// int size = 20; // 每页大小
		Collection<Object> sessionList = new RedisCacheManager().getCache("sessionCache").values();
		// List<String> sessionAll = DatabaseHelper.queryColumnList(sql, start,
		// size);
		logger.debug("总共有：{} 个session",sessionList.size());
		while (sessionList.size() > 0) {
			for (Object sessionStr : sessionList) {
				try {
					Session session = SerializableUtils.deserialize(sessionStr.toString());
					Method validateMethod = ReflectionUtil.findMethod(AbstractValidatingSessionManager.class,
							"validate", Session.class, SessionKey.class);
					validateMethod.setAccessible(true);
					ReflectionUtil.invokeMethod(validateMethod, sessionManager, session,
							new DefaultSessionKey(session.getId()));
				} catch (Exception e) {
					logger.debug("校验session出错了 ：{}", e.getMessage());
				}
			}
			/*
			 * start = start + size; sessionList =
			 * DatabaseHelper.queryColumnList(sql, start, size);
			 */
		}
		long stopTime = System.currentTimeMillis();
		if (logger.isDebugEnabled()) {
			logger.debug("Session validation completed successfully in " + (stopTime - startTime) + " milliseconds.");
		}

	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public void enableSessionValidation() {
		if (this.interval > 0l) {
			this.service = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
				public Thread newThread(Runnable r) {
					Thread thread = new Thread(r);
					thread.setDaemon(true);
					return thread;
				}
			});
			this.service.scheduleAtFixedRate(this, interval, interval, TimeUnit.MILLISECONDS);
			this.enabled = true;
		}
	}

	@Override
	public void disableSessionValidation() {
		this.service.shutdownNow();
		this.enabled = false;
	}

	public ValidatingSessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(ValidatingSessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public ScheduledExecutorService getService() {
		return service;
	}

	public void setService(ScheduledExecutorService service) {
		this.service = service;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
