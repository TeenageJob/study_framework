package org.mvc.ty.common.common_s.service;

import java.util.Map;

public interface MenuManagerFBService {

    /**
     * 添加节点
     */
    boolean addNode(Map<String,Object> paramMap);

    /**
     * 删除该节点及子节点
     */
    boolean delNode(Map<String,String> paramMap);

    /**
     * 编辑节点信息
     * @param params
     * @return
     */
    boolean edtNode(Map<String,Object> paramMap);
}
