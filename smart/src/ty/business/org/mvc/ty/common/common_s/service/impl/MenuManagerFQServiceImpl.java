package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.MenuManagerFQService;
import org.mvc.ty.common.common_s.service.MenuManagerSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;
@Service
public class MenuManagerFQServiceImpl implements MenuManagerFQService {

    @Inject
    private MenuManagerSService menuManagerSService;
    @Override
    public TreeVO getTreeDataByMenu() {
        return menuManagerSService.getTreeDataByMenu();
    }
}
