package org.plugin.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.plugin.security.fault.LoginException;
import org.plugin.security.realm.SmartCasRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Security 助手类
 *
 * @author TY
 * @Time 2017年11月10日 下午4:42:03
 * @since 1.0.0
 */
public final class SecurityHelper {

    private static final Logger logger = LoggerFactory.getLogger(SecurityHelper.class);

    private static String username;


    // private static final PasswordService passwordService = new
    // DefaultPasswordService();

    /**
     * 登录
     */
    public static void login(String username, String password, boolean isRememberMe) {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            if (!currentUser.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                token.setRememberMe(isRememberMe);
                try {
                    currentUser.login(token);
                } catch (AuthenticationException e) {
                    logger.error("错误：登录失败！", e);
                    throw new LoginException(e);
                }
            }
        }
    }

    /**
     * 注销
     */
    public static void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            currentUser.logout();
        }
    }

    /**
     * 加密
     */
    public static String encrypt(String plaintext, String... salt) {
        for (String s : salt) {// 加盐密码
            return new Md5Hash(plaintext, s).toString();
        }
        return new Md5Hash(plaintext).toString();
        // return passwordService.encryptPassword(plaintext);
    }

    /**
     * 获取缓存中所有身份信息
     */
    public static Collection<String> getStringPermissions() {
        return getAuthorizationInfo().getStringPermissions();
    }

    private static AuthorizationInfo getAuthorizationInfo() {
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        SmartCasRealm smartCasRealm = (SmartCasRealm) securityManager.getRealms().iterator().next();
        Cache<Object, AuthorizationInfo> cacheAuthoriza = smartCasRealm.getAuthorizationCache();
        return cacheAuthoriza.get(cacheAuthoriza.keys().iterator().next());
    }

    /**
     * 获取缓存中所有授权信息
     */
    public static Collection<String> getRoles() {
        return getAuthorizationInfo().getRoles();
    }

    /**
     * 获取用户名
     */
    public static String getUsername() {
        return SmartCasRealm.getUsername();
    }

    /**
     * 添加角色
     *
     * @param paramMap
     * @return
     */
    public static boolean addRole(Map paramMap) {
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        smartSecurity.createRole(paramMap);
        return true;
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    public static boolean deleteRole(Long roleId) {
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        smartSecurity.deleteRole(roleId);
        return true;
    }

    /**
     * 添加用户角色关系
     *
     * @param paramMap
     * @return
     */
    public static boolean addUserRole(Map paramMap) {
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        smartSecurity.addUserRole(paramMap);
        return true;
    }

    /**
     * 删除用户角色关系
     *
     * @param paramMap
     * @return
     */
    public static boolean delUserRole(Map paramMap) {
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        smartSecurity.delUserRole(paramMap);
        return true;
    }
}
