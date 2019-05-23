重要信息：不要删除java security下的cacert文件，不要乱动它
cas服务器作用：登录并返回用户部分信息
	登录:直接登录，授权登录，验证码
第一步检查jdk是不是javaSE
配置cas相关信息
server.name=http://cas:8080
deployerConfigContext.xml 
<bean class="org.jasig.cas.authentication.handler.support.HttpBasedServiceCredentialsAuthenticationHandler"
                    p:httpClient-ref="httpClient" p:requireSecure="false" />
                    
ticketGrantingTicketCookieGenerator.xml
<bean id="ticketGrantingTicketCookieGenerator" class="org.jasig.cas.web.support.CookieRetrievingCookieGenerator"
        p:cookieSecure="false"
        p:cookieMaxAge="-1"
        p:cookieName="CASTGC"
        p:cookiePath="/cas" />
        
warnCookieGenerator.xml 
<bean id="warnCookieGenerator" class="org.jasig.cas.web.support.CookieRetrievingCookieGenerator"
        p:cookieSecure="false"
        p:cookieMaxAge="-1"
        p:cookieName="CASPRIVACY"
        p:cookiePath="/cas" /> 
        
        
术语：
Ø     Ticket-granting cookie(TGC) ：存放用户身份认证凭证的 cookie ，在浏览器和 CAS Server 间通讯时使用，并且只能基于安全通道传输（ Https ），是 CAS Server 用来明确用户身份的凭证；

Ø   Service ticket(ST) ：服务票据，服务的惟一标识码 , 由 CAS Server 发出（ Http 传送），通过客户端浏览器到达业务服务器端；一个特定的服务只能有一个惟一的 ST ；

Ø   Proxy-Granting ticket （ PGT ）：由 CAS Server 颁发给拥有 ST 凭证的服务， PGT 绑定一个用户的特定服务，使其拥有向 CAS Server 申请，获得 PT 的能力；

Ø   Proxy-Granting Ticket I Owe You （ PGTIOU ） : 作用是将通过凭证校验时的应答信息由 CAS Server 返回给 CAS Client ，同时，与该 PGTIOU 对应的 PGT 将通过回调链接传给 Web 应用。 Web 应用负责维护 PGTIOU 与 PGT 之 间映射关系的内容表；

Ø   Proxy Ticket (PT) ：是应用程序代理用户身份对目标程序进行访问的凭证；
Ø   Ticket Granting ticket(TGT) ：票据授权票据，由 KDC 的 AS 发放。即获取这样一张票据后，以后申请各种其他服务票据 (ST) 便不必再向 KDC 提交身份认证信息 (Credentials) ；

Ø   Authentication service(AS) --------- 认证用服务，索取 Credentials ，发放 TGT ；

Ø   Ticket-granting service (TGS) --------- 票据授权服务，索取 TGT ，发放 ST ；

Ø   KDC( Key Distribution Center ) ---------- 密钥发放中心；