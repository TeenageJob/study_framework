package org.plugin.security.pwdcheck;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.smart.framework.core.ConfigHelper;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private Ehcache passwordRetryCache;
	
	public RetryLimitHashedCredentialsMatcher() {
		this.setHashAlgorithmName("md5");
		this.setHashIterations(2);
		this.setStoredCredentialsHexEncoded(true);
		CacheManager cacheManager = CacheManager
				.newInstance(CacheManager.class.getClassLoader().getResource("ehcache.xml"));
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		int number = Integer.parseInt(ConfigHelper.getString("smart.plugin.security.max.falut.number"));
		String username = (String) token.getPrincipal();
		// retry count + 1
		Element element = passwordRetryCache.get(username);
		if (element == null) {
			element = new Element(username, new AtomicInteger(0));
			passwordRetryCache.put(element);
		}
		AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
		if (retryCount.incrementAndGet() > number) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}

		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);
		}
		return matches;
	}

}
