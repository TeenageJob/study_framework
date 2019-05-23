package org.mvc.ty.common.common_s.service;

import org.smart.plugin.common.web.pagebean.vo.TreeVO;

public interface MenuManagerFQService {

    /**
     * 获取菜单下拉树
     */
    TreeVO getTreeDataByMenu();
}
