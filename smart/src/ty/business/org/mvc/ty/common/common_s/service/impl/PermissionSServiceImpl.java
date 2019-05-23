package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.PermissionSService;
import org.mvc.ty.mybatis.common.Common;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.plugin.security.SecurityHelper;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.ValidataUtil;

import java.util.*;

@Service
public class PermissionSServiceImpl implements PermissionSService {

    /**
     * 获取mybatis接口
     */
    @MybatisInject
    private Common common;

    @MybatisSession
    @Override
    public List<?> getAllRoleName() {
        return common.getAllUserInfo();
    }

    @MybatisSession
    @Override
    public List getRolePermissionPage(Map paramMap) {
        //获取该角色的所有权限
        Set<String> set = common.getRolePermission(paramMap);
        //获取所有权限页面
        List<Map<String, String>> permissionPage = common.getRolePermissionPage();
        final List<Map<String, String>> maps = new ArrayList<>(permissionPage);
        for (Map<String, String> map : maps) {
            if (!ValidataUtil.likeWithSet(set, map.get("permission"))) {
                permissionPage.remove(map);
            }
        }
        return permissionPage;
    }

    @MybatisSession
    @Override
    public boolean updateRolePage(Map<String, Object> param) {
        //添加页面权限
        if (ValidataUtil.isNotEmpty(param.get("add"))) {
            common.addRolePermission(param);
        }
        //删除页面权限
        if (ValidataUtil.isNotEmpty(param.get("del"))) {
            common.delRolePermission(param);
        }
        return true;
    }
}
