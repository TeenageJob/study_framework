package org.mvc.ty.employerALT.employerALT_c.action;

import org.mvc.ty.employerALT.employerALT_c.service.EmployerALTRepairService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.util.CollectionUtil;
import org.smart.plugin.common.impl.BaseAction;
import org.smart.framework.mvc.bean.View;

import java.util.List;

@Action("employerALTRepair")
public class EmployerALTRepairAction extends BaseAction {

    @Inject
    private EmployerALTRepairService employerALTRepairService;

    @Request.Post("index.do")
    public View execute() {
        initActiviti();
        return new View("employerALT/employerRepair");
    }

    @Request.Post("getEmployerPaymentInfo.do")
    public String getEmployerPaymentInfo(Params params) {
        List list = employerALTRepairService.queryPaymentInfo(params);
        if (CollectionUtil.isNotEmpty(list)) {
            setList("panl_repair", list);
        }
        return JSON;
    }

    @Request.Post("save.do")
    public String save(Params params) throws Exception {
       process(params);
        return JSON;
    }
}
