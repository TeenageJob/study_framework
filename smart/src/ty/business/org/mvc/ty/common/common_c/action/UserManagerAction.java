package org.mvc.ty.common.common_c.action;

import org.mvc.ty.common.common_c.service.UserManagerService;
import org.mvc.ty.common.vo.UserInformationVO;
import org.plugin.security.SecurityHelper;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

import java.util.List;
import java.util.Map;

@Action("userManager")
public class UserManagerAction extends BaseAction {

    @Inject
    private UserManagerService userManagerService;

    /**
     * 进入用户信息页面
     *
     * @return
     */
    @Request.Post("index.do")
    public View execute() {
        setList("grid_1", userManagerService.getAllUser());
        return new View("userManager/userManager");
    }

    @Request.Post("getData.do")
    public View getData(Params params) {
        View view = new View("userManager/userInfoEdit");
        UserInformationVO userInformationVO = userManagerService.getData(params);
        setData("username", userInformationVO.getUsername());
        setReadOnly("username");
        setData("email", userInformationVO.getEmail());
        setData("phone", userInformationVO.getPhone());
        setData("operator", userInformationVO.getOperator());
        setData("operator_id", userInformationVO.getOperatorId());
        setData("operator_organzation", userInformationVO.getOperatorOrganization());
        return view;
    }

    @Request.Post("saveUserInfo.do")
    public Result saveUserInfo(Params params) {
        return new Result(userManagerService.saveUserInfo(params));
    }

    @Request.Post("setRole.do")
    public View setRole() {
        setSelectInputList("lt_user", userManagerService.getAllUserList());
        setSelectInputList("sl_role", userManagerService.getAllRoleList());
        return new View("userManager/setRole");
    }

    @Request.Post("save.do")
    public Result save(Params params) {
        Map paramMap = params.getFieldMap();
        SecurityHelper.addUserRole(paramMap);
        return new Result(true);
    }

    @Request.Post("setUserRole.do")
    public String setUserRole(Params params) {
        userManagerService.setUserRole(params);
        return JSON;
    }

}
