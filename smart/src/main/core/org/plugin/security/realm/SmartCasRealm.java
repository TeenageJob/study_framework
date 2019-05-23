package org.plugin.security.realm;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.plugin.security.SmartSecurity;
import org.plugin.security.fault.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartCasRealm extends CasRealm {

    private static String uname = "";

    private static final Logger logger = LoggerFactory.getLogger(SmartCasRealm.class);

    private final SmartSecurity smartSecurity;

    /**
     * 构造函数
     *
     * @param smartSecurity
     */
    public SmartCasRealm(SmartSecurity smartSecurity) {
        super();
        super.setName("custom");
        setCachingEnabled(true);// 启用缓存
        setAuthenticationCachingEnabled(true);// 启用身份验证缓存，即缓存 AuthenticationInfo
        // 信息;
        setAuthenticationCacheName("AuthenticationCache");// 缓存
        // AuthenticationInfo
        // 信息的缓存名称；
        setAuthorizationCachingEnabled(true);// 启用授权缓存，即缓存 AuthorizationInfo
        // 信息，默认 false；
        setAuthorizationCacheName("AuthorizationCache");// 缓存 AuthorizationInfo
        // 信息的缓存名称；
        this.smartSecurity = smartSecurity;
        setDefaultRoles("ROLE_USER");
        super.setCasServerUrlPrefix("https://server:8443/cas");
        super.setCasService("http://client/smart/common/login.do");
    }

    /**
     * 票据认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CasToken casToken = (CasToken) token;
        if (token == null) {
            return null;
        }

        String ticket = (String) casToken.getCredentials();
        TicketValidator ticketValidator = ensureTicketValidator();

        try {
            // contact CAS server to validate service ticket
            Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
            // get principal, user id and attributes
            AttributePrincipal casPrincipal = casAssertion.getPrincipal();
            String userId = casPrincipal.getName();
            logger.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}",
                    new Object[]{ticket, getCasServerUrlPrefix(), userId});

            Map<String, Object> attributes = casPrincipal.getAttributes();
            // refresh authentication token (user id + remember me)
            casToken.setUserId(userId);
            String rememberMeAttributeName = getRememberMeAttributeName();
            String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
            boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
            if (isRemembered) {
                casToken.setRememberMe(true);
            }
            // create simple authentication info
            List<Object> principals = CollectionUtils.asList(userId, attributes);
            PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());
            return new SimpleAuthenticationInfo(principalCollection, ticket);
        } catch (TicketValidationException e) {
            throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
        }
    }

    /**
     * 授权获取
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("参数 principals 非法！");
        }
        String username = (String) super.getAvailablePrincipal(principals);
        uname = username;
        // 角色
        Set<String> roleNameSet = smartSecurity.getRoleNameSet(username);
        // 权限
        Set<String> permNameSet = new HashSet<>();
        if (roleNameSet != null && roleNameSet.size() > 0) {
            for (String roleName : roleNameSet) {
                Set<String> currentPermNameSet = smartSecurity.getPermissionNameSet(roleName);
                permNameSet.addAll(currentPermNameSet);
            }
        }
        roleNameSet.add("ROLE_USER");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 设置角色
        authorizationInfo.setRoles(roleNameSet);
        // 设置权限
        authorizationInfo.setStringPermissions(permNameSet);
        return authorizationInfo;
    }

    @Override
    public CacheManager getCacheManager() {
        return super.getCacheManager();
    }

    public static String getUsername() {
        return uname;
    }


    
    
}
