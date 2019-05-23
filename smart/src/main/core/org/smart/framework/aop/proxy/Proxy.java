package org.smart.framework.aop.proxy;

/**
 * 代理接口
 *
 * @author TY
 * @Time 2017年9月20日 下午9:33:22
 * @since 1.0.0
 */
public interface Proxy {

    /**
     * 执行链式代理
     *
     * @param proxyChain 代理链
     * @return 目标方法返回值
     * @throws Throwable 异常
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
