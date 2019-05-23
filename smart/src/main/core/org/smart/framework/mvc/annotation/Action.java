package org.smart.framework.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义 Action 类
 *
 * @author TY
 * @Time 2017年9月20日 下午9:38:19
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
   /**
    * 定义Action路径
    * <br>添加Action路径能够更加清晰的配置url
    * @author TY
    * @Time 2017年11月4日 上午9:03:11
    * @since 1.0.1
    */
	 String value() default "";
}
