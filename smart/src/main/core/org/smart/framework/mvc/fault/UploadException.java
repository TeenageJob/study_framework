package org.smart.framework.mvc.fault;

/**
 * 上传异常（当文件上传失败时抛出）
 *
 * @author TY
 * @Time 2017年9月20日 下午9:39:59
 * @since 1.0.0
 */
public class UploadException extends RuntimeException {

    /**
	 * create by ty on TY 2017年11月10日 下午2:16:20
	 */
	private static final long serialVersionUID = -5221865276372640893L;

	public UploadException() {
        super();
    }

    public UploadException(String message) {
        super(message);
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadException(Throwable cause) {
        super(cause);
    }
}
