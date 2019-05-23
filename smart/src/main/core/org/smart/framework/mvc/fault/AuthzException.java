package org.smart.framework.mvc.fault;

/**
 * 授权异常（当权限无效时抛出）
 *
 * @author TY
 * @Time 2017年9月20日 下午9:39:49
 * @since 1.0.0
 */
public class AuthzException extends RuntimeException {

    /**
	 * create by ty on TY 2017年11月10日 下午2:16:16
	 */
	private static final long serialVersionUID = 3688799171421663798L;

	public AuthzException() {
        super();
    }

    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}
