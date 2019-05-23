package org.smart.framework.util;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils.Null;

/**
 * 集合操作工具类
 *
 * @author TY
 * @Time 2017年9月20日 下午9:44:11
 * @since 1.0.0
 */
public class CollectionUtil {

    /**
     * 判断集合是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return CollectionUtils.isNotEmpty(collection);
    }
    
    public static boolean isNotEmpty(Object obj){
    	return obj==null?false:true;
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }
    

}
