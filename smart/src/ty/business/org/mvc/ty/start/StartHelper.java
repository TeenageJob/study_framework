package org.mvc.ty.start;

import org.mvc.ty.start.menu.IMenu;
import org.mvc.ty.start.menu.impl.Menus;
import org.plugin.cache.redis.RedisCacheManager;
import org.plugin.cache.smart.Cache;
import org.plugin.cache.smart.SmartCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartHelper {
	private static final Logger logger = LoggerFactory.getLogger(StartHelper.class);
	private static Cache<Object, Object> cache;

	public StartHelper() {
		start();
	}

	public static void start() {
		logger.debug("开始执行启动时任务。。。。。。。。。");
		IMenu menu = new Menus();
		SmartCacheManager smartCacheManager = new RedisCacheManager();
		cache = smartCacheManager.getCache("menu");
		cache.put("menus", menu.getInfo());
		cache.put("rolemenu", menu.getRoleMenu());
		logger.debug("加载菜单内容完毕...........");
	}

	public static Cache<Object, Object> getCache() {
		return cache;
	}
}
