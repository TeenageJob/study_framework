package org.mvc.ty.common.common_s.service;

import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.List;
import java.util.Map;

public interface PermissionFQService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<?> getAllRoleName();
    /**
     * 获取所有菜单信息
     */
    TreeVO getTreeDataByMenu();
    /**
     * 获取用户权限页面
     */
    List<String> getRolePermissionPage(Map paramMap);
}
