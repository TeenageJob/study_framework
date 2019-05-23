package org.smart.framework.ds.impl;

import javax.sql.DataSource;
import org.smart.framework.core.ConfigHelper;
import org.smart.framework.ds.DataSourceFactory;

/**
 * 抽象数据源工厂
 * 
 * @author TY
 * @Time 2017年9月19日 下午9:27:54
 * @param <T> <T extends DataSource>限制是用类型为DataSource子类和本身
 * @since 1.0.0
 */
public abstract class AbstractDataSourceFactory<T extends DataSource> implements DataSourceFactory {

	/*** 驱动   ***/
    protected final String driver = ConfigHelper.getString("smart.framework.jdbc.driver");
    /*** URL ***/
    protected final String url = ConfigHelper.getString("smart.framework.jdbc.url");
    /*** 账户  ***/
    protected final String username = ConfigHelper.getString("smart.framework.jdbc.username");
    /*** 密码  ***/
    protected final String password = ConfigHelper.getString("smart.framework.jdbc.password");

    @Override
    public final T getDataSource() {
        // 创建数据源对象
        T ds = createDataSource();
        // 设置基础属性
        setDriver(ds, driver);
        setUrl(ds, url);
        setUsername(ds, username);
        setPassword(ds, password);
        // 设置高级属性
        setAdvancedConfig(ds);
        return ds;
    }
    
    public abstract T createDataSource();

    public abstract void setDriver(T ds, String driver);

    public abstract void setUrl(T ds, String url);

    public abstract void setUsername(T ds, String username);

    public abstract void setPassword(T ds, String password);
    /**
     * 连接池自动关闭长时间没有使用的连接
     * 
     * create by ty on 2017年9月19日 下午9:33:03
     * @param ds BasicDataSource
     */
    public abstract void setAdvancedConfig(T ds);
}
