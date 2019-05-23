package org.plugin.mybatis;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 自动处理Mybatis的Session
 * 如果想让系统自动处理session的关闭和异常回滚需要用到@MybatisSession注解
 * 只需要在需要使用的方法上写@MybatisSession注解即可
 * @author TY
 * @Time 2017年11月22日 下午9:24:41
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MybatisSession {

}
