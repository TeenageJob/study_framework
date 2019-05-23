使用须知：
	创建包结构：
                                             		org.mvc :为起始包结构
                                             		org.mvc.aop:为全局界面工作
                                             		org.mvc.shiro:为全局权限管理
                                             		org.mvc.**:某一服务
                                             		org.mvc.**.**_c:为前端服务  接受数据，封装数据到entity
                                             		org.mvc.**.**_s:为后台服务  处理数据，与数据库交互
                                             		org.mvc.mybatis.**:业务mybatis
                                             		org.mvc.mybatis.**.mapper:mybatis xml
		