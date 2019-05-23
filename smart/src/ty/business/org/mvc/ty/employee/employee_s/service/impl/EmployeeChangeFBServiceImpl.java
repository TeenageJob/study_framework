package org.mvc.ty.employee.employee_s.service.impl;


import org.mvc.ty.employee.employee_s.service.EmployeeChangeFBService;
import org.mvc.ty.employee.employee_s.service.EmployeeChangeSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeChangeFBServiceImpl extends BaseServiceImpl implements EmployeeChangeFBService {

    @Inject
    private EmployeeChangeSService employeeChangeSService;

    @Override
    public List<Map> getAllEmployeeInfo() {
        return employeeChangeSService.getAllEmployeeInfo();
    }

    @Override
    public void saveYw(Map paramMap) {
        employeeChangeSService.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String buId) {
        employeeChangeSService.fuheYw(buId);
    }
}
