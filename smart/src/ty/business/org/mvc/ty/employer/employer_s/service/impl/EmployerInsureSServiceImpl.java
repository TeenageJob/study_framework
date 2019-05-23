package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_s.service.EmployerInsureSService;
import org.mvc.ty.mybatis.employer.Employer;
import org.plugin.mybatis.MybatisInject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployerInsureSServiceImpl extends BaseServiceImpl implements EmployerInsureSService {

    @MybatisInject
    private Employer employer;


    public void saveYw(Map<String, Object> paramMap) {
        employer.saveYw(paramMap);
    }



    public void checkYw(String processInstanceId) throws Exception {
        employer.checkYw(processInstanceId);
    }


    public void revocateYw(String processInstanceId) {
        employer.cancelYw(processInstanceId);
    }


    public void rollbackYw(String processInstanceId) {

    }
}
