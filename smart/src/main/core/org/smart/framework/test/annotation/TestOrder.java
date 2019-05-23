package org.smart.framework.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义测试用例顺序
 *
 * @author TY
 * @Time 2017年9月20日 下午9:42:37
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestOrder {

    int value();
}
