package org.plugin.security.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.plugin.security.SmartSecurity;
import org.plugin.security.fault.AuthenticationException;
import org.plugin.security.fault.AuthorizationException;
import org.plugin.security.pwdcheck.PasswordMatcher;

/**
 * 基于 Smart 的自定义 Realm（需要实现 SmartSecurity 接口）
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:51:49
 * @since 1.0.0
 */
public class SmartCustomRealm extends AuthorizingRealm {

	private final SmartSecurity smartSecurity;

	/**
	 * 构造函数
	 * 
	 * @param smartSecurity
	 */
	public SmartCustomRealm(SmartSecurity smartSecurity) {
		this.smartSecurity = smartSecurity;
		super.setName("custom");
		super.setCredentialsMatcher(new PasswordMatcher(smartSecurity));
	}

	/**
	 * 获取身份验证相关信息
	 */
	@Override
	public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("参数 token 非法！");
		}
		// 获取账户
		String username = ((UsernamePasswordToken) token).getUsername();
		// 获取密码
		String password = smartSecurity.getPassword(username);

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
		// principals：身份，即主体的标识属性
		authenticationInfo.setPrincipals(new SimplePrincipalCollection(username, super.getName()));
		// credentials：证明 / 凭证，即只有主体知道的安全值，如密码 / 数字证书等。
		authenticationInfo.setCredentials(password);
		return authenticationInfo;
	}

	/**
	 * 获取授权信息
	 */
	@Override
	public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("参数 principals 非法！");
		}
		String username = (String) super.getAvailablePrincipal(principals);
		// 角色
		Set<String> roleNameSet = smartSecurity.getRoleNameSet(username);
		// 权限
		Set<String> permNameSet = new HashSet<String>();
		if (roleNameSet != null && roleNameSet.size() > 0) {
			for (String roleName : roleNameSet) {
				Set<String> currentPermNameSet = smartSecurity.getPermissionNameSet(roleName);
				permNameSet.addAll(currentPermNameSet);
			}
		}

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 设置角色
		authorizationInfo.setRoles(roleNameSet);
		// 设置权限
		authorizationInfo.setStringPermissions(permNameSet);
		return authorizationInfo;
	}
}
