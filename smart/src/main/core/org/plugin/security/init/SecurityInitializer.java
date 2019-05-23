package org.plugin.security.init;

import java.util.Set;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.mvc.ty.start.StartHelper;
import org.plugin.security.SecurityConstant;

/**
 * Security 初始化器 <br/>
 * 用于注册 Shiro 所需要的 Listener 与 Filter
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:53:31
 * @since 1.0.0
 */
public class SecurityInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> handlesTypes, ServletContext servletContext) throws ServletException {
		// 设置shiro配置文件位置
		servletContext.setInitParameter(SecurityConstant.SHIRO_CONFIG_LOCATIONS,SecurityConstant.SHIRO_CONFIG_LOCATION_PATH);
		// 设置WebEnvironment 接口的实现类
		servletContext.setInitParameter(SecurityConstant.SHIRO_ENVIRONMENTCLASS,
				SecurityConstant.SHIRO_ENVIRONMENTCLASS_IMPL);
		// 注册Listener
		servletContext.addListener(EnvironmentLoaderListener.class);
		// 注册 Filter
		FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("ShiroFilter", SecurityFilter.class);
		/**
		 * dispatcherTypes ：分发器类型 isMatchAfter ：在filter前还是后执行 ulrs：拦截路径
		 */
		shiroFilter.addMappingForUrlPatterns(null, false, "*.do");
		new StartHelper();
	}
}
