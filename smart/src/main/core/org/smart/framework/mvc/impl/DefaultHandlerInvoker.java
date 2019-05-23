package org.smart.framework.mvc.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.InstanceFactory;
import org.smart.framework.ioc.BeanHelper;
import org.smart.framework.mvc.Handler;
import org.smart.framework.mvc.HandlerInvoker;
import org.smart.framework.mvc.UploadHelper;
import org.smart.framework.mvc.ViewResolver;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.util.CastUtil;
import org.smart.framework.util.ClassUtil;
import org.smart.framework.util.MapUtil;
import org.smart.framework.util.WebUtil;
import org.smart.plugin.common.web.pagebean.impl.PageBean;

/**
 * 默认 Handler 调用器
 *
 * @author TY
 * @Time 2017年9月19日 下午10:31:23
 * @since 1.0.0
 */
public class DefaultHandlerInvoker implements HandlerInvoker {

	private ViewResolver viewResolver = InstanceFactory.getViewResolver();

	@Override
	public void invokeHandler(HttpServletRequest request, HttpServletResponse response, Handler handler)
			throws Exception {
		// 获取 Action 相关信息
		Class<?> actionClass = handler.getActionClass();
		Method actionMethod = handler.getActionMethod();
		// 从 BeanHelper 中创建 Action 实例
		Object actionInstance = BeanHelper.getBean(actionClass);
		// 创建 Action 方法的参数列表
		List<Object> actionMethodParamList = createActionMethodParamList(request, handler);
		// 检查参数列表是否合法
		checkParamList(actionMethod, actionMethodParamList);
		// 添加必要的属性
		addAttribute(request);
		// 调用 Action 方法
		Object actionMethodResult = invokeActionMethod(actionMethod, actionInstance, actionMethodParamList);
		// 解析视图
		viewResolver.resolveView(request, response, actionMethodResult);
	}

	public List<Object> createActionMethodParamList(HttpServletRequest request, Handler handler) throws Exception {
		// 定义参数列表
		List<Object> paramList = new ArrayList<>();
		// 获取 Action 方法参数类型
		Class<?>[] actionParamTypes = handler.getActionMethod().getParameterTypes();
		// 添加路径参数列表（请求路径中的带占位符参数）
		paramList.addAll(createPathParamList(handler.getRequestPathMatcher(), actionParamTypes));
		// 分两种情况进行处理
		if (UploadHelper.isMultipart(request)) {// 通过文件上传形式
			// 添加 Multipart 请求参数列表
			paramList.addAll(UploadHelper.createMultipartParamList(request));
		} else {
			// 添加普通请求参数列表（包括 Query String 与 Form Data）
			Map<String, Object> requestParamMap = WebUtil.getRequestParamMap(request);
			if (MapUtil.isNotEmpty(requestParamMap)) {
				paramList.add(new Params(requestParamMap));
			}
		}
		// 返回参数列表
		return paramList;
	}

	private List<Object> createPathParamList(Matcher requestPathMatcher, Class<?>[] actionParamTypes) {
		// 定义参数列表
		List<Object> paramList = new ArrayList<>();
		// 遍历正则表达式中所匹配的组
		for (int i = 1, j = requestPathMatcher.groupCount(); i <= j; i++) {
			// 获取请求参数
			String param = requestPathMatcher.group(i);
			// 获取参数类型（支持四种类型：int/Integer、long/Long、double/Double、String）
			Class<?> paramType = actionParamTypes[i - 1];
			if (ClassUtil.isInt(paramType)) {
				paramList.add(CastUtil.castInt(param));
			} else if (ClassUtil.isLong(paramType)) {
				paramList.add(CastUtil.castLong(param));
			} else if (ClassUtil.isDouble(paramType)) {
				paramList.add(CastUtil.castDouble(param));
			} else if (ClassUtil.isString(paramType)) {
				paramList.add(param);
			}
		}
		// 返回参数列表
		return paramList;
	}

	private Object invokeActionMethod(Method actionMethod, Object actionInstance, List<Object> actionMethodParamList)
			throws IllegalAccessException, InvocationTargetException {
		// 通过反射调用 Action 方法
		actionMethod.setAccessible(true); // 取消类型安全检测（可提高反射性能）
		return actionMethod.invoke(actionInstance, actionMethodParamList.toArray());
	}

	private void checkParamList(Method actionMethod, List<Object> actionMethodParamList) {
		// 判断 Action 方法参数的个数是否匹配
		Class<?>[] actionMethodParameterTypes = actionMethod.getParameterTypes();
		/**
		 * 修改：获取的数据不应该必须在参数列上
		 * 
		 */
		if (actionMethodParameterTypes.length != actionMethodParamList.size()) {
			String message = String.format("因为参数个数不匹配，所以无法调用 Action 方法！原始参数个数：%d，实际参数个数：%d",
					actionMethodParameterTypes.length, actionMethodParamList.size());
			throw new RuntimeException(message);
		}
	}

	/**
	 * 添加一个request属性：request.setAttribute("_DATA_BEAN", new PageBean()); <br>
	 * 用于设置继承了BaseAction的Action能够使用 <br>
	 * 其方法，并将数据保存到该属性中。
	 *
	 */
	private void addAttribute(HttpServletRequest request) {
		// request.setAttribute("BASEPATH",
		// request.getServletContext().getContextPath());
		request.setAttribute("_DATA_BEAN", new PageBean());
	}
}
