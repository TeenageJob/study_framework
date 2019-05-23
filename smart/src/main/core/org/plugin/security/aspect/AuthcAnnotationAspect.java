package org.plugin.security.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.plugin.security.annotation.Authenticated;
import org.plugin.security.annotation.Guest;
import org.plugin.security.annotation.HasPermissions;
import org.plugin.security.annotation.HasRoles;
import org.plugin.security.annotation.User;
import org.smart.framework.aop.AspectProxy;
import org.smart.framework.aop.annotation.Aspect;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.fault.AuthzException;

/**
 * 授权注解切面
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:43:01
 * @since 1.0.0
 */
@Aspect(annotation = Action.class)
public class AuthcAnnotationAspect extends AspectProxy {

	/**
	 * 定义一个基于授权功能的注解类数组
	 */
	private static final Class[] annotationClassArray = { Authenticated.class, User.class, Guest.class, HasRoles.class,
			HasPermissions.class };

	@Override
	public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
		// 从目标类与目标方法中获取相应的注解
		Annotation annotation = getAnnotation(cls, method);
		if (annotation != null) {
			// 判断授权注解的类型
			Class<?> annotationType = annotation.annotationType();
			// 验证当前用户：认证、登录、角色、权限
			if (annotationType.equals(Authenticated.class)) {
				handleAuthenticated();
			} else if (annotationType.equals(User.class)) {
				handleUser();
			} else if (annotationType.equals(Guest.class)) {
				handleGuest();
			} else if (annotationType.equals(HasRoles.class)) {
				handleHasRoles((HasRoles) annotation);
			} else if (annotationType.equals(HasPermissions.class)) {
				handleHasPermissions((HasPermissions) annotation);
			}
		}
	}

	/**
	 * 获取注解
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:02:38
	 * 
	 * @param cls
	 *            类
	 * @param method
	 *            方法
	 * @return Annotation
	 */
	private Annotation getAnnotation(Class<?> cls, Method method) {
		// 遍历所有的授权注解
		for (Class<? extends Annotation> annotationClass : annotationClassArray) {
			// 首先判断目标方法上是否带有授权注解
			if (method.isAnnotationPresent(annotationClass)) {
				return method.getAnnotation(annotationClass);
			}
			// 然后判断目标类上是否带有授权注解
			if (cls.isAnnotationPresent(annotationClass)) {
				return cls.getAnnotation(annotationClass);
			}
		}
		// 若目标方法与目标类上均未带有授权注解，则返回空对象
		return null;
	}

	/**
	 * 用户是否认证
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:03:45
	 */
	private void handleAuthenticated() {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			throw new AuthzException("当前用户尚未认证");
		}
	}

	/**
	 * 用户是否登录
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:04:09
	 */
	private void handleUser() {
		Subject currentUser = SecurityUtils.getSubject();
		PrincipalCollection principals = currentUser.getPrincipals();
		if (principals == null || principals.isEmpty()) {
			throw new AuthzException("当前用户尚未登录");
		}
	}

	/**
	 * 用户是否是访客
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:04:23
	 */
	private void handleGuest() {
		Subject currentUser = SecurityUtils.getSubject();
		PrincipalCollection principals = currentUser.getPrincipals();
		if (principals != null && !principals.isEmpty()) {
			throw new AuthzException("当前用户不是访客");
		}
	}

	/**
	 * 用户没有指定角色
	 *
	 * <br>
	 * create by on TY 2017年11月20日 下午4:04:41
	 * 
	 * @param hasRoles
	 */
	private void handleHasRoles(HasRoles hasRoles) {
		String roleName = hasRoles.value();
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.hasRole(roleName)) {
			throw new AuthzException("当前用户没有指定角色，角色名：" + roleName);
		}
	}

	/**
	 * 用户有没有资源权限
	 *
	 * <br>
	 * create by on TY <br>
	 * 2017年12月13日 下午5:28:15
	 * 
	 * @param hasPermissions
	 */
	private void handleHasPermissions(HasPermissions hasPermissions) {
		String permissionName = hasPermissions.value();
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isPermitted(permissionName)) {
			throw new AuthzException("当前用户没有指定权限，权限名：" + permissionName);
		}
	}
}
