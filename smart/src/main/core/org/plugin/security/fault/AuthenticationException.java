package org.plugin.security.fault;

import org.apache.shiro.ShiroException;

/**
 * 认证异常
 * 
 * @author TY
 * @Time 2017年11月20日 下午4:10:43
 * @since 1.0.0
 */
public class AuthenticationException extends ShiroException {

	/**
	 * create by ty on TY 
	 * <br>2017年12月13日 下午2:55:44
	 */
	private static final long serialVersionUID = -8784939515793490433L;

	public AuthenticationException() {
		super();
	}
	
	public AuthenticationException(String message){
		super(message);
	}
	
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationException(Throwable cause) {
		super(cause);
	}

	public String getName() {
		return getClass().getSimpleName();
	}
}
