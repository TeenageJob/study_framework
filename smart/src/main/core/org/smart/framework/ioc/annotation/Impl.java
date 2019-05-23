package org.smart.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定接口的实现类
 *
 * @author TY
 * @Time 2017年9月20日 下午9:36:42
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Impl {

    Class<?> value();
}
