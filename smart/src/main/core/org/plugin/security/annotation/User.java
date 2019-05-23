package org.plugin.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 判断当前用户是否已登录（包括：已认证 与 已记住）
 * @author TY
 * @Time 2017年11月10日 下午4:40:22
 * @since 1.0.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface User {
}
