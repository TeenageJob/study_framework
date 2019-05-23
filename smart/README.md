框架部分：

    静态方法：
        工具类：
          ArrayUtil：数组操作工具
          CastUtil：转型操作工具
          ClassUtil：类操作工具
          CodecUtil：编码与解码操作工具
          CollectionUtil：集合操作工具
          DateUtil：日期操作工具
          FileUtil：文件操作工具类
          JsonUtil：JSON操作工具类
          MapUtil：映射操作工具类
          ObjectUtil：对象操作工具类
          PropsUtil：属性文件操作工具类
          StreamUtil：流操作工具类
          StringUtil：字符串操作工具类
          WebUtil：Web 操作工具类
    
      助手类：
          ConfigHelper：获取属性文件中的属性值
    
    入口：ContainerListener.java
    1.获取ServletContext
    2.加载相关类
        类加载顺序：
        org.smart.framework.dao.DatabaseHelper：封装数据库相关操作
            org.smart.framework.dao.DatabaseHelper
            org.smart.framework.ds.impl.DefaultDataSourceFactory：默认数据源工厂
            org.smart.framework.dao.impl.DefaultDataAccessor：默认数据访问器
        org.smart.framework.orm.EntityHelper：初始化 Entity 结构
            org.smart.framework.orm.EntityHelper
            org.smart.framework.core.impl.DefaultClassScanner：默认类扫描器
            扫描用户创建类(Entity Service Action)
        org.smart.framework.mvc.ActionHelper：初始化 Action 配置
            org.smart.framework.mvc.ActionHelper
            扫描用户创建类(Entity Service Action)
        org.smart.framework.ioc.BeanHelper：初始化相关 Bean 类
            org.smart.framework.ioc.BeanHelper
            扫描用户创建类(Entity Service Action)
        org.smart.framework.aop.AopHelper：初始化 AOP 框架
            org.smart.framework.aop.AopHelper
            扫描用户创建类(Entity Service Action)
        org.smart.framework.ioc.IocHelper：初始化 IOC 容器
            org.smart.framework.ioc.IocHelper
            扫描用户创建类(Entity Service Action)
        org.smart.framework.plugin.PluginHelper：初始化插件
            org.smart.framework.plugin.PluginHelper
            org.smart.framework.mvc.impl.DefaultHandlerMapping：默认处理器映射
            org.smart.framework.mvc.impl.DefaultHandlerInvoker：默认 Handler 调用器
            org.smart.framework.mvc.impl.DefaultViewResolver：默认视图解析器
            org.smart.framework.mvc.impl.DefaultHandlerExceptionResolver：默认 Handler 异常解析器
    3.添加Servlet映射
        1.映射静态资源
        2.映射JSP资源
    4.注册WebPlugin
    
    
    
      InstanceFactory：实例工厂
    
    接口：
        FrameworkConstant：基础信息
    辅助类：
        HelperLoader：加载相应的 Helper 类
    
    模块：
      AOP:
        Helper：AopHelper(初始化AOP框架)
        Annotation：Aspect pkg(包名) cls(类名) annotation(注解)
                    AspectOrder value(顺序)
        Interface：Proxy  doProxy(执行链式代理)
        Abstract:AspectProxy(切面代理)
        class：ProxyChain(代理链)
               ProxyManager(代理管理器)
    
      CORE：
        Helper：ClassHelper(根据条件获取相关类) ConfigHelper(获取属性文件中的属性值)
        Annotation:
        Interface:ClassScanner(类扫描器)
        Abstract:BaseBean(提供 Bean 类的基础特性) AnnotationClassTemplate(用于获取注解类的模板类)
                 ClassTemplate(用于获取类的模板类) SupperClassTemplate(用于获取子类的模板类)
        class:InitializationError(初始化错误)  DefaultClassScanner(默认类扫描器)
    
      DAO:
        Helper:DatabaseHelper(封装数据库相关操作) SqlHelper(封装 SQL 语句相关操作)
        Interface:DataAccessor(数据访问器)
        Annotation:
        Abstract:
        class:DefaultDataAccessor(默认数据访问器:基于 Apache Commons DbUtils 实现) Pager<T>(分页对象)
    
      DS:
        Helper:
        Interface:DataSourceFactory(数据源工厂) 
        Annotation:
        Abstract:AbstractDataSourceFactory<T extends DataSource>(抽象数据源工厂) 
                 DefaultDataSourceFactory(默认数据源工厂:基于 Apache Commons DBCP 实现)
    
      IOC:
        Helper:BeanHelper(初始化相关 Bean 类) IocHelper(初始化 IOC 容器)
        Interface:
        Annotation:Bean(定义需要 IOC 容器管理的 Bean 类)
                   Impl(指定接口的实现类) value(要继承的类)
                   Inject(依赖注入)
        Abstract：
        class:
    
      ORM:
        Helper:EntityHelper(初始化 Entity 结构)
        Interface:
        Annotation:Column(列) value(列名) 
                   Entity(实体)
                   Table(表) value(表名)
        Abstract:
        class：
      MVC:
        ContainerListener(容器监听器)
        DispatcherServle(控制器)
        Hepler：ActionHelper(初始化 Action 配置) UploadHelper(封装文件上传相关操作)
        Annotation:Action(定义 Action 类)
                   Request(定义请求):
                                      Get(定义 GET 请求) value(路径)
                                      Post(定义 POST 请求) value(路径)
                                      Put(定义 PUT 请求) value(路径)
                                      Delete(定义 DELETE 请求) value(路径)
        Interface:HandlerExceptionResolver(Handler 异常解析器)
                  HandlerInvoker(Handler 调用器)
                  HandlerMapping(处理器映射)
                  ViewResolver(视图解析器)
        Abstract:
        class:DataContext(数据上下文) Handler(封装 Action 方法相关信息) Requester(封装 Request 对象相关信息)
              Multipart(封装文件上传对象相关属性) Multiparts(封装批量文件上传对象) Params(封装请求参数)
              Result(封装返回数据) View(封装视图对象)
              AuthcException(认证异常（当非法访问时抛出）) AuthzException(授权异常（当权限无效时抛出）)
              UploadException(上传异常（当文件上传失败时抛出）)
              DefaultHandlerExceptionResolver(默认 Handler 异常解析器)
              DefaultHandlerInvoker(默认 Handler 调用器) DefaultHandlerMapping(默认处理器映射)
              DefaultViewResolver(默认视图解析器)
    
      TX:
        Helper:
        Annotation:Service(定义 Service 类) Transaction(定义需要事务控制的方法)
        Interface:
        Abstract:
        class:TransactionProxy(事务代理)
    
      Test:
        Helper:
        Annotation:TestOrder(定义测试用例顺序) value(顺序值)
        Interface：
        Abstract:
        class:OrderedRunner(使测试用例可按顺序执行)
    
      PLUGIN:
        Helper:PluginHelper(初始化插件)
        Annotation:
        Interface:Plugin(插件接口)
        Abstract:PluginProxy(插件代理) 
                 WebPlugin(基于 Web 的插件抽象实现，拥有 Plugin 接口的所有功能:可在子类中注册 Servlet、Filter、Listener 等)
                 
业务部分：
    
   
      
