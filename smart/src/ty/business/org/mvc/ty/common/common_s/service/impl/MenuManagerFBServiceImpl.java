package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.MenuManagerFBService;
import org.mvc.ty.common.common_s.service.MenuManagerSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;
@Service
public class MenuManagerFBServiceImpl implements MenuManagerFBService{

    @Inject
    private MenuManagerSService menuManagerSService;

    @Override
    public boolean addNode(Map<String, Object> paramMap) {
        menuManagerSService.addNode(paramMap);
        return true;
    }

    @Override
    public boolean delNode(Map<String, String> paramMap) {
        return menuManagerSService.delNode(paramMap);
    }

    @Override
    public boolean edtNode(Map<String, Object> paramMap) {
        return menuManagerSService.edtNode(paramMap);
    }
}
