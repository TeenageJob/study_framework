package org.smart.framework.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 数据访问器
 *
 * @author TY
 * @Time 2017年9月19日 下午10:08:22
 * @since 1.0.0
 */
public interface DataAccessor {

    /**
     * 查询对应的实体，返回单条记录
     */
    <T> T queryEntity(Class<T> entityClass, String sql, Object... params);

    /**
     * 查询对应的实体列表，返回多条记录
     */
    <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params);

    /**
     * 查询对应的实体列表，返回单条记录（主键 => 实体）
     */
    <K, V> Map<K, V> queryEntityMap(Class<V> entityClass, String sql, Object... params);

    /**
     * 查询对应的数据，返回单条记录
     */
    Object[] queryArray(String sql, Object... params);

    /**
     * 查询对应的数据，返回多条记录
     */
    List<Object[]> queryArrayList(String sql, Object... params);

    /**
     * 查询对应的数据，返回单条记录（列名 => 数据）
     */
    Map<String, Object> queryMap(String sql, Object... params);

    /**
     * 查询对应的数据，返回多条记录（列名 => 数据）
     */
    List<Map<String, Object>> queryMapList(String sql, Object... params);

    /**
     * 查询对应的数据，返回单条数据（列名 => 数据）
     */
    <T> T queryColumn(String sql, Object... params);

    /**
     * 查询对应的数据，返回多条数据（列名 => 数据）
     */
    <T> List<T> queryColumnList(String sql, Object... params);
    
    /**
     * 查询对应的数据，返回多条数据（列名 => 数据）
     */
    <T> Set<T> queryColumnSet(String sql, Object... params);

    /**
     * 查询指定列名对应的数据，返回多条数据（列名对应的数据 => 列名与数据的映射关系）
     */
    <T> Map<T, Map<String, Object>> queryColumnMap(String column, String sql, Object... params);

    /**
     * 查询记录条数，返回总记录数
     */
    long queryCount(String sql, Object... params);

    /**
     * 执行更新操作（包括：update、insert、delete），返回所更新的记录数
     */
    int update(String sql, Object... params);

    /**
     * 插入一条记录，返回插入后的主键
     */
    Serializable insertReturnPK(String sql, Object... params);

    /**
     * 执行sql，返回更新行数
     */
    int executeSql(String sql,Object... params);

    /**
     * 执行sql，返回List结果
     */
    <T> List<T> executeSqlList(String sql,Object... params);

    /**
     * 执行sql，返回List结果
     */
    <T> List<List<T>> executeList(String sql, Object... params);

    /**
     * 执行sql，返回List结果
     */
    <T> List<Map<T, Map<String, Object>>> executeColumnMap(String column, String sql, Object... params);
}
