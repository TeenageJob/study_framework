package org.plugin.security.fault;

/**
 * 登录异常
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:44:35
 * @since 1.0.0
 */
public class LoginException extends AuthorizationException {

	/**
	 * create by ty on TY 2017年11月10日 下午2:16:59
	 */
	private static final long serialVersionUID = 8817372089816219683L;

	public LoginException() {
		super();
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

	public String getName() {
		return getClass().getSimpleName();
	}
}
