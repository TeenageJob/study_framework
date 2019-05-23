package org.plugin.security.session.dao;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.plugin.cache.smart.Cache;
import org.plugin.cache.smart.SmartCacheManager;
import org.plugin.security.session.util.SerializableUtils;
import org.plugin.security.thread.SmartSecurityDataContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.util.StringUtil;

public class SmartSessionDao extends CachingSessionDAO {

	private static final Logger logger = LoggerFactory.getLogger(SmartSessionDao.class);

	private Cache<Serializable, String> sessionCache;

	public SmartSessionDao(SmartCacheManager smartCacheManager) {
		sessionCache = smartCacheManager.getCache("sessionCache");
	}

	@Override
	protected void doUpdate(Session session) {
		if (!SmartSecurityDataContext.Request.isStaticResource()) {
			if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
				return; // 如果会话过期/停止 没必要再更新了
			}
			sessionCache.put(session.getId(), SerializableUtils.serialize(session));
			logger.debug("Smart 更新了一个session  {}:\n\t{}", session.getId(), SerializableUtils.serialize(session));
			// String sql = "update sessions set session=? where id=?";
			// DatabaseHelper.update(sql, SerializableUtils.serialize(session),
			// session.getId());
		}
	}

	@Override
	protected void doDelete(Session session) {
		sessionCache.remove(session.getId());
		logger.debug("Smart 移除了一个session  {}", session.getId());
		String sql = "delete from sessions where id=?";
		DatabaseHelper.update(sql, session.getId());
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		sessionCache.put(sessionId, SerializableUtils.serialize(session));
		logger.debug("Smart 添加了一个session  {}:\n\t{}", sessionId, SerializableUtils.serialize(session));
		// String sql = "insert into sessions(id,session)values(?,?)";
		// DatabaseHelper.insertReturnPK(sql, sessionId,
		// SerializableUtils.serialize(session));
		return session.getId();
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		String session = sessionCache.get(sessionId);
		if (StringUtil.isEmpty(session)) {
			logger.debug("Smart 未获取到session  {}", sessionId);
			return null;
		} else {
			logger.debug("Smart 获取到一个session  {}", sessionId);
		}
		// String sql = "select session from sessions where id=?";
		// List<String> queryColumnList = DatabaseHelper.queryColumnList(sql,
		// sessionId);
		// if (queryColumnList.size() == 0)
		// return null;
		// return SerializableUtils.deserialize(queryColumnList.get(0));
		return SerializableUtils.deserialize(sessionCache.get(sessionId));

	}
}
