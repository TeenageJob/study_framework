package org.smart.framework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handler 异常解析器
 *
 * @author TY
 * @Time 2017年9月20日 下午9:37:37
 * @since 1.0.0
 */
public interface HandlerExceptionResolver {

    /**
     * 解析 Handler 异常
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param e        异常
     */
    void resolveHandlerException(HttpServletRequest request, HttpServletResponse response, Exception e);
}
