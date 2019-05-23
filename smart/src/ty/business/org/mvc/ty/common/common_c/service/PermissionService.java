package org.mvc.ty.common.common_c.service;

import org.smart.framework.mvc.bean.Params;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.List;
import java.util.Map;

public interface PermissionService {
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
    List getRolePermissionPage(Params params);

    /**
     * 跟新用户权限页面
     * @param param
     * @return
     */
    boolean updateRolePage(Params param);

}
