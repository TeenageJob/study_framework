package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.PermissionFBService;
import org.mvc.ty.common.common_s.service.PermissionSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;

@Service
public class PermissionFBServiceImpl implements PermissionFBService{
    @Inject
    private PermissionSService permissionSService;
    @Override
    public boolean updateRolePage(Map<String, Object> paramMap) {
        return permissionSService.updateRolePage(paramMap);
    }
}
