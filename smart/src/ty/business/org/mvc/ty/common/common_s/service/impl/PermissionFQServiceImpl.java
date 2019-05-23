package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.MenuManagerSService;
import org.mvc.ty.common.common_s.service.PermissionFQService;
import org.mvc.ty.common.common_s.service.PermissionSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.List;
import java.util.Map;
@Service
public class PermissionFQServiceImpl implements PermissionFQService {

    @Inject
    private PermissionSService permissionSService;
    @Inject
    private MenuManagerSService menuManagerSService;

    @Override
    public List<?> getAllRoleName() {
        return permissionSService.getAllRoleName();
    }

    @Override
    public TreeVO getTreeDataByMenu() {
        return menuManagerSService.getTreeDataByMenu();
    }

    @Override
    public List<String> getRolePermissionPage(Map paramMap) {

        return permissionSService.getRolePermissionPage(paramMap);
    }
}
