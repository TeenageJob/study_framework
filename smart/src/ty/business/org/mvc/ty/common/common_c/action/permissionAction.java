package org.mvc.ty.common.common_c.action;

import org.mvc.ty.common.common_c.service.PermissionService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.framework.util.StringUtil;
import org.smart.plugin.common.impl.BaseAction;

@Action("permission")
public class permissionAction extends BaseAction {

    @Inject
    private PermissionService permissionService;

    @Request.Post("permission.do")
    public View execute() {
        setSelectInputList("li_user", permissionService.getAllRoleName());
        setTreeData("tr_menu", permissionService.getTreeDataByMenu());
        return new View("permission/permissionManager");
    }

    /**
     * 获取用户权限页面
     *
     * @param params
     * @return
     */
    @Request.Post("getRolePermissionPage.do")
    public Result getRolePermissionPage(Params params){
        Result result = new Result(true);
        result.setData(permissionService.getRolePermissionPage(params));
        return result;
    }

    /**
     * 跟新用户权限页面
     *
     * @return
     */
    @Request.Post("updateRolePage.do")
    public Result updateRolePage(Params params){
        Result result = new Result(permissionService.updateRolePage(params));
        return result;
    }
}
