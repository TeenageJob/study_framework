package org.smart.framework.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.smart.framework.core.ClassHelper;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.ConstantUtil;
import org.smart.framework.util.StringUtil;

/**
 * 初始化 Action 配置
 *
 * @author TY
 * @Time 2017年9月19日 下午10:16:17
 * @since 1.0.0
 */
public class ActionHelper {

	/**
	 * Action Map（HTTP 请求与 Action 方法的映射）
	 */
	private static final Map<Requester, Handler> actionMap = new LinkedHashMap<Requester, Handler>();

	static {
		// 获取所有 Action 类
		List<Class<?>> actionClassList = ClassHelper.getClassListByAnnotation(Action.class);
		if (CollectionUtil.isNotEmpty(actionClassList)) {
			// 定义两个 Action Map
			Map<Requester, Handler> commonActionMap = new HashMap<Requester, Handler>(); // 存放普通
																							// Action
																							// Map
			Map<Requester, Handler> regexpActionMap = new HashMap<Requester, Handler>(); // 存放带有正则表达式的
																							// Action
																							// Map
			// 遍历 Action 类
			for (Class<?> actionClass : actionClassList) {
				/**
				 * 田源 增加Action url功能，使Action使用更加灵活
				 */
				// 获取 Action 注解
				Action actionAnnotation = actionClass.getAnnotation(Action.class);

				// 获取并遍历该 Action 类中所有的方法
				Method[] actionMethods = actionClass.getDeclaredMethods();
				if (ArrayUtil.isNotEmpty(actionMethods)) {
					for (Method actionMethod : actionMethods) {
						// 处理 Action 方法
						handleActionMethod(actionClass, actionAnnotation, actionMethod, commonActionMap,
								regexpActionMap);
					}
				}
			}
			// 初始化最终的 Action Map（将 Common 放在 Regexp 前面）
			actionMap.putAll(commonActionMap);
			actionMap.putAll(regexpActionMap);
		}
	}

	/**
	 * 更改 Action 方法句柄 <br>
	 * 将Action方法与路径匹配，并添加到容器
	 *
	 * <br>
	 * create by on TY 2017年11月4日 上午9:31:22
	 * 
	 * @param actionClass
	 *            Action类文件
	 * @param actionAnnotation
	 *            Action注解value
	 * @param actionMethod
	 *            Action类下方法
	 * @param commonActionMap
	 *            普通Action容器
	 * @param regexpActionMap
	 *            带有正则表达式的Action容器
	 */
	private static void handleActionMethod(Class<?> actionClass, Action actionAnnotation, Method actionMethod,
			Map<Requester, Handler> commonActionMap, Map<Requester, Handler> regexpActionMap) {
		/**
		 * 田源 新增 获取Action的url值
		 * <br>给Action url前置一个斜杠(/) 
		 * <br>如果 Action url有值，则再为url后置一个斜杠(/)
		 */
		String value =ConstantUtil.SPRIT+ actionAnnotation.value();
		if(!StringUtil.isEmpty(value)){
			value=value+ConstantUtil.SPRIT;
		}
		
		// 判断当前 Action 方法是否带有 Request 注解
		if (actionMethod.isAnnotationPresent(Request.Get.class)) {
			String requestPath = value + actionMethod.getAnnotation(Request.Get.class).value();
			putActionMap("GET", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
		} else if (actionMethod.isAnnotationPresent(Request.Post.class)) {
			String requestPath = value + actionMethod.getAnnotation(Request.Post.class).value();
			putActionMap("POST", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
		} else if (actionMethod.isAnnotationPresent(Request.Put.class)) {
			String requestPath = value + actionMethod.getAnnotation(Request.Put.class).value();
			putActionMap("PUT", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
		} else if (actionMethod.isAnnotationPresent(Request.Delete.class)) {
			String requestPath = value + actionMethod.getAnnotation(Request.Delete.class).value();
			putActionMap("DELETE", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
		}
	}

	private static void putActionMap(String requestMethod, String requestPath, Class<?> actionClass,
			Method actionMethod, Map<Requester, Handler> commonActionMap, Map<Requester, Handler> regexpActionMap) {
		// 判断 Request Path 中是否带有占位符
		if (requestPath.matches(".+\\{\\w+\\}.*")) {
			// 将请求路径中的占位符 {\w+} 转换为正则表达式 (\\w+)
			requestPath = StringUtil.replaceAll(requestPath, "\\{\\w+\\}", "(\\\\w+)");
			// 将 Requester 与 Handler 放入 Regexp Action Map 中
			regexpActionMap.put(new Requester(requestMethod, requestPath), new Handler(actionClass, actionMethod));
		} else {
			// 将 Requester 与 Handler 放入 Common Action Map 中
			commonActionMap.put(new Requester(requestMethod, requestPath), new Handler(actionClass, actionMethod));
		}
	}

	/**
	 * 获取 Action Map
	 */
	public static Map<Requester, Handler> getActionMap() {
		return actionMap;
	}
}
