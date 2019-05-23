package org.mvc.ty.employerAccount.employerAccount_s.service.impl;

import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentQuerySService;
import org.mvc.ty.mybatis.employerAccount.EmployerAccount;
import org.plugin.mybatis.MybatisInject;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployerPaymentQuerySServiceImpl implements EmployerPaymentQuerySService {

    @MybatisInject
    EmployerAccount employerAccount;

    @Override
    public List<Map> queryAD13A(Map paramMap) {
        return employerAccount.queryAD13A(paramMap);
    }

    @Override
    public List<Map> queryAD13B(Map paramMap) {
        return employerAccount.queryAD13B(paramMap);
    }

    @Override
    public List<Map> queryAD13C(Map paramMap) {
        return employerAccount.queryAD13C(paramMap);
    }

    @Override
    public List<Map> queryAD13D(Map paramMap) {
        return employerAccount.queryAD13D(paramMap);
    }

    @Override
    public List<Map> queryAD13E(Map paramMap) {
        return employerAccount.queryAD13E(paramMap);
    }
}
