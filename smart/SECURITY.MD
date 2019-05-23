类型		标签							属性						功能 	
用户		<security:user>				无				判断当前用户是否已登录（已认证 或 已记住）

		<security:guest>			无				判断当前用户是否未登录（为游客身份）

		<security:authenticated>	无				判断当前用户是否已认证

		<security:notAuthenticated>	无				判断当前用户是否未认证

		<security:principal>		type、property、defaultValue	显示当前用户的相关属性
角色		<security:hasRole>			name			判断当前用户是否拥有某种角色

		<security:lacksRole>		name			判断当前用户是否缺少某种角色

		<security:hasAnyRoles>		name	判断当前用户是否拥有其中某一种角色（逗号分隔，或的关系）

		<security:hasAllRoles>		name	判断当前用户是否拥有其中所有的角色（逗号分隔，与的关系）
权限		<security:hasPermission>	name	判断当前用户是否拥有某种权限

		<security:lacksPermission>	name	判断当前用户是否缺少某种权限

		<security:hasAnyPermissions>name	判断当前用户是否拥有其中某一种权限（逗号分隔，或的关系）

		<security:hasAllPermissions>name	判断当前用户是否拥有其中所有的权限（逗号分隔，与的关系）
		
		
配置项 security.realms种类   相关配置项
jdbc					security.jdbc.authc_query
						security.jdbc.roles_query
						security.jdbc.perms_query
ad						security.ad.url
						security.ad.system_username
						security.ad.system_password
						security.ad.search_base
custom					security.custom.class