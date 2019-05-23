package org.smart.framework.plugin;

import java.util.List;
import org.smart.framework.aop.proxy.Proxy;

/**
 * 插件代理
 *
 * @author TY
 * @Time 2017年9月20日 下午9:42:03
 * @since 1.0.0
 */
public abstract class PluginProxy implements Proxy {

    public abstract List<Class<?>> getTargetClassList();
}
