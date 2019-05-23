package org.smart.plugin.common.web.pagebean.impl;

import org.smart.framework.util.JsonUtil;
import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.web.pagebean.ITree;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.HashMap;
import java.util.Map;

public class Tree implements ITree {

    private Map<String,TreeVO> map=new HashMap<>();

    @Override
    public Map<String, TreeVO> getTreeData() {
        return map;
    }

    @Override
    public TreeVO getTreeDataById(String id) {
        if(""== MapUtil.getObj(map,id)){
            return null;
        }
        return (TreeVO)MapUtil.getObj(map,id);
    }

    @Override
    public void setTreeData(String id, TreeVO treeVO) {
        map.put(id,treeVO);
    }

    @Override
    public void removeTreeData(String id) {
        map.remove(id);
    }

    @Override
    public String treeToJson(String id) {
       return JsonUtil.toJSON(map.get(id));
    }
}
