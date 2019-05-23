package org.mvc.ty.employee.employee_s.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeInsureSService;
import org.mvc.ty.mybatis.employee.Employee;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployeeInsureSServiceImpl extends BaseServiceImpl implements EmployeeInsureSService {


    @MybatisInject
    Employee employee;

    @MybatisSession
    @Override
    public void saveYw(Map paramMap) {
        employee.saveEmployeeInfo(paramMap);
    }

    @Override
    public void fuheYw(String procId) {
        employee.fuheEmployeeInfo(procId);
    }
}
