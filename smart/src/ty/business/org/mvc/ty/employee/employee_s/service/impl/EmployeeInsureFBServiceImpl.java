package org.mvc.ty.employee.employee_s.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeInsureFBService;
import org.mvc.ty.employee.employee_s.service.EmployeeInsureSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployeeInsureFBServiceImpl extends BaseServiceImpl implements EmployeeInsureFBService {

    @Inject
    private EmployeeInsureSService employeeInsureSService;


    @Override
    public void saveYw(Map<String, Object> paramMap) {
        employeeInsureSService.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String procId) {
        employeeInsureSService.fuheYw(procId);
    }
}
