package org.plugin.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.core.ClassHelper;
import org.smart.framework.core.ConfigHelper;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.plugin.Plugin;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.ConstantUtil;
import org.smart.framework.util.FileUtil;
import org.smart.framework.util.PropertyUtil;
import org.smart.framework.util.StringUtil;

/**
 * 支持注解和包配置
 * 
 * @author TY
 * @Time 2017年11月22日 下午9:21:47
 * @since 1.0.0
 */
public class MybatisHelper implements Plugin {
	private static final Logger logger = LoggerFactory.getLogger(MybatisHelper.class);
	/**
	 * 包扫描路径,逗号隔开(适用于注解方式，不配置xml)
	 */
	public static final String MYBATIS_MAPPER_PACKAGE = "smart.plugin.mybatis.pk";

	/**
	 * Mybatis - xml文件,多个文件逗号隔开,文件类型必须带.xml后缀,文件夹不能带后缀
	 */
	public static final String MYBATIS_MAPPER_XML = "smart.plugin.mybatis.mapper";

	/**
	 * 注入注解，解决调用问题
	 */
	public static final String MYBTIS_INJECT = "smart.plugin.mybatis.inject";

	/**
	 * Mybatis 别名配置 mybatis.aliases.name为单独的类，mybatis.aliases.package为包
	 */
	public static final String MYBATIS_ALIASES = "mybatis.aliases.";
	public static final String MYBATIS_ALIASES_PACKAGE = "mybatis.aliases.package";
	public static final String MYBATIS_ALIASES_NAME = "mybatis.aliases.name.";

	/**
	 * 插件包路径：如分页、、、
	 */
	public static final String MYBATIS_PLUGIN = "mybatis.plugin.";

	/**
	 * Mybatis 日志
	 */
	public static final String MYBATIS_LOGIMPL = "mybatis.log";

	/**
	 * 工厂
	 */
	private static SqlSessionFactory sqlSessionFactory;

	private static ThreadLocal<SqlSession> localSession = new ThreadLocal<SqlSession>();

	@Override
	public void init() {
		// 1.建立链接池
		DataSource dataSource = DatabaseHelper.getDataSource();
		if (dataSource != null) {
			// 2.创建事务工厂
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			// 3.设置环境
			Environment environment = new Environment("smart_database", transactionFactory, dataSource);
			// 4.配置环境
			Configuration configuration = new Configuration(environment);

			// Mybatis日志配置
			String logImpl = ConfigHelper.getString(MYBATIS_LOGIMPL);
			if (logImpl != null && !logImpl.equals("")) {
				configuration.setLogImpl(configuration.getTypeAliasRegistry().resolveAlias(logImpl));
			}

			// Aliases别名
			Map<String, Object> aliases = ConfigHelper.getMap(MYBATIS_ALIASES);
			registerAliases(aliases, configuration);

			// 加载插件
			Map<String, Object> plugins = ConfigHelper.getMap(MYBATIS_PLUGIN);
			registerPlugins(plugins, configuration);

			// 注册xml
			String _resource = ConfigHelper.getString(MYBATIS_MAPPER_XML);
			if (StringUtil.isNotEmpty(_resource)) {
				String[] resources = StringUtil.splitString(_resource, ",");
				for (String res : resources) {
					try {
						registerXml(res, configuration);
					} catch (Exception e) {
						logger.debug("注册[" + res + "]路径下xml失败，失败信息:" + e.getMessage());
					}
				}
			}

			// 注册包
			String _package = ConfigHelper.getString(MYBATIS_MAPPER_PACKAGE);
			if (StringUtil.isNotEmpty(_package)) {
				String[] packages = StringUtil.splitString(_package, ",");
				for (String pk : packages) {
					try {
						configuration.addMappers(pk);
						logger.debug("注册包 [ " + pk + " ] 成功。");
					} catch (Exception e) {
						logger.debug("注册包[" + pk + "]失败，失败信息:" + e.getMessage());
					}
				}
			}

			// 注册注解
			List<Class<?>> mappers = ClassHelper.getClassListByAnnotation(Mapper.class);
			if (CollectionUtil.isNotEmpty(mappers)) {
				for (Class<?> clazz : mappers) {
					try {
						Mapper mapper = clazz.getAnnotation(Mapper.class);
						String xml = null;
						if (mapper != null) {
							xml = mapper.value();
							if (xml != null && !xml.equals("")) {
								registerXml(xml, configuration);
							}
						}
						// XML和接口只注册一个
						if (StringUtil.isEmpty(xml)) {
							configuration.addMapper(clazz);
						}
					} catch (Exception e) {
						logger.error("注解Mapper类[" + clazz.getCanonicalName() + "]出错:" + e.getMessage());
					}
				}
			}
			// 5.构建SessionFactory。完成构建的全部任务
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

			// 6.注入MybatisInject注解
			/*try {
				injectInterface();
			} catch (Exception e) {
				logger.debug("注入MybatisInject接口失败，失败信息:" + e.getMessage());
			}*/
		}
	}

	/**
	 * 注册别名
	 *
	 * @param aliases
	 * @param configuration
	 */
	private static void registerAliases(Map<String, Object> aliases, Configuration configuration) {
		for (Iterator<Map.Entry<String, Object>> iterator = aliases.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, Object> kV = iterator.next();
			String name = kV.getKey();
			String value = (String) kV.getValue();
			if (name.startsWith(MYBATIS_ALIASES_PACKAGE)) {
				// String typeAliasPackage =
				// name.substring(MYBATIS_ALIASES_PACKAGE.length());
				configuration.getTypeAliasRegistry().registerAliases(value);
			} else {
				String alias = null;
				String type = value;
				try {
					alias = name.substring(MYBATIS_ALIASES_NAME.length());
				} catch (Exception e) {
				}
				try {
					Class<?> clazz = Resources.classForName(type);
					// 测试多个mybatis.aliases.name.
					if (alias == null || alias.length() == 0) {
						configuration.getTypeAliasRegistry().registerAlias(clazz);
					} else {
						configuration.getTypeAliasRegistry().registerAlias(alias, clazz);
					}
				} catch (ClassNotFoundException e) {
					throw new BuilderException("注册别名 '" + alias + "' 异常. 原因: " + e, e);
				}
			}
		}
	}

	/**
	 * 注册插件
	 *
	 * @param plugins
	 * @param configuration
	 */
	private static void registerPlugins(Map<String, Object> plugins, Configuration configuration) {
		Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
		// 处理配置参数
		for (Iterator<Map.Entry<String, Object>> iterator = plugins.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, Object> kV = iterator.next();
			String name = kV.getKey();
			String value = (String) kV.getValue();
			if (name.startsWith(MYBATIS_PLUGIN)) {
				String pluginName = name.substring(MYBATIS_PLUGIN.length());
				String propertyName = null;
				if (pluginName.indexOf('.') > 0) {// 过滤插件属性
					propertyName = pluginName.substring(pluginName.indexOf('.') + 1);
					pluginName = pluginName.substring(0, pluginName.indexOf('.') + 1);
					if (propertiesMap.get(pluginName) == null) {
						propertiesMap.put(pluginName, new Properties());
					}
				}
				// 存放属性值
				if (propertyName != null && propertyName.length() > 0) {
					propertiesMap.get(pluginName).put(propertyName, value);

				}
			}
		}
		// 注册插件
		for (Iterator<Map.Entry<String, Properties>> iterator = propertiesMap.entrySet().iterator(); iterator
				.hasNext();) {
			Map.Entry<String, Properties> kV = iterator.next();
			String name = kV.getKey();
			Properties properties = (Properties) kV.getValue();
			String clazz = (String) plugins.get(MYBATIS_PLUGIN + name);
			if (clazz != null && clazz.length() > 0) {
				Interceptor interceptorInstance = null;
				try {
					interceptorInstance = (Interceptor) Class.forName(clazz).newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				interceptorInstance.setProperties(properties);
				configuration.addInterceptor(interceptorInstance);
			}
		}
	}

	/**
	 * 注册xml
	 *
	 * @param res
	 * @param configuration
	 */
	private static void registerXml(String res, Configuration configuration) {
		if (res.toLowerCase().endsWith(".xml")) {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(res);
				XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, res,
						configuration.getSqlFragments());
				mapperParser.parse();
				logger.debug("解析  mybatis - xml - {}", res.substring(res.lastIndexOf(ConstantUtil.SPRIT) + 1));
			} catch (Exception e) {
				logger.error(e.getMessage());
				// 不处理
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (Exception e) {
						// 不处理
						logger.error(e.getMessage());
					}
				}
			}
		} else {
			/*
			 * try { URL url = Resources.getResourceURL(res); String resUrl =
			 * res; if (!resUrl.endsWith("/")) { resUrl += "/"; } if (url !=
			 * null && url.getPath() != null) { // 获取该目录下的所有XML文件和目录 /** since
			 * 1.0.1 改进方法，支持递归获取文件夹下的所有xml文件 File[] files = new
			 * File(url.getPath()).listFiles(new FilenameFilter() {
			 * 
			 * @Override public boolean accept(File dir, String name) { if
			 * (name.toLowerCase().endsWith(".xml") ||
			 * FileUtil.isDirectory(name)) { return true; } return false; } });
			 * for (File file : files) { if (FileUtil.isDirNotEmpty(file) ||
			 * file.getName().toLowerCase().endsWith(".xml")) {
			 * registerXml(resUrl + file.getName(), configuration); } }
			 */
			try {
				List<String> fileList = new ArrayList<>();
				FileUtil.getFileByDirectory(res, "xml", fileList);
				for (String name : fileList) {
					registerXml(name, configuration);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			/*
			 * since 1.0.0
			 * 
			 * File[] files = new File(url.getPath()).listFiles(new
			 * FilenameFilter() {
			 * 
			 * @Override public boolean accept(File dir, String name) {
			 * 
			 * if (name.toLowerCase().endsWith(".xml")) { return true; } return
			 * false; } });
			 */
			/*
			 * for (File file : files) { registerXml(resUrl + file.getName(),
			 * configuration); }
			 */
		}

	}

	/**
	 * 注入mybatis依赖接口 
	 * <br>1.找到所有带注解的类 
	 * <br>2.给带注解的类的域注入Session
	 * 
	 * 
	 * 该方法在注入Session时，只能注入一个，并且无法在后续找到对应的Session
	 * 所以不再使用
	 * <br>已经替代为在MybatisSessionProxy调用before是进行注入
	 * <br>
	 * create by on TY <br>
	 * 2017年12月13日 上午10:29:08
	 * 
	 * @param res
	 *            路径
	 */
	@Deprecated
	private static void injectInterface() {
		// 注入
		Map<Class<?>, Object> beanMap = PropertyUtil.isFieldContainInject(MybatisInject.class);
		// 循环注入
		for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
			Class<?> beanClass = beanEntry.getKey();
			Object beanInstance = beanEntry.getValue();
			Field[] beanFields = beanClass.getDeclaredFields();
			for (Field beanField : beanFields) {
				if (beanField.isAnnotationPresent(MybatisInject.class)) {
					try {
						beanField.setAccessible(true); // 将字段设置为 public
						beanField.set(beanInstance, getMapper(beanField.getType()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.debug("注入Mybatis的Session失败，失败的类：" + beanClass + "\n失败信息：" + e.getMessage());
					}
				}
			}
		}
	}

	/**
	 * 获取SqlSession - 如果不存在则创建一个
	 *
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return getSqlSession(true);
	}

	/**
	 * 获取Session
	 *
	 * @param create
	 *            当sqlSession不存在的时候，如果true则创建一个，如果false返回null
	 * @return
	 */
	public static SqlSession getSqlSession(boolean create) {
		if (sqlSessionFactory == null) {
			return null;
		}
		SqlSession sqlSession = localSession.get();
		if (sqlSession == null && create) {
			sqlSession = sqlSessionFactory.openSession();
			localSession.set(sqlSession);
		}
		return sqlSession;
	}

	/**
	 * 获取Mapper <br>
	 * 使用该方法来实现接口调用
	 * 
	 * @param type
	 * @param <T>
	 * @return 接口方法
	 */
	public static <T> T getMapper(Class<T> type) {
		SqlSession sqlSession = getSqlSession();
		if (sqlSession == null) {
			return (T) null;
		}
		return (T) sqlSession.getMapper(type);
	}

	/**
	 * 关闭Session
	 */
	public static void closeSession() {
		if (sqlSessionFactory != null) {
			SqlSession sqlSession = getSqlSession(false);
			if (sqlSession != null) {
				/**
				 * mybatis不自动提交
				 * 缺少提交，补充上
				 */
				sqlSession.commit();
				sqlSession.close();
				// 移出session
				localSession.remove();
				logger.debug("Mybatis SqlSession - 关闭");
			}
		}
	}

	/**
	 * 回滚
	 */
	public static void rollback() {
		if (sqlSessionFactory != null) {
			SqlSession sqlSession = getSqlSession(false);
			if (sqlSession != null) {
				sqlSession.rollback();
				logger.debug("Mybatis SqlSession - 回滚");
			}
		}
	}

	@Override
	public void destroy() {

	}
}
