package org.smart.framework.core.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import org.smart.framework.core.ClassScanner;
import org.smart.framework.core.impl.support.AnnotationClassTemplate;
import org.smart.framework.core.impl.support.ClassTemplate;
import org.smart.framework.core.impl.support.SupperClassTemplate;

/**
 * 默认类扫描器
 *
 * @author TY
 * @Time 2017年9月19日 下午9:34:50
 * @since 1.0.0
 */
public class DefaultClassScanner implements ClassScanner {

    @Override
    public List<Class<?>> getClassList(String packageName) {
        return new ClassTemplate(packageName) {
            @Override
            public boolean checkAddClass(Class<?> cls) {
                String className = cls.getName();
                String pkgName = className.substring(0, className.lastIndexOf("."));
                return pkgName.startsWith(packageName);
            }
        }.getClassList();
    }

    @Override
    public List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass) {
        return new AnnotationClassTemplate(packageName, annotationClass) {
            @Override
            public boolean checkAddClass(Class<?> cls) {
                return cls.isAnnotationPresent(annotationClass);
            }
        }.getClassList();
    }

    @Override
    public List<Class<?>> getClassListBySuper(String packageName, Class<?> superClass) {
        return new SupperClassTemplate(packageName, superClass) {
            @Override
            public boolean checkAddClass(Class<?> cls) {
                return superClass.isAssignableFrom(cls) && !superClass.equals(cls);
            }
        }.getClassList();
    }
}
