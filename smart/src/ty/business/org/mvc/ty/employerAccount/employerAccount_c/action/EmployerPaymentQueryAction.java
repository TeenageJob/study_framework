package org.mvc.ty.employerAccount.employerAccount_c.action;

import org.mvc.ty.employerAccount.employerAccount_c.service.EmployerPaymentQueryService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.View;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.JsonUtil;
import org.smart.plugin.common.impl.BaseAction;

import java.util.List;

@Action("employerPaymentQuery")
public class EmployerPaymentQueryAction extends BaseAction {


    @Inject
    private EmployerPaymentQueryService employerPaymentQueryService;

    /**
     * 进入界面
     */
    @Request.Post("index.do")
    public View execute() {
        return new View("employerAcount/employerPaymentQuery");
    }

    @Request.Post("queryPaymentInfo.do")
    public String queryPaymentInfo(Params params) {
        List list = employerPaymentQueryService.queryPaymentInfo(params);
        if (CollectionUtil.isNotEmpty(list)) {
            setList("grid_payment", list);
        }
        return JSON;
    }

}
