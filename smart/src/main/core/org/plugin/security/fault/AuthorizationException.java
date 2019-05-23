package org.plugin.security.fault;

import org.apache.shiro.ShiroException;

/**
 * 授权认证异常
 * 
 * @author TY
 * @Time 2017年11月20日 下午4:30:27
 * @since 1.0.0
 */
public class AuthorizationException extends ShiroException{

	/**
	 * create by ty on TY 
	 * <br>2017年12月13日 下午2:55:35
	 */
	private static final long serialVersionUID = 4149860839955585787L;

	public AuthorizationException() {
        super();
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(Throwable cause) {
        super(cause);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
