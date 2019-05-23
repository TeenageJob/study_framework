package org.mvc.ty.employerAccount.employerAccount_c.action;

import org.mvc.ty.employerAccount.employerAccount_c.service.EmployerPaymentService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.View;
import org.smart.framework.util.StringUtil;
import org.smart.plugin.common.impl.BaseAction;

import java.util.List;
import java.util.Map;

@Action("employerPayment")
public class EmployerPaymentAction extends BaseAction {


    @Inject
    private EmployerPaymentService employerPaymentService;

    /**
     * 进入界面
     *
     * @return
     */
    @Request.Post("index.do")
    public View execute() {
        initActiviti();
        return new View("employerAcount/employerPayment");
    }

    @Request.Post("save.do")
    public String save(Params params) throws Exception {
       process(params);
        return JSON;
    }

    @Request.Post("getBaseNumber.do")
    public String getBaseNumber(Params params) {
        if (StringUtil.isNumber(params.getString("009")) &&
                StringUtil.isNumber(params.getString("008"))) {
            List<Map<String, String>> list = employerPaymentService.getBaseNumber(params);
            for (Map<String, String> map : list) {
                for (Map.Entry<String, String> empa : map.entrySet()) {
                    setData(empa.getKey(), empa.getValue());
                }
            }
        }
        return JSON;
    }
}
