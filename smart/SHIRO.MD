Shiro 可以帮助我们完成：认证、授权、加密、会话管理、与 Web 集成、缓存等
Authentication：身份认证/登录，验证用户是不是拥有相应的身份；
Authorization：授权，即权限验证，验证某个已认证的用户是否拥有某个权限；
Session Manager：会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的；
Cryptography：加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储；
Web Support：Web支持，可以非常容易的集成到Web环境；
Caching：缓存，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率；
Concurrency：shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去；
Testing：提供测试支持；
Run As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问；
Remember Me：记住我，这个是非常常见的功能，即一次登录后，下次再来的话不用登录了。

记住一点，Shiro不会去维护用户、维护权限；这些需要我们自己去设计/提供；然后通过相应的接口注入给Shiro即可。

Subject：主体，代表了当前“用户” 
SecurityManager：安全管理器； 
Realm：域

Authenticator的职责是验证用户帐号
public AuthenticationInfo authenticate(AuthenticationToken authenticationToken) throws AuthenticationException;
认证器，负责主体认证的，这是一个扩展点，如果用户觉得 Shiro 默认的不好，可以自定义实现；其需要认证策略（Authentication Strategy），即什么情况下算用户认证通过了；

Authrizer：授权器，或者访问控制器，用来决定主体是否有权限进行相应的操作；即控制着用户能访问应用中的哪些功能；
SessionManager：session管理器
CacheManager：缓存控制器
Cryptography：密码模块，Shiro 提高了一些常见的加密组件用于如密码加密 / 解密的

身份验证：
principals：身份
credentials：证明 / 凭证（密码）

Realm：
String getName(); //返回一个唯一的Realm名字
boolean supports(AuthenticationToken token); //判断此Realm是否支持此Token
AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
 throws AuthenticationException;  //根据Token获取认证信息
以后一般继承 AuthorizingRealm（授权）即可；其继承了 AuthenticatingRealm（即身份验证），而且也间接继承了 CachingRealm（带有缓存实现）。
三种方法获取角色，权限，用户
1.org.apache.shiro.realm.text.IniRealm：[users] 部分指定用户名 / 密码及其角色；[roles] 部分指定角色即权限信息；
2.org.apache.shiro.realm.text.PropertiesRealm：user.username=password,role1,role2 指定用户名 / 密码及其角色；role.role1=permission1,permission2 指定角色及权限信息；
3.org.apache.shiro.realm.jdbc.JdbcRealm： sql 查询

FirstSuccessfulStrategy：只要有一个 Realm 验证成功即可，只返回第一个 Realm 身份验证成功的认证信息，其他的忽略；
AtLeastOneSuccessfulStrategy：只要有一个 Realm 验证成功即可，和 FirstSuccessfulStrategy 不同，返回所有 Realm 身份验证成功的认证信息；
AllSuccessfulStrategy：所有 Realm 验证成功才算成功，且返回所有 Realm 身份验证成功的认证信息，如果有一个失败就失败了。

授权：
1.编程式  2.注解式  3.JSP/GSP 标签

角色
checkRole/checkRoles():拥有角色，判断为假的时候抛出UnauthorizedException 异常
hasRole():拥有角色
hasAllRoles()：拥有角色
hasRoles():拥有角色
资源：
isPermitted，isPermittedAll
checkPermission，checkPermissions：失败的情况下会抛出 UnauthorizedException 异常

字符串权限：
system:user:create,update,delete,view
system:user:update,system:user:delete
subject().checkPermissions("system:user:create,delete,update:view");
system:user:*
*:view
user:view:1
user:update,delete:1
user:*:1
user:auth:*
user:*:*

Authorizer 进行授权（访问控制）
PermissionResolver 用于解析权限字符串到 Permission 实例
RolePermissionResolver 用于根据角色解析相应的权限集合

BitPermission 用于实现位移方式的权限



推荐使用 AuthorizingRealm，因为： 
AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)：表示获取身份验证信息；
AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)：表示根据用户身份获取授权信息


INI 配置

对象名 = 全限定类名 相对于调用 public 无参构造器创建对象
对象名. 属性名 = 值 相当于调用 setter 方法设置常量值
对象名. 属性名 =$ 对象引用 相当于调用 setter 方法设置对象引用
authc:拦截
anno：不拦截
[users]
zhang=123,role1,role2
wang=123&nbsp; 

[roles]
role1=user:create,user:update
role2=*&nbsp;

[urls]
/admin/** = authc, roles[admin], perms["permission1"]

编码/加密


密码重试次数限制
  //获取配置文件
  CacheManager cacheManager = CacheManager.newInstance(CacheManager.class.getClassLoader().getResource("ehcache.xml"));
  //获取对象
  passwordRetryCache = cacheManager.getCache("passwordRetryCache");


拦截：
IniWebEnvironment


session:
DefaultSessionManager：DefaultSecurityManager 使用的默认实现，用于 JavaSE 环境；
ServletContainerSessionManager：DefaultWebSecurityManager 	使用的默认实现，用于 Web 环境，其直接使用 Servlet 容器的会话；
DefaultWebSessionManager：	用于 Web 环境的实现，可以替代 ServletContainerSessionManager，自己维护着会话，直接废弃了 Servlet 容器的会话管理。

替换 SecurityManager 默认的 SessionManager 可以在 ini 中配置
	sessionManager=org.apache.shiro.session.mgt.DefaultSessionManager
	securityManager.sessionManager=$sessionManager&nbsp;

	sessionManager=org.apache.shiro.web.session.mgt.ServletContainerSessionManager
	securityManager.sessionManager=$sessionManager

会话监听器用于监听会话创建、过期及停止事件:SessionListener
如果只想监听某一个事件，可以继承 SessionListenerAdapter 实现
会话存储
Shiro 提供 SessionDAO 用于会话的 CRUD

sessionIdCookie 是 sessionManager 创建会话 Cookie 的模板：
sessionIdCookie.name：设置 Cookie 名字，默认为 JSESSIONID；
sessionIdCookie.domain：设置 Cookie 的域名，默认空，即当前访问的域名；
sessionIdCookie.path：设置 Cookie 的路径，默认空，即存储在域名根下；
sessionIdCookie.maxAge：设置 Cookie 的过期时间，秒为单位，默认 - 1 表示关闭浏览器时过期 Cookie；
sessionIdCookie.httpOnly：如果设置为 true，则客户端不会暴露给客户端脚本代码，使用 HttpOnly cookie 有助于减少某些类型的跨站点脚本攻击；此特性需要实现了 Servlet 2.5 MR6 及以上版本的规范的 Servlet 容器支持；
sessionManager.sessionIdCookieEnabled：是否启用 / 禁用 Session Id Cookie，默认是启用的；如果禁用后将不会设置 Session Id Cookie，即默认使用了 Servlet 容器的 JSESSIONID，且通过 URL 重写（URL 中的 “;JSESSIONID=id” 部分）保存 Session Id。


会话验证
sessionValidationScheduler：会话验证调度器，sessionManager 默认就是使用 ExecutorServiceSessionValidationScheduler，其使用 JDK 的 ScheduledExecutorService 进行定期调度并验证会话是否过期；
sessionValidationScheduler.interval：设置调度时间间隔，单位毫秒，默认就是 1 小时；
sessionValidationScheduler.sessionManager：设置会话验证调度器进行会话验证时的会话管理器；
sessionManager.globalSessionTimeout：设置全局会话超时时间，默认 30 分钟，即如果 30 分钟内没有访问会话将过期；
sessionManager.sessionValidationSchedulerEnabled：是否开启会话验证器，默认是开启的；
sessionManager.sessionValidationScheduler：设置会话验证调度器，默认就是使用 ExecutorServiceSessionValidationScheduler。