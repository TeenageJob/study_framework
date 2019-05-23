package org.smart.framework.ioc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart.framework.aop.annotation.Aspect;
import org.smart.framework.core.ClassHelper;
import org.smart.framework.core.fault.InitializationError;
import org.smart.framework.ioc.annotation.Bean;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.ArrayUtil;


/**
 * 初始化相关 Bean 类
 *
 * @author TY
 * @Time 2017年9月19日 下午10:33:21
 * @since 1.0.0
 */
public class BeanHelper {

    /**
     * Bean Map（Bean 类 => Bean 实例）
     */
    private static final Map<Class<?>, Object> beanMap = new HashMap<>();

    static {
        try {
            // 获取应用包路径下所有的类
            List<Class<?>> classList = ClassHelper.getClassList();
            for (Class<?> cls : classList) {
                // 处理带有 Bean/Service/Action/Aspect 注解的类
                if (cls.isAnnotationPresent(Bean.class) || cls.isAnnotationPresent(Service.class)
                        || cls.isAnnotationPresent(Action.class) || cls.isAnnotationPresent(Aspect.class)) {
                    // 创建 Bean 实例
                    Object beanInstance = cls.newInstance();
                    // 将 Bean 实例放入 Bean Map 中（键为 Bean 类，值为 Bean 实例）
                    beanMap.put(cls, beanInstance);
                }
            }
        } catch (Exception e) {
            throw new InitializationError("初始化 BeanHelper 出错！", e);
        }
    }

    /**
     * 获取 Bean Map
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    /**
     * 获取Bean Map中Service类 中<br>
     * 域带有指定注解的Map
     * <p>
     * <br>
     * create by on TY <br>
     * 2017年12月13日 上午11:07:11
     *
     * @param ann 注解
     * @return Map
     */
    public static Map<Class<?>, Object> getBeanMapWithFieldAnnotation(Class<? extends Annotation> cls) {
        Map<Class<?>, Object> annMap = new HashMap<>();
        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            Class<?> beanClass = beanEntry.getKey();
            if (beanClass.isAnnotationPresent(Service.class)) {
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    // 遍历所有的 Bean 字段
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(cls)) {
                            annMap.put(beanClass, beanInstance);
                        }
                    }
                }
            }
        }
        return beanMap;
    }

    /**
     * 获取 Bean 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!beanMap.containsKey(cls)) {
            throw new RuntimeException("无法根据类名获取实例！" + cls);
        }
        return (T) beanMap.get(cls);
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> cls, Object obj) {
        beanMap.put(cls, obj);
    }

    /**
     * 获取@Bean注解的类
     * <p>
     * <br>create by on TY
     * <br>2018年3月7日 下午5:25:01
     *
     * @return
     */
    public static Map<Class<?>, Object> getBeanClass() {
        Map<Class<?>, Object> annMap = new HashMap<>();
        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            Class<?> beanClass = beanEntry.getKey();
            if (beanClass.isAnnotationPresent(Bean.class)) {
                annMap.put(beanClass, beanEntry.getValue());
            }
        }
        return annMap;
    }


    /**
     * 获取注入的service的实例
     *
     * @param name service名称
     * @return Object实例
     */
    public static Map<Class<?>, Object> getServiceBeanMap(String name) {
        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            if (beanEntry.getKey().isAnnotationPresent(Service.class)) {
                String serviceName=beanEntry.getKey().getName().substring(beanEntry.getKey().getName().lastIndexOf(".")+1);
                if (serviceName.equalsIgnoreCase(name)) {
                    Map<Class<?>, Object> annMap = new HashMap<>();
                    annMap.put(beanEntry.getKey(), beanEntry.getValue());
                    return annMap;
                }
            }
        }
        return null;
    }
}
