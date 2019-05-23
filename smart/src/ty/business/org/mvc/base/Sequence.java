package org.mvc.base;

import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.DateUtil;

import java.security.SecureRandom;
import java.util.List;

/**
 * 获取对应的序列
 */
public class Sequence {

    private static SecureRandom secureRandom;

    public static String getBusiness() {
        Object ok = "s";
        String value = null;
        String sql = "select func_nextval('business')";
        synchronized (ok) {
            List list = DatabaseHelper.executeSqlList(sql);
            if (CollectionUtil.isEmpty(list)) {
                list = DatabaseHelper.executeSqlList(sql);
            }
            value = list.get(0).toString();
        }
        return value;
    }


    public static String getCodeRadome() {
        String str = "yyyyMMddHHmmsss";
        str=DateUtil.getCurrentDatetime();
        return str;
    }

    public static String getRadome(){
        return  null;
    }
}
