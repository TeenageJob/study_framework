package org.mvc.ty.employee.employee_s.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeChangeFQService;
import org.mvc.ty.employee.employee_s.service.EmployeeChangeSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeChangeFQServiceImpl extends BaseServiceImpl implements EmployeeChangeFQService {

    @Inject
    private EmployeeChangeSService employeeChangeSService;

    @Override
    public List<Map> getAllEmployeeInfo() {
        return employeeChangeSService.getAllEmployeeInfo();

    }

    @Override
    public List<Map<String, String>> getEmployeeInsureInfo(String ACB001) {
        return employeeChangeSService.getEmployeeInsureInfo(ACB001);
    }
}
