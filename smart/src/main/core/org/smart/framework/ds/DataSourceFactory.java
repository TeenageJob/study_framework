package org.smart.framework.ds;

import javax.sql.DataSource;

/**
 * 数据源工厂
 * 
 * @author TY
 * @Time 2017年9月19日 下午9:30:47
 * @since 1.0.0
 */
public interface DataSourceFactory {

    /**
     * 获取数据源
     *
     * @return 数据源
     */
    DataSource getDataSource();
}
