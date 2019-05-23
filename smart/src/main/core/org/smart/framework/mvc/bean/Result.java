package org.smart.framework.mvc.bean;

import org.smart.framework.core.bean.BaseBean;

/**
 * 封装返回数据
 *
 * @author TY
 * @Time 2017年9月20日 下午9:39:18
 * @since 1.0.0
 */
public class Result extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:15:59
	 */
	private static final long serialVersionUID = -9100630168562735829L;
	private boolean success; // 成功标志
    private int error;       // 错误代码
    private Object data;     // 相关数据

    public Result(boolean success) {
        this.success = success;
    }

    public Result error(int error) {
        this.error = error;
        return this;
    }

    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}
