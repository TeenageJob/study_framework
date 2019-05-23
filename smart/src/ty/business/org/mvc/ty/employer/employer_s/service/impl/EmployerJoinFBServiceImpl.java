package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_s.service.EmployerChangeSService;
import org.mvc.ty.employer.employer_s.service.EmployerJoinFBService;
import org.mvc.ty.employer.employer_s.service.EmployerJoinSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployerJoinFBServiceImpl extends BaseServiceImpl implements EmployerJoinFBService {

    @Inject
    private EmployerJoinSService employerJoinSService;

    @Override
    public void saveYw(Map<String, Object> paramMap) throws Exception {
        employerJoinSService.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String processInstanceId) throws Exception {
        employerJoinSService.checkYw(processInstanceId);
    }


}
