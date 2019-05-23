package org.mvc.ty.common.common_s.service;

import java.util.Map;

public interface PermissionFBService {

    /**
     * 跟新用户权限页面
     * @param param
     * @return
     */
    boolean updateRolePage(Map<String,Object> paramMap);
}
