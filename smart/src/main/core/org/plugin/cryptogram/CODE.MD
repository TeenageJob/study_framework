1.生成keyStroe文件
keytool -genkey -validity 365 -alias cas -keyalg RSA -keystore D:\cas\ssl\ty.keystore
-genkey表示生成密钥 
-validity指定证书有效期，这里是36000天
-alias指定别名
-keyalg指定算法
-keystore指定存储位置
2.生成自签名证书
keytool -export -keystore D:\cas\ssl\ty.keystore -alias cas -file D:\cas\ssl\cas.cer -rfc
-export指定为导出操作 
-keystore指定keystore文件
-alias指定导出keystore文件中的别名
-file指向导出路径
-rfc以文本格式输出，也就是以BASE64编码输出
3.将证书导入到我们的密钥库
keytool -import -alias cas -file D:\cas\ssl\cas.cer -keystore "%JAVA_HOME%\jre\lib\security\cacerts"
-import表示导入 
-alias指定别名
-file指定算法  
-keystore指定存储位置
4.修改hosts文件
5.配置tomcat
<Connector  
	..  
 keystoreFile="D:/cas/ssl/cas.keystore"  
    		   keystorePass="changeit"
    .. />  
注意:clientAuth="false"测试阶段，置为false，正式使用时建议使用true