package org.smart.framework.core;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * 类扫描器<br>
 * 获取类文件
 * @author TY
 * @Time 2017年9月19日 下午9:35:16
 * @since 1.0.0
 */
public interface ClassScanner {

    /**
     * 获取指定包名中的所有类
     */
    List<Class<?>> getClassList(String packageName);

    /**
     * 获取指定包名中指定注解的相关类
     */
    List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass);

    /**
     * 获取指定包名中指定父类或接口的相关类
     */
    List<Class<?>> getClassListBySuper(String packageName, Class<?> superClass);
}
