第一步检查jdk是不是javaSE
1.创建服务器：CAS
1）.将cas-server-webapp-3.5.2.war部署到tomcat
2.创建CAS密钥库
1).生成密钥对
	方法1：keytool -genkeypair -alias cas -keyalg RSA -storepass changeit
	为了简化操作，建议 keystore 与 keypair 的密码相同，且均为 changeit
	默认生成当前目录，win8 默认的用户目录为 C:\Users\ 用户名
	查看 keypair:keytool -list -storepass changeit
	删除 keypair:keytool -delete -alias cas -storepass changeit
2).从 keystore 中导出证书
	keytool -exportcert -alias cas -file cas.crt -storepass changeit
	生成的证书文件为 cas.crt，位于运行该命令所在的当前目录下
3).导入证书到 JVM 中
	keytool -importcert -alias cas -file cas.crt -keystore "%JAVA_HOME%\jre\lib\security\cacerts" -storepass changeit -noprompt
3.使Tomcat支持HTTPS
1).打开 Tomcat 的 conf/server.xml 文件
	SSLEngine 改为 off，默认为 on。
    <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
           maxThreads="150" scheme="https" secure="true"
           clientAuth="false" sslProtocol="TLS" />
   	 禁用 HTTP 8080 端口 ？？？，开启 HTTPS 8443 端口，禁用 AJP 8009 端口
方法2：生成数字证书：
keytool -genkey -keystore "D:\computersoftware\SSL\localhost.keystore" -alias localhost -keyalg RSA
136078
136078
tianyuan
helloworld
helloworld
cd
cd
cn
y
136078
136078

tomcat 8.0一下版本
<Connector SSLEnabled="true" clientAuth="false" maxThreads="150"
			port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
			scheme="https" secure="true" sslProtocol="TLS" 
			keystoreFile="${catalina.home}/bin/localhost.keystore" keystorePass="136078"
			/>



https://github.com/apereo/cas-overlay-template

JDK 1.8

修改cas-overlay-template-master\src\main\webapp\WEB-INF\spring-configuration\propertyFileConfigurer.xml文件中cas.properties的路径

keytool -genkeypair -keyalg RSA -validity 730 -keystore server.jks -alias server -dname "cn=server" -keypass changeit -storepass changeit

修改cas-overlay-template-master\etc\jetty\jetty-ssl.xml文件中keystore的位置



CAS 生成密钥对
keytool -genkeypair -validity 3650 -keyalg RSA -alias cas -keystore server.jks -dname "cn=server" -keypass changeit -storepass changeit
导出服务器的证书
keytool -export -rfc -keystore server.jks -alias cas -file server.crt -storepass changeit
证书导入客户端密钥库
keytool -import -noprompt -trustcacerts -file server.crt -alias cas -keystore server.csr -storepass changeit

keytool -importcert -alias cas -file server.crt -keystore "%JAVA_HOME%\jre\lib\security\cacerts" -storepass changeit -noprompt

指定库位置/cas-client/src/main/resources/clientKeystore.jks
-Djavax.net.ssl.trustStore=D:/cas/cas-server/cas-client/src/main/resources/clientKeystore.jks -Djavax.net.ssl.trustStorePassword=changeit


keytool -genkeypair -validity 730 -keyalg RSA -alias cas -keystore thekeystore.jks -dname "cn=server" -keypass changeit -storepass changeit
导出服务器的证书
keytool -export -rfc -keystore thekeystore.jks -alias cas -file server.cer -storepass changeit
证书导入客户端密钥库
keytool -import -noprompt -trustcacerts -file server.cer -alias cas -keystore client.jks -storepass changeit

keytool -import -noprompt -trustcacerts -file server.cer -alias cas -keystore "%JAVA_HOME%\jre\lib\security\cacerts" -storepass changeit

keystoreFile="D:\cas\ssl\thekeystore.jks" keystorePass="changeit"

证书导入客户端密钥库

指定库位置
-Djavax.net.ssl.trustStore=D:\cas\ssl\client.jks -Djavax.net.ssl.trustStorePassword=changeit

keytool -genkeypair -alias tomcat -keyalg RSA -keypass 123456 -storepass 123456 -keystore cas.keystore


