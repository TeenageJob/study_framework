package org.smart.framework.plugin;

/**
 * 插件接口
 *
 * @author TY
 * @Time 2017年9月20日 下午9:41:46
 * @since 1.0.0
 */
public interface Plugin {

    /**
     * 初始化插件
     */
    void init();

    /**
     * 销毁插件
     */
    void destroy();
}
