登录表：3个
1：用户表 USER
        id username email password salt create_time last_login_time disabled lock
       用户信息表 user_information
        id username email phone operator operator_id operator_organzation
       密码管理表 user_question
       	id username question answer
2：用户-角色表 USER_ROLE
        id user_id role_id
3：角色表 ROLE
        id role description disabled
4：角色-资源表 ROLE_PARMISSION
        id role_id url_id
5：资源表 PARMISSION 资源控制在按钮粒度上
        id url description disabled

用户：all ok
角色：super_admin admin salesman user ROLE_USER（设定角色用于登录）
	super_admin:菜单管理、权限管理、开发管理、系统管理、通知管理、任务开发、、、
	admin：菜单管理、权限管理、开发管理、系统管理、通知管理、任务开发、、、
	salesman：业务办理、业务审核、通用业务、一卡通
	user：微信号
资源：all

主界面：
	角色对应业务标签，资源对应业务功能
	需要三张表：role_label  business_title business_url
	role_label:
		id role name tab_id span_class  
	business_title:
		id label_name name heading collapse title_class number_class 
	business_url:
		id title_name url url_name 
	1.导航栏
		普通用户：
			业务管理、业务审核、通用业务、一卡通
		管理员：
			菜单管理、权限管理、开发管理、系统管理、通知管理、任务开发、、、、
			
		通知、帮助提示、用户、退出
	2.侧栏

权限关系：用户->(多)角色->(多)资源
表单关系:用户->(多)角色->(多)菜单->(多)业务功能

掌握shiro缓存，使用缓存获取数据：
	使用ehcache储存shiro中获取到的角色和资源

将所有角色和资源在启动时加载到缓存中：redis
	/*角色和资源表结构不一样，所以不能直接添加到插件中。必须提供接口来实现实体类（角色，资源）的查询
	IRole,IPermission
	*/
	realm需要角色、资源
	表单需要获取角色对应菜单信息，菜单对应功能标题信息，功能标题对应业务功能信息
	
	添加一个启动项目，获取全部菜单，标题，业务
	获取全部角色去除重复菜单
	
url授权认证拦截：
	每一个url都必须拦截
	每一个url都必须有一个授权：角色：资源：功能
	
	