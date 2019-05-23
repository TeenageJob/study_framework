package org.smart.framework.core.impl.support;

/**
 * 用于获取子类的模板类
 *
 * @author TY
 * @Time 2017年9月19日 下午10:03:40
 * @since 1.0.0
 */
public abstract class SupperClassTemplate extends ClassTemplate {

    protected final Class<?> superClass;

    protected SupperClassTemplate(String packageName, Class<?> superClass) {
        super(packageName);
        this.superClass = superClass;
    }
}
