package org.smart.framework.util;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.smart.framework.ioc.BeanHelper;

/**
 * 类文件-属性工具
 * 
 * @author TY
 * @Time 2017年12月13日 上午10:48:39
 * @since 1.0.0
 */
public class PropertyUtil {

	public static Map<Class<?>,Object> isFieldContainInject(Class<? extends Annotation> cls){ 
		return BeanHelper.getBeanMapWithFieldAnnotation(cls);
	}

}
