package org.mvc.ty.employee.employee_s.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeJoinFBService;
import org.mvc.ty.employee.employee_s.service.EmployeeJoinSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployeeJoinFBServiceImpl extends BaseServiceImpl implements EmployeeJoinFBService {

    @Inject
    private EmployeeJoinSService employeeJoinSService;


    @Override
    public void saveYw(Map<String, Object> paramMap) {
        employeeJoinSService.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String procId) {
        employeeJoinSService.fuheYw(procId);
    }
}
