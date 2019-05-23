package org.mvc.ty.common.common_c.action;

import org.mvc.ty.common.common_c.service.MenuManagerService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("menuManager")
public class MenuManagerAction extends BaseAction{

    @Inject
    private MenuManagerService menuManagerService;
    /**
     * 进入菜单管理
     * @return
     */
    @Request.Post("menuManager.do")
    public View execute(){
        setTreeData("tree_1",menuManagerService.getTreeDataByMenu());
        return new View("menuManager/menuManager");
        //return new View("menuManager/test");
    }

    /**
     * 添加子节点
     * @param params
     * @return
     */
    @Request.Post("addNode.do")
    public Result addNode(Params params){
        return new Result(menuManagerService.addNode(params));
    }

    /**
     * 删除该节点和该节点下的所有节点
     * @param params
     * @return
     */
    @Request.Post("delNode.do")
    public Result delNode(Params params){
        return new Result(menuManagerService.delNode(params));
    }

    @Request.Post("edtNode.do")
    public Result edtNode(Params params){
        return new Result(menuManagerService.edtNode(params));
    }
}
