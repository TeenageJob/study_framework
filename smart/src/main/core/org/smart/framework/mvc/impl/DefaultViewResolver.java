package org.smart.framework.mvc.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.FrameworkConstant;
import org.smart.framework.mvc.UploadHelper;
import org.smart.framework.mvc.ViewResolver;
import org.smart.framework.mvc.bean.Page;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.framework.util.ConstantUtil;
import org.smart.framework.util.MapUtil;
import org.smart.framework.util.ValidataUtil;
import org.smart.framework.util.WebUtil;

/**
 * 默认视图解析器
 *
 * @author TY
 * @Time 2017年9月20日 下午9:40:33
 * @since 1.0.0
 */
public class DefaultViewResolver implements ViewResolver {

    @Override
    public void resolveView(HttpServletRequest request, HttpServletResponse response, Object actionMethodResult) {
        if (actionMethodResult != null) {
            if (actionMethodResult instanceof Page) {
                return;
            }
            if (actionMethodResult instanceof String) {
                if(ValidataUtil.isEquals(actionMethodResult,FrameworkConstant.JSON)){
                    WebUtil.writeJSON(response);
                    return;
                }
                String path = "/www/" + actionMethodResult;
                WebUtil.writeJSON(response, path);
            } else if (actionMethodResult instanceof View) {// Action 返回值可为 View 或 Result
                // 若为 View，则需考虑两种视图类型（重定向 或 转发）
                View view = (View) actionMethodResult;
                if (view.isRedirect()) {
                    // 获取路径
                    String path = view.getPath();
                    /**
                     * 判断是否具有重定向标志
                     */
                    if (path.contains(ConstantUtil.REDIRECT)) {
                        path = FrameworkConstant.JSP_PATH + path.substring(path.indexOf(":") + 1);
                    }
                    // 重定向请求
                    WebUtil.redirectRequest(path, request, response);
                } else {
                    // 获取路径
                    String path = null;
                    if (view.getPath().contains(ConstantUtil.PAGE_POSTFIX_HTML)) {
                        path = FrameworkConstant.HTML_PATH + view.getPath();
                    } else {
                        path = FrameworkConstant.JSP_PATH + view.getPath();
                    }
                    // 初始化请求属性
                    Map<String, Object> data = view.getData();
                    if (MapUtil.isNotEmpty(data)) {
                        for (Map.Entry<String, Object> entry : data.entrySet()) {
                            request.setAttribute(entry.getKey(), entry.getValue());
                        }
                    }
                    // 转发请求
                    WebUtil.forwardRequest(path, request, response);
                }
            } else {
                // 若为 Result，则需考虑两种请求类型（文件上传 或 普通请求）
                Result result = (Result) actionMethodResult;
                if (UploadHelper.isMultipart(request)) {
                    // 对于 multipart 类型，说明是文件上传，需要转换为 HTML 格式并写入响应中
                    WebUtil.writeHTML(response, result);
                } else {
                    // 对于其它类型，统一转换为 JSON 格式并写入响应中
                    WebUtil.writeJSON(response, result);
                }
            }
        }
    }
}
