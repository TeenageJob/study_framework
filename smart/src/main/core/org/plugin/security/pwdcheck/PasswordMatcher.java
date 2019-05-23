package org.plugin.security.pwdcheck;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.HashingPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Hash;
import org.plugin.cache.ehcache.EhcacheCacheManager;
import org.plugin.cache.smart.Cache;
import org.plugin.cache.smart.SmartCacheManager;
import org.plugin.security.SmartSecurity;
import org.plugin.security.fault.ExcessiveAttemptsException;
import org.smart.framework.core.ConfigHelper;

/**
 * 密码匹配器 <br>
 * 限制登录次数
 * 
 * @author TY
 * @Time 2017年12月13日 下午8:19:26
 * @since 1.0.0
 */
public class PasswordMatcher implements CredentialsMatcher {

	private final SmartSecurity smartSecurity;
	
	private PasswordService passwordService;

	private Cache<String, AtomicInteger> spasswordRetryCache;

	public PasswordMatcher(SmartSecurity smartSecurity) {
		// Ehcache
		SmartCacheManager smartCacheManager = new EhcacheCacheManager();
		spasswordRetryCache = smartCacheManager.getCache("passwordRetryCache");
		this.smartSecurity=smartSecurity;
		this.passwordService = new DefaultPasswordService();
	}

	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		int number = Integer.parseInt(ConfigHelper.getString("smart.plugin.security.max.falut.number"));
		String username = (String) token.getPrincipal();
		AtomicInteger element = (AtomicInteger) spasswordRetryCache.get(username);
		// retry count + 1
		if (element == null) {
			spasswordRetryCache.put(username, new AtomicInteger(0));
		}
		element = (AtomicInteger) spasswordRetryCache.get(username);

		if (element.incrementAndGet() > number) {
			// if retry count > 5 throw
			// 锁住用户
			smartSecurity.lockUser(username);
			throw new ExcessiveAttemptsException();
		}

		PasswordService service = ensurePasswordService();

		Object submittedPassword = getSubmittedPassword(token);
		Object storedCredentials = getStoredPassword(info);

		assertStoredCredentialsType(storedCredentials);
		boolean flag = false;
		if (storedCredentials instanceof Hash) {
			Hash hashedPassword = (Hash) storedCredentials;
			HashingPasswordService hashingService = assertHashingPasswordService(service);
			flag = hashingService.passwordsMatch(submittedPassword, hashedPassword);
			if (flag)
				spasswordRetryCache.remove(username);
			return flag;
		}
		// otherwise they are a String (asserted in the
		// 'assertStoredCredentialsType' method call above):
		String formatted = (String) storedCredentials;
		flag = passwordService.passwordsMatch(submittedPassword, formatted);
		if (flag)
			spasswordRetryCache.remove(username);
		return flag;
	}

	private HashingPasswordService assertHashingPasswordService(PasswordService service) {
		if (service instanceof HashingPasswordService) {
			return (HashingPasswordService) service;
		}
		String msg = "AuthenticationInfo's stored credentials are a Hash instance, but the "
				+ "configured passwordService is not a " + HashingPasswordService.class.getName()
				+ " instance.  This is required to perform Hash " + "object password comparisons.";
		throw new IllegalStateException(msg);
	}

	private PasswordService ensurePasswordService() {
		PasswordService service = getPasswordService();
		if (service == null) {
			String msg = "Required PasswordService has not been configured.";
			throw new IllegalStateException(msg);
		}
		return service;
	}

	protected Object getSubmittedPassword(AuthenticationToken token) {
		return token != null ? token.getCredentials() : null;
	}

	private void assertStoredCredentialsType(Object credentials) {
		if (credentials instanceof String || credentials instanceof Hash) {
			return;
		}

		String msg = "Stored account credentials are expected to be either a " + Hash.class.getName()
				+ " instance or a formatted hash String.";
		throw new IllegalArgumentException(msg);
	}

	protected Object getStoredPassword(AuthenticationInfo storedAccountInfo) {
		Object stored = storedAccountInfo != null ? storedAccountInfo.getCredentials() : null;
		// fix for https://issues.apache.org/jira/browse/SHIRO-363
		if (stored instanceof char[]) {
			stored = new String((char[]) stored);
		}
		return stored;
	}

	public PasswordService getPasswordService() {
		return passwordService;
	}

	public void setPasswordService(PasswordService passwordService) {
		this.passwordService = passwordService;
	}
}
