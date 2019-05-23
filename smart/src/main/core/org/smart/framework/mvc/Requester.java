package org.smart.framework.mvc;

/**
 * 封装 Request 对象相关信息
 * 
 * @author TY
 * @Time 2017年9月19日 下午10:22:26
 * @since 1.0.0
 */
public class Requester {

    private String requestMethod;// 请求方法
    private String requestPath;  // 请求路径

    public Requester(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }
}