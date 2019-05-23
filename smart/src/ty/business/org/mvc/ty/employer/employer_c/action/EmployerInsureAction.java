package org.mvc.ty.employer.employer_c.action;

import org.mvc.ty.common.query.CommonQuery;
import org.mvc.ty.employer.employer_c.service.EmployerInsureService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Page;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("employerInsure")
public class EmployerInsureAction extends BaseAction {

    @Inject
    private EmployerInsureService employerInsureService;

    /**
     * 进入界面
     *
     * @return
     */
    @Request.Post("index.do")
    public View execute() {
        initActiviti();
        setReadOnly("ABA001");
        return new View("employer/employerRegister");
    }

    @Request.Post("leave.do")
    public View leave(){
        initActiviti();
        return new View("employer/leave-apply");
    }

    /**
     * 流程引擎：保存个人信息
     */
    @Request.Post("save.do")
    public Result save(Params params) throws Exception {
       process(params);
        return new Result(true);
    }



}
