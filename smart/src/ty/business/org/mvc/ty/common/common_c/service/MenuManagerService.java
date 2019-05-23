package org.mvc.ty.common.common_c.service;

import org.smart.framework.mvc.bean.Params;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

public interface MenuManagerService {

    /**
     * 获取菜单下拉树
     */
    TreeVO getTreeDataByMenu();

    /**
     * 添加节点
     */
    boolean addNode(Params params);

    /**
     * 删除该节点和该节点下的所有节点
     */
    Boolean delNode(Params params);

    /**
     * 编辑节点信息
     * @param params
     * @return
     */
    boolean edtNode(Params params);

}
