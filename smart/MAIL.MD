JavaMail包中用于处理电子邮件的核心类是：Session，Message，Address，Authenticator，Store，Transport， Folder等
host:SMTP服务器地址
port:SMTP服务器端口号 默认25
auth:SMTP服务器是否需要用户认证   默认为false
user：SMTP默认的登陆用户名
from:默认邮件发送源地址
timeout:I/O连接超时时间

类型	服务器名称	服务器地址	SSL协议端口号	非SSL协议端口号
收件服务器	POP		pop.163.com		995		110
收件服务器	IMAP	imap.163.com	993		143
发件服务器	SMTP	smtp.163.com	465/994	25

收件服务器	POP: pop.qq.com   非ssl协议端口：110    ssl协议端口：995
收件服务器	IMAP：imap.qq.com  非ssl协议端口：143   ssl协议端口：993
发件服务器	SMTP: smtp.qq.com  非ssl协议端口：25     ssl协议端口：465/587

