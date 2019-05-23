package org.smart.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.smart.framework.core.ClassScanner;
import org.smart.framework.core.ConfigHelper;
import org.smart.framework.core.impl.DefaultClassScanner;
import org.smart.framework.dao.DataAccessor;
import org.smart.framework.dao.impl.DefaultDataAccessor;
import org.smart.framework.ds.DataSourceFactory;
import org.smart.framework.ds.impl.DefaultDataSourceFactory;
import org.smart.framework.mvc.HandlerExceptionResolver;
import org.smart.framework.mvc.HandlerInvoker;
import org.smart.framework.mvc.HandlerMapping;
import org.smart.framework.mvc.ViewResolver;
import org.smart.framework.mvc.impl.DefaultHandlerExceptionResolver;
import org.smart.framework.mvc.impl.DefaultHandlerInvoker;
import org.smart.framework.mvc.impl.DefaultHandlerMapping;
import org.smart.framework.mvc.impl.DefaultViewResolver;
import org.smart.framework.util.ObjectUtil;
import org.smart.framework.util.StringUtil;

/**
 * 实例工厂
 * 
 * @author TY
 * @Time 2017年9月19日 下午9:12:58
 * @since 1.0.0
 */
public class InstanceFactory {

    /**
     * 用于缓存对应的实例
     */
    private static final Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    /**
     * ClassScanner(类扫描器)
     */
    private static final String CLASS_SCANNER = "smart.framework.custom.class_scanner";

    /**
     * DataSourceFactory(数据源工厂)
     */
    private static final String DS_FACTORY = "smart.framework.custom.ds_factory";

    /**
     * DataAccessor(数据寄存器)
     */
    private static final String DATA_ACCESSOR = "smart.framework.custom.data_accessor";

    /**
     * HandlerMapping(句柄映射)
     */
    private static final String HANDLER_MAPPING = "smart.framework.custom.handler_mapping";

    /**
     * HandlerInvoker(句柄调用)
     */
    private static final String HANDLER_INVOKER = "smart.framework.custom.handler_invoker";

    /**
     * HandlerExceptionResolver(句柄异常解析)
     */
    private static final String HANDLER_EXCEPTION_RESOLVER = "smart.framework.custom.handler_exception_resolver";

    /**
     * ViewResolver(试图解析)
     */
    private static final String VIEW_RESOLVER = "smart.framework.custom.view_resolver";

    /**
     * 获取 ClassScanner
     */
    public static ClassScanner getClassScanner() {
        return getInstance(CLASS_SCANNER, DefaultClassScanner.class);
    }

    /**
     * 获取 DataSourceFactory
     */
    public static DataSourceFactory getDataSourceFactory() {
        return getInstance(DS_FACTORY, DefaultDataSourceFactory.class);
    }

    /**
     * 获取 DataAccessor
     */
    public static DataAccessor getDataAccessor() {
        return getInstance(DATA_ACCESSOR, DefaultDataAccessor.class);
    }

    /**
     * 获取 HandlerMapping
     */
    public static HandlerMapping getHandlerMapping() {
        return getInstance(HANDLER_MAPPING, DefaultHandlerMapping.class);
    }

    /**
     * 获取 HandlerInvoker
     */
    public static HandlerInvoker getHandlerInvoker() {
        return getInstance(HANDLER_INVOKER, DefaultHandlerInvoker.class);
    }

    /**
     * 获取 HandlerExceptionResolver
     */
    public static HandlerExceptionResolver getHandlerExceptionResolver() {
        return getInstance(HANDLER_EXCEPTION_RESOLVER, DefaultHandlerExceptionResolver.class);
    }

    /**
     * 获取 ViewResolver
     */
    public static ViewResolver getViewResolver() {
        return getInstance(VIEW_RESOLVER, DefaultViewResolver.class);
    }

    /**
     * 获取实例
     * <br>
     * create by ty on 2017年9月19日 下午9:19:54
     * @param cacheKey 实例名
     * @param defaultImplClass 默认继承类
     * @return T 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String cacheKey, Class<T> defaultImplClass) {
        // 若缓存中存在对应的实例，则返回该实例
        if (cache.containsKey(cacheKey)) {
            return (T) cache.get(cacheKey);
        }
        // 从配置文件中获取相应的接口实现类配置
        String implClassName = ConfigHelper.getString(cacheKey);
        // 若实现类配置不存在，则使用默认实现类
        if (StringUtil.isEmpty(implClassName)) {
            implClassName = defaultImplClass.getName();
        }
        // 通过反射创建该实现类对应的实例
        T instance = ObjectUtil.newInstance(implClassName);
        // 若该实例不为空，则将其放入缓存
        if (instance != null) {
            cache.put(cacheKey, instance);
        }
        // 返回该实例
        return instance;
    }
}
