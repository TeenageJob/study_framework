package org.mvc.ty.employerAccount.employerAccount_s.service.impl;

import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentFQService;
import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployerPaymentFQServiceImpl implements EmployerPaymentFQService {

    @Inject
    private EmployerPaymentSService employerPaymentSService;

    @Override
    public List<Map<String, String>> getBaseNumber(Map paramMap) {
        return employerPaymentSService.getBaseNumber(paramMap);

    }
}
