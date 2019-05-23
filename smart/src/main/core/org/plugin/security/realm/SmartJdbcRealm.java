package org.plugin.security.realm;

import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.plugin.security.SecurityConfig;
import org.smart.framework.dao.DatabaseHelper;

/**
 * 基于 Smart 的 JDBC Realm（需要提供相关 smart.security.jdbc.* 配置项）
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:47:14
 * @since 1.0.0
 */
public class SmartJdbcRealm extends JdbcRealm {

	public SmartJdbcRealm() {
		super.setDataSource(DatabaseHelper.getDataSource());//设置JDBC
		super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());//
		super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
		super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
		super.setPermissionsLookupEnabled(true);
		super.setCredentialsMatcher(new PasswordMatcher());
	}
}
