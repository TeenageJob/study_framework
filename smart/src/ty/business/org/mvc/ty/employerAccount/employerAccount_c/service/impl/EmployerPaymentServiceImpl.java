package org.mvc.ty.employerAccount.employerAccount_c.service.impl;

import org.mvc.ty.employerAccount.employerAccount_c.service.EmployerPaymentService;
import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentFBService;
import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.util.List;
import java.util.Map;

@Service
public class EmployerPaymentServiceImpl extends BaseService implements EmployerPaymentService {

    @Inject
    private EmployerPaymentFQService employerPaymentFQService;
    @Inject
    private EmployerPaymentFBService employerPaymentFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        employerPaymentFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employerPaymentFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) throws Exception {

    }

    @Override
    public void rollbackYw(String processInstanceId) throws Exception {

    }

    @Override
    public List<Map<String, String>> getBaseNumber(Params params) {
        Map paramMap = params.getFieldMap();
        return employerPaymentFQService.getBaseNumber(paramMap);
    }
}
