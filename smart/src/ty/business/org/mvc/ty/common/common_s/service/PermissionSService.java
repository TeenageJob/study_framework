package org.mvc.ty.common.common_s.service;

import java.util.List;
import java.util.Map;

public interface PermissionSService {

    /**
     * 获取全部用户
     * @return
     */
    List<?> getAllRoleName();

    /**
     * 获取用户权限页面
     */
    List getRolePermissionPage(Map paramMap);

    /**
     * 跟新用户权限页面
     * @param param
     * @return
     */
    boolean updateRolePage(Map<String,Object> param);
}
