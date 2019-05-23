package org.mvc.ty.employerAccount.employerAccount_s.service.impl;

import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentQueryFQService;
import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentQuerySService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployerPaymentQueryFQServiceImpl implements EmployerPaymentQueryFQService {

    @Inject
    private EmployerPaymentQuerySService employerPaymentQuerySService;

    @Override
    public List<Map> queryPaymentInfo(Map paramMap) {
        switch (paramMap.get("ADA00J").toString()) {
            case "失业保险":
                return employerPaymentQuerySService.queryAD13C(paramMap);
            case "生育保险":
                return employerPaymentQuerySService.queryAD13B(paramMap);
            case "医疗保险":
                return  employerPaymentQuerySService.queryAD13A(paramMap);
            case "养老保险":
                return  employerPaymentQuerySService.queryAD13D(paramMap);
            case "工伤保险":
                return  employerPaymentQuerySService.queryAD13E(paramMap);
        }
        return null;
    }
}
