package org.smart.framework.mvc.fault;

/**
 * 认证异常（当非法访问时抛出）
 *
 * @author TY
 * @Time 2017年9月20日 下午9:39:38
 * @since 1.0.0
 */
public class AuthcException extends RuntimeException {

    /**
	 * create by ty on TY 2017年11月10日 下午2:16:09
	 */
	private static final long serialVersionUID = 4563005000961337888L;

	public AuthcException() {
        super();
    }

    public AuthcException(String message) {
        super(message);
    }

    public AuthcException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthcException(Throwable cause) {
        super(cause);
    }
}
