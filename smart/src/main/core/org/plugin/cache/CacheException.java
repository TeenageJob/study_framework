package org.plugin.cache;

public class CacheException extends RuntimeException {

    /**
	 * create by ty on TY 2017年11月10日 下午2:19:47
	 */
	private static final long serialVersionUID = 7611396249400871051L;

	public CacheException() {
        super();
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }
}
