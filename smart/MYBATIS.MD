#以下内容中带有两个井（）号的为说明信息，带有一个（）号的为可配置选项
#这些配置信息都应该写在smart.properties中
#包扫描只能针对使用Mybatis注解的方法,如使用@Select注解的方法
smart.plugin.mybatis.pk=org.smart.sample.mapper
#推荐的方式,推荐使用xml形式,多个xml使用逗号（,）隔开，支持文件夹形式(自动扫描文件夹下所有xml).
#示例：/mapper,/sys/UserMapper.xml,/sys/RoleMapper.xml
smart.plugin.mybatis.mapper=/mapper/Mapper.xml
#Mybatis - 自动控制session注解，如果想让系统自动处理session的关闭和异常回滚需要用到@MybatisSession注解
#只需要在需要使用的方法上写@MybatisSession注解即可
#mybatis.session.auto - 默认为false，即只有使用注解才会自动处理Mybatis的Session
#-当设置为true的时候，会对所有@Service类的方法进行自动Session处理，即使在不需要使用Mybatis的地方也会触发Session的自动处理，因而强烈不推荐使用该方法
mybatis.session.auto=false
#Mybatis - 别名配置
#包别名mybatis.aliases.package - 自动使用类名
#如下两个示例中pk1,pk2并无意义，只要不重复即可
mybatis.aliases.package.pk1=org.smart4j.sample.entity
mybatis.aliases.package.pk2=org.smart4j.sample.bean
#类别名mybatis.aliases.name - 使用name后面的名字作为别名
#如下两个示例中Pro代表Product，Ur代表User
mybatis.aliases.name.Pro=org.smart4j.sample.entity.Product
mybatis.aliases.name.Ur=org.smart4j.sample.entity.User
#Mybatis - 日志组件
#可选值 SLF4J | LOG4J | LOG4J2 | JDK_LOGGING | COMMONS_LOGGING | STDOUT_LOGGING | NO_LOGGING
#如果不设置该参数，Mybatis 自动按照如下顺序进行检查:
#SLF4J
#Apache=Commons Logging
#Log4j 2
#Log4j
#JDK logging
#一般情况下，使用Log4j的时候如果不输出日志，请将这里设置为LOG4J
#如果需要配置自定义日志,请写日志类的完整路径
mybatis.logImpl=LOG4J
#Mybatis - 插件 - 分页插件示例
myabtis.plugin.pagehelper=org.smart.plugin.mybatis.pagination.PageHelper
myabtis.plugin.pagehelper.dialect=mysql
myabtis.plugin.pagehelper.offsetAsPageNum=true
myabtis.plugin.pagehelper.rowBoundsWithCount=true
