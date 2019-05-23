package org.mvc.ty.employerAccount.employerAccount_c.service.impl;

import org.mvc.ty.employerAccount.employerAccount_c.service.EmployerPaymentQueryService;
import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentQueryFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.util.List;
import java.util.Map;

@Service
public class EmployerPaymentQueryServiceImpl extends BaseService implements EmployerPaymentQueryService {


    @Inject
    private EmployerPaymentQueryFQService employerPaymentQueryFQService;

    @Override
    public void saveYw(Params params) throws Exception {

    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {

    }

    @Override
    public void revocateYw(String processInstanceId) {

    }

    @Override
    public void rollbackYw(String processInstanceId) {

    }

    @Override
    public List<Map> queryPaymentInfo(Params params) {
        Map map=params.getFieldMap();
        return employerPaymentQueryFQService.queryPaymentInfo(map);
    }
}
