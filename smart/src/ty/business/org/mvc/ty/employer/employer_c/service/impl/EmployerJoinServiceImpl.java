package org.mvc.ty.employer.employer_c.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeJoinFBService;
import org.mvc.ty.employer.employer_c.service.EmployerJoinService;
import org.mvc.ty.employer.employer_s.service.EmployerJoinFBService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.sql.SQLException;
import java.util.Map;

@Service
public class EmployerJoinServiceImpl extends BaseService implements EmployerJoinService {

    @Inject
    private EmployerJoinFBService employerJoinFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        employerJoinFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employerJoinFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) {

    }

    @Override
    public void rollbackYw(String processInstanceId) {

    }
}
