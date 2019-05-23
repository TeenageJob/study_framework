package org.smart.plugin.common.web.pagebean;

import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.Map;

public interface ITree {

    Map<String,TreeVO> getTreeData();

    TreeVO getTreeDataById(String id);

    void setTreeData(String id,TreeVO treeVO);

    void removeTreeData(String id);

    String treeToJson(String id);

}
