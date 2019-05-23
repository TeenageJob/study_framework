package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_c.service.EmployerInsureService;
import org.mvc.ty.employer.employer_s.service.EmployerInsureFBService;
import org.mvc.ty.employer.employer_s.service.EmployerInsureSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;


import java.util.Map;

@Service
public class EmployerInsureFBServiceImpl extends BaseServiceImpl implements EmployerInsureFBService {

    @Inject
    private EmployerInsureSService employerInsureSService;


    public void saveYw(Map<String,Object> paramMap) throws Exception {
        employerInsureSService.saveYw(paramMap);
    }


    @Override
    public void saveYw(Params params) throws Exception {

    }

    public void checkYw(String processInstanceId) throws Exception {
        employerInsureSService.checkYw(processInstanceId);
    }


    public void revocateYw(String processInstanceId)  throws Exception{
        employerInsureSService.revocateYw(processInstanceId);
    }


    public void rollbackYw(String processInstanceId) throws Exception {

    }
}
