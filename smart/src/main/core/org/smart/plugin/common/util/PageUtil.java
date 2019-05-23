package org.smart.plugin.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.smart.framework.mvc.DataContext;
import org.smart.plugin.common.web.pagebean.impl.PageBean;

public class PageUtil {

    private final String MESSAGE_TYPE_ERROR = "error";
    private final String MESSAGE_TYPE_INFO = "info";
    private final String MESSAGE_TYPE_SUCCESS = "success";
    private final String MESSAGE_TYPE_WARM = "warm";

    /**
     * 设置弹窗
     * <p>
     * <br>create by on TY
     * 2017年12月8日 上午10:16:57
     *
     * @param message
     * @param type
     */
    public static void setMessage(String message, String... type) {
        try {
            HttpServletResponse response = DataContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            if (type.length > 0) {

            }
            response.getWriter().write("<script>alert('" + message + "');</script>");
            response.getWriter().flush();
        } catch (IOException e) {

        }

    }

    public static PageBean getPageBean() {
        return (PageBean) DataContext.getRequest().getAttribute("_DATA_BEAN");
    }

    public static String getPageJson() {
        PageBean pageBean = getPageBean();
        return pageBean.toJson();
    }
}
