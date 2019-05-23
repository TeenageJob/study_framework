package org.smart.framework.core.fault;

/**
 * 初始化错误
 *
 * @author TY
 * @Time 2017年9月20日 下午9:34:56
 * @since 1.0.0
 */
public class InitializationError extends Error {

    /**
	 * create by ty on TY 2017年11月10日 下午2:16:27
	 */
	private static final long serialVersionUID = -6777519863279632862L;

	public InitializationError() {
        super();
    }

    public InitializationError(String message) {
        super(message);
    }

    public InitializationError(String message, Throwable cause) {
        super(message, cause);
    }

    public InitializationError(Throwable cause) {
        super(cause);
    }
}
