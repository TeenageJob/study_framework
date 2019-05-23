package org.mvc.ty.employee.employee_c.action;

import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("employeeInsure")
public class EmployeeInsureAction extends BaseAction {

    /**
     * 进入界面
     *
     * @return
     */
    @Request.Post("index.do")
    public View execute() {
        initActiviti();
        return new View("employee/employeeRegister");
    }

    /**
     * 流程引擎：保存请假
     *
     * @param params
     * @return
     */
    @Request.Post("save.do")
    public Result save(Params params) throws Exception {
       process(params);
        return new Result(true);
    }


}
