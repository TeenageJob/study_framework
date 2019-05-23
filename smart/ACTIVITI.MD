工作流引擎
     1.定义流程，也就是给我们提供某种规范来定义规则，以及如何定义一个流程的这种规范，同事我们可以根据工作流引擎提供的相关概念来定义更为复杂的流程，这就是工作流引擎做的第一件事叫做定义流程。
      2.执行流程，也就是工作流引擎需要解释这个规则，还要负责流程，它相当于流程的调度者，监控每个流程的执行情况，并将流程操作发往下一步，或者根据条件休眠或终止流程的这么一个过程就叫做执行流程。
  
  序号  技术组成                  Activiti                            jBPM5
  1     数据库持久层ORM           MyBatis3                            Hibernate3
  2     持久化标准                无                                  JPA规范
  3     事务管理                  MyBatis机制/Spring事务控制          Bitronix，基于JTA事务管理
  4     数据库连接方式            Jdbc/DataSource                     Jdbc/DataSource
  5     支持数据库                Oracle、SQL Server、MySQL等         Oracle、SQL Server、MySQL等多数数据库
                                  多数数据库  
  6     设计模式                  Command模式、观察者模式等           无
  7     内部服务通讯              Service间通过API调用                基于Apache Mina异步通讯
  8     集成接口                  SOAP、Mule、RESTful                 消息通讯
  9     支持的流程格式            BPMN2、xPDL、jPDL等                 目前仅只支持BPMN2 xml
  10    引擎核心                  PVM（流程虚拟机）                   Drools
  11    技术前身                  jBPM3、jBPM4                        Drools Flow
  12    所属公司                  Alfresco                            jBoss.org
  
  - Activiti 使用到的表都是 ACT_开头的。 
  - ACT_RE_*:流程定义存储。 
  - ACT_RU_*:流程执行记录,记录流程启动到结束的所有动作,流程结束后会清除相关记录。 
  - ACT_ID_*:用户记录,流程中使用到的用户和组。 
  - ACT_HI_*:流程执行的历史记录。
  
  使用到的表:
  
  ACT_GE_BYTEARRAY:流程部署的数据。二进制数据表
  ACT_GE_PROPERTY:通用设置。 属性数据表存储整个流程引擎级别的数据,初始化表结构时，会默认插入三条记录
  ACT_HI_ACTINST:流程活动的实例，历史节点表
  ACT_HI_ATTACHMENT: 历史附件表
  ACT_HI_COMMENT:历史意见表
  ACT_HI_DETAIL: 历史详情表，提供历史变量的查询
  ACT_HI_PROCINST:历史流程实例。
  ACT_HI_TASKINST:历史任务实例。
  ACT_ID_GROUP:用户组。
  ACT_ID_INFO:用户扩展信息表
  ACT_ID_MEMBERSHIP: 用户组与用户对应信息表
  ACT_ID_USER:用户。
  ACT_RE_DEPLOYMENT:部署记录。
  ACT_RE_PROCDEF:流程定义数据表。
  ACT_RU_EXECUTION:流程执行记录。
  ACT_RU_IDENTITYLINK:运行时的流程人员表，主要储存任务节点与参与者的相关信息
  ACT_RU_JOB: 定时任务数据表
  ACT_RU_TASK:执行的任务节点记录。
  ACT_RU_VARIABLE:执行中的变量记录。
  
  字段含义：
  REV_ 版本号
  
  
  xml:
  定义了一个id为processEngineConfiguration的bean对象,其中processEngineConfiguration即为Activiti默认的引擎配置管理器名称
  databaseSchemaUpdate用来声明数据库脚本的更新策略,和bibernate的机制类似。取值如下： 
  false:什么都不做
  true:当Activiti的表不存在的情况下,自动创建表;当Activiti的jar文件定义中的定义版本号与数据库中记录的版本号不一致的时候会自动执行相应的升级脚本，并且会记录升级过程。
  create-drop:创建引擎时执行初始化脚本,引擎销毁时,执行删除数据库脚本的操作
  jobExecutorActivate:用来设置是否启用作业执行功能,默认为false。设置为true后,引擎会不间断的刷新数据库的作业表,检查是否存在需要执行的作业,有则触发作业的执行。作业的来源有多重,例如各种时间事件或异步任务执行。
  history:用来设置记录历史的级别,默认为audit.支持以下几种类型： 
      none:不保存任何历史记录,可以提高系统性能。
      activity:保存所有的流程实例,任务,活动信息
      audit:也是activiti的默认级别,保存所有的流程实例,任务,活动,表单属性.
      full:是最完成的历史记录,除了包含audit级别的信息以外,还保存详细,例如流程变量,表单属性
  
  ProcessEngine类，一般称为流程引擎类，没错，这个流程引擎就是我们上一篇文章中提到的流程引擎，它是activiti中最核心的类，
  并且这个类是线程安全的，所有的线程和请求都可以使用同一个ProcessEngine对象，其它常用类几乎也都是由它而来的。
  
  得到ProcessEngine对象：
    方式1：使用classpath根目录下的默认配置文件jbpm.cfg.xml创建一个单例的ProcessEngine
    ProcessEngineprocessEngine = ProcessEngines.getDefaultProcessEngine();
    
    方式2：指定其他位置:配置文件，如src根目录config包下的my-jbpm-cfg.xml。
    ProcessEngineprocessEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(  
    "config/my-jbpm-cfg.xml").buildProcessEngine();  
   
  得到各个Service
    RepositoryService是管理流程定义的仓库服务的接口。
    RepositoryServicerepositoryService = processEngine.getRepositoryService();  
    
    RuntimeService是activiti的流程执行服务类。可以从这个服务类中获取很多关于流程执行相关的信息，如执行管理，包括启动、推进、删除流程实例等操作。
    RuntimeServiceruntimeService = processEngine.getRuntimeService();  
    
    TaskService是activiti的任务服务类。可以从这个类中获取任务的信息。
    TaskServicetaskservice = processEngine.getTaskService();  
    
    HistoryService 是activiti的查询历史信息的类。在一个流程执行完成后，这个对象为我们提供查询历史信息。
    HistoryServicehistoryService = processEngine.getHistoryService();  
    
    
    
1)先获取流程引擎对象：在创建时会自动加载classpath下的activiti.cfg.xml

    2)通过获取的流程引擎对象，通过流程引擎对象获取一个RepositoryService对象（仓库对象）

    3)由仓库的服务对象产生一个部署对象配置对象，用来封装部署操作的相关配置

    4)这是一个链式编程，在部署配置对象中设置显示名字，上传流程定义规则文件

    5)向数据库表中存放流程定义的规则信息

这些表都是跟部署对象和流程定义相关的表：

    act_re_deployment存放流程定义的显示名和部署时间，每部署一次增加一条记录；

    act_re_procdef（存放流程定义的属性信息，部署每个新的流程定义都会在这张表中增加一条记录，需要注意一下的当流程定义的key相同的情况下，使用的是版本升级；

    act_ge_bytearray存储流程定义相关的部署信息。即流程定义文档的存放地。每部署一次就会增加两条记录，一条是关于bpmn规则文件的，一条是图片的（如果部署时只指定了bpmn一个文件，activiti会在部署时解析bpmn文件内容自动生成流程图）。两个文件不是很大，都是以二进制形式存储在数据库中。
   


流程引擎设计思路：
   1、页面初始化时，将业务功能的service、页面的引擎模板传入页面中
   2、点击保存、action接受数据、然后调用流程引擎的方法，走流程{
            1、获取业务id
            2、流程启动实例并记录数据
            3、调用service的saveYw方法
      }
   3、查询代办任务
   4、审核任务
        1、审核通过：调用checkYw方法
        2、审核未通过：调用rollBack方法
        3、撤销任务：调用revocateYw方法