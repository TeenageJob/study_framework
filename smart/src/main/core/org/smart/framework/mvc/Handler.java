package org.smart.framework.mvc;

import java.lang.reflect.Method;
import java.util.regex.Matcher;

/**
 * 封装 Action 方法相关信息
 * 
 * @author TY
 * @Time 2017年9月19日 下午10:14:08
 * @since 1.0.0
 */
public class Handler {

    private Class<?> actionClass; // Action class
    private Method actionMethod;  // Action method
    private Matcher requestPathMatcher; // 请求路径匹配器

    public Handler(Class<?> actionClass, Method actionMethod) {
        this.actionClass = actionClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getActionClass() {
        return actionClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public Matcher getRequestPathMatcher() {
        return requestPathMatcher;
    }

    public void setRequestPathMatcher(Matcher requestPathMatcher) {
        this.requestPathMatcher = requestPathMatcher;
    }
}