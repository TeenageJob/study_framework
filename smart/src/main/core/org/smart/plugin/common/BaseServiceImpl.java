package org.smart.plugin.common;

import org.smart.framework.util.DateUtil;

public class BaseServiceImpl {
    /**
     * 获取当前日期
     */
    public String getDate() {
        return DateUtil.getCurrentDate();
    }
}
