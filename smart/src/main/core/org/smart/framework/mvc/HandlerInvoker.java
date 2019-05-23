package org.smart.framework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handler 调用器
 *
 * @author TY
 * @Time 2017年9月20日 下午9:37:48
 * @since 1.0.0
 */
public interface HandlerInvoker {

    /**
     * 调用 Handler
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  Handler
     * @throws Exception 异常
     */
    void invokeHandler(HttpServletRequest request, HttpServletResponse response, Handler handler) throws Exception;
}
