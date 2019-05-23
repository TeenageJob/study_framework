package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_s.service.EmployerJoinSService;
import org.mvc.ty.mybatis.employer.Employer;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployerJoinSServiceImpl extends BaseServiceImpl implements EmployerJoinSService {

    @MybatisInject
    private Employer employer;


    @MybatisSession
    @Override
    public void saveYw(Map<String, Object> paramMap) {
        employer.saveInsureYw(paramMap);
        employer.saveInsureYwBank(paramMap);
    }

    @MybatisSession
    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employer.fuheInsureYwBank(processInstanceId);
        employer.fuheInsureYw(processInstanceId);
    }

    @Override
    public void revocateYw(String processInstanceId) {

    }


}
