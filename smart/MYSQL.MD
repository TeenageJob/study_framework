连接数据库url写法：
 

    无论是通过代码还是通过xml文件来创建工作流的表，里面都涉及到一个知识点就是mysql的url的写法，我们进行下小结：

 

    #autoReconnect当数据库连接丢失时是否自动连接，取值true/false 缺省为false



    #maxReconnects如果autoReconnect为true,此参数为重试次数，缺省为3次 



    #initialTimeout如果autoReconnect为true,此参数为重新连接前等待的秒数缺省为2



    #maxRows设置查询时返回的行数，0表示全部缺省为0



    #useUnicode是否使用unicode输出，true/false缺省为false



    #characterEncoding如果useUnicode,该参数制定encoding类型，建议使用utf8缺省为无



    #createDatabaseIfNotExist当JDBC连接指定数据库,如果此数据库不存在,此参数值为true时，则自动创建此数据库
    
    jdbc:mysql://localhost:3306/ourmysql?  
    createDatabaseIfNotExist=true&  
    amp;useUnicode=true&  
    amp;characterEncoding=utf8&  
    amp;autoReconnect=true&  
    amp;useLocalSessionState=true