package org.smart.framework.core.impl.support;

import java.lang.annotation.Annotation;

/**
 * 用于获取注解类的模板类
 * 
 * @author TY
 * @Time 2017年9月19日 下午10:00:15
 * @since 1.0.0
 */
public abstract class AnnotationClassTemplate extends ClassTemplate {

    protected final Class<? extends Annotation> annotationClass;

    protected AnnotationClassTemplate(String packageName, Class<? extends Annotation> annotationClass) {
        super(packageName);
        this.annotationClass = annotationClass;
    }
}
