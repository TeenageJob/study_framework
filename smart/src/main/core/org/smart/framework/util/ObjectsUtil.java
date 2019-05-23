package org.smart.framework.util;

public class ObjectsUtil {

	/**
	 * 
	 *
	 * <br>create by on TY
	 * <br>2017年12月8日 上午11:15:06
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean isEquals(Object obj1, Object obj2) {
		if (obj1 == obj2) {
			return true;
		}
		if ((obj1 == null) || (obj2 == null)) {
			return false;
		}
		//obj1 会判断obj2是否是obj1的类型再判断是否值相等
		return obj1.equals(obj2);
	}
}
