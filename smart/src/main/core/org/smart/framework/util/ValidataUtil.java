package org.smart.framework.util;

import org.smart.framework.core.bean.BaseBean;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 验证工具类 <br>
 * 用于验证字符串，数字，英文等变量的格式
 *
 * @author TY
 * @Time 2017年11月4日 下午5:12:45
 * @since 1.0.0
 */
public class ValidataUtil extends BaseBean {

    /**
     * create by ty on TY <br>
     * 2017年12月8日 上午10:53:45
     */
    private static final long serialVersionUID = 1L;

    /**
     * 判断字符串是否为页面后缀 默认为false <br>
     * create by on TY 2017年11月4日 下午5:09:47
     *
     * @param postfix 传入需要判断的字符串
     * @return boolean 为true是表示是页面后缀，false不是
     */
    public static boolean isPagePostfix(String postfix) {
        if (StringUtil.isEmpty(postfix))
            return false;
        switch (StringUtil.allToLower(postfix)) {
            case "htm":
                return true;
            case "html":
                return true;
            case "jsp":
                return true;
        }
        return false;

    }

    /**
     * 判断是否相等 <br>
     * 用于基本类型判断 ：boolean byte int long float double char short String date <br>
     * 判断其他类型，请继承BaseBean使用equals方法 <br>
     * create by on TY <br>
     * 2017年12月8日 上午10:50:51
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean isEquals(Object obj1, Object obj2) {
        return ObjectsUtil.isEquals(obj1, obj2);
    }

    /**
     * 判断是否为空
     * <p>
     * <br>
     * create by on TY <br>
     * 2017年12月11日 上午11:19:08
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            if (CollectionUtil.isEmpty((Collection<?>) obj)) {
                return true;
            } else {
                return false;
            }
        } else if (obj instanceof Map) {
            if (MapUtil.isNotEmpty((Map<?, ?>) obj)) {
                return false;
            } else {
                return true;
            }
        } else if (obj instanceof String) {
            return obj.toString().length() == 0 ? true : false;
        } else {
            return obj.toString().length() == 0 ? true : false;
        }
    }

    /**
     * 判断是否不为空
     * <p>
     * <br>
     * create by on TY <br>
     * 2017年12月11日 上午11:19:08
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断是否为静态资源
     * <p>
     * <br>create by on TY
     * <br>2017年12月18日 上午9:48:51
     *
     * @param url
     * @return boolean
     */
    public static boolean isStaticFile(String url) {
        if (!url.contains(".do")) {
            return false;
        }
        return true;
    }

    /**
     * 模糊匹配字符串是否
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean stringLike(String str1, String str2) {
        return str1.contains(str2);
    }

    /**
     * 判断集合set中字符串模糊匹配字符串
     *
     * @param set
     * @param str
     * @return
     */
    public static Boolean likeWithSet(Set<String> set, String str) {
        for (String string : set) {
            if (stringLike(string, str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断两个set集合中的元素模糊匹配
     *
     * @param set1
     * @param set2
     * @return
     */
    public static boolean likeWithSet(Set<String> set1, Set<String> set2) {
        if (set1.size() > set2.size()) {
            for (String str1 : set1) {
                for (String str2 : set2) {
                    if (str1.contains(str2)) {
                        return true;
                    }
                }
            }
        } else {
            for (String str1 : set2) {
                for (String str2 : set1) {
                    if (str1.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
