package org.mvc.ty.employer.employer_c.action;

import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("employerJoin")
public class EmployerJoinAction extends BaseAction {

    @Request.Post("index.do")
    public View execute(){
        initActiviti();
        return new View("employer/employerInsure");
    }

    @Request.Post("save.do")
    public String saveYw(Params params) throws Exception{
       process(params);
        return JSON;
    }

}
