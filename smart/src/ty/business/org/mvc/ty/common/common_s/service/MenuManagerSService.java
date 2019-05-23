package org.mvc.ty.common.common_s.service;

import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.Map;

public interface MenuManagerSService {

    /**
     * 获取菜单下拉树
     */
    TreeVO getTreeDataByMenu();

    /**
     * 添加节点
     */
    boolean addNode(Map<String,Object> paramMap);

    /**
     * 删除该节点及子节点
     */
    Boolean delNode(Map<String,String> paramMap);

    /**
     * 编辑节点信息
     * @param params
     * @return
     */
    boolean edtNode(Map<String,Object> paramMap);
}
