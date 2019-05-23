package org.mvc.ty.common.common_c.action;

import org.plugin.security.SecurityHelper;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;

import java.util.Map;

@Action("role")
public class RoleAction {

    @Request.Post("index.do")
    public View execute() {
        return new View("role/addRole");
    }

    @Request.Post("save.do")
    public Result save(Params params){
        Map paramMap = params.getFieldMap();
        SecurityHelper.addRole(paramMap);
        return new Result(true);
    }
}
