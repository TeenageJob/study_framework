package org.smart.framework.mvc;

/**
 * 处理器映射
 *
 * @author TY
 * @Time 2017年9月19日 下午10:13:16
 */
public interface HandlerMapping {

    /**
     * 获取 Handler
     *
     * @param currentRequestMethod 当前请求方法
     * @param currentRequestPath   当前请求路径
     * @return Handler
     */
    Handler getHandler(String currentRequestMethod, String currentRequestPath);
}
