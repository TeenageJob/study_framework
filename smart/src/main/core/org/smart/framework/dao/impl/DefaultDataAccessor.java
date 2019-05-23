package org.smart.framework.dao.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.dao.DataAccessor;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.orm.EntityHelper;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.MapUtil;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 默认数据访问器 <br/>
 * 基于 Apache Commons DbUtils 实现
 *
 * @author TY
 * @Time 2017年9月19日 下午10:05:44
 */
public class DefaultDataAccessor implements DataAccessor {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDataAccessor.class);

    /*** SQL操作 ***/
    private final QueryRunner queryRunner;

    public DefaultDataAccessor() {
        DataSource dataSource = DatabaseHelper.getDataSource();
        queryRunner = new QueryRunner(dataSource);
    }

    @Override
    public <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T result;
        try {
            Map<String, String> columnMap = EntityHelper.getColumnMap(entityClass);
            if (MapUtil.isNotEmpty(columnMap)) {
                result = queryRunner.query(sql,
                        new BeanHandler<T>(entityClass, new BasicRowProcessor(new BeanProcessor(columnMap))), params);
            } else {
                result = queryRunner.query(sql, new BeanHandler<T>(entityClass), params);
            }
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }

    @Override
    public <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> result;
        try {
            Map<String, String> columnMap = EntityHelper.getColumnMap(entityClass);
            if (MapUtil.isNotEmpty(columnMap)) {
                result = queryRunner.query(sql,
                        new BeanListHandler<T>(entityClass, new BasicRowProcessor(new BeanProcessor(columnMap))),
                        params);
            } else {
                result = queryRunner.query(sql, new BeanListHandler<T>(entityClass), params);
            }
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }

    @Override
    public <K, V> Map<K, V> queryEntityMap(Class<V> entityClass, String sql, Object... params) {
        Map<K, V> entityMap;
        try {
            entityMap = queryRunner.query(sql, new BeanMapHandler<K, V>(entityClass), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return entityMap;
    }

    @Override
    public Object[] queryArray(String sql, Object... params) {
        Object[] array;
        try {
            array = queryRunner.query(sql, new ArrayHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return array;
    }

    @Override
    public List<Object[]> queryArrayList(String sql, Object... params) {
        List<Object[]> arrayList;
        try {
            arrayList = queryRunner.query(sql, new ArrayListHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return arrayList;
    }

    @Override
    public Map<String, Object> queryMap(String sql, Object... params) {
        Map<String, Object> map;
        try {
            map = queryRunner.query(sql, new MapHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return map;
    }

    @Override
    public List<Map<String, Object>> queryMapList(String sql, Object... params) {
        List<Map<String, Object>> fieldMapList;
        try {
            fieldMapList = queryRunner.query(sql, new MapListHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return fieldMapList;
    }

    @Override
    public <T> T queryColumn(String sql, Object... params) {
        T obj;
        try {
            obj = queryRunner.query(sql, new ScalarHandler<T>(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return obj;
    }

    @Override
    public <T> List<T> queryColumnList(String sql, Object... params) {
        List<T> list;
        try {
            list = queryRunner.query(sql, new ColumnListHandler<T>(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return list;
    }

    @Override
    public <T> Set<T> queryColumnSet(String sql, Object... params) {
        Set<T> set = new HashSet<>();
        try {
            List<T> list = queryRunner.query(sql, new ColumnListHandler<T>(), params);
            set.addAll(list);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return set;
    }

    @Override
    public <T> Map<T, Map<String, Object>> queryColumnMap(String column, String sql, Object... params) {
        Map<T, Map<String, Object>> map;
        try {
            map = queryRunner.query(sql, new KeyedHandler<T>(column), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return map;
    }

    @Override
    public long queryCount(String sql, Object... params) {
        long result;
        try {
            result = queryRunner.query(sql, new ScalarHandler<Long>("count(*)"), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }

    @Override
    public int update(String sql, Object... params) {
        int result;
        try {
            Connection conn = DatabaseHelper.getConnection();
            result = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            logger.error("更新出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }

    @Override
    public Serializable insertReturnPK(String sql, Object... params) {
        Serializable key = null;
        try {
            Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if (ArrayUtil.isNotEmpty(params)) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            int rows = pstmt.executeUpdate();
            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    key = (Serializable) rs.getObject(1);
                }
            }
        } catch (SQLException e) {
            logger.error("插入出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return key;
    }

    @Override
    public int executeSql(String sql, Object... params) {
        int result = 0;
        try {
            result = queryRunner.execute(sql, params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }

    @Override
    public <T> List<T> executeSqlList(String sql, Object... params) {
        List<T> result;
        try {//(String sql, ResultSetHandler<T> rsh, Object... params)
            result = queryRunner.execute(sql, new ScalarHandler<T>(), params);

        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }//ColumnListHandler

    @Override
    public <T> List<List<T>> executeList(String sql, Object... params) {
        List<List<T>> result;
        try {//(String sql, ResultSetHandler<T> rsh, Object... params)
            result = queryRunner.execute(sql, new ColumnListHandler<T>(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return result;
    }


    @Override
    public <T> List<Map<T, Map<String, Object>>> executeColumnMap(String column, String sql, Object... params) {
        List<Map<T, Map<String, Object>>> map;
        try {
            map = queryRunner.execute(sql, new KeyedHandler<T>(column), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql, params);
        return map;
    }

    /**
     * 将SQL操作加入日志 <br>
     * create by ty on 2017年9月19日 下午10:10:34
     *
     * @param sql sql语句
     */
    private static void printSQL(String sql, Object... params) {
        logger.debug("[Smart] SQL - {}", sql);
        logger.debug("[Smart] Params - {}", params);
    }

}
