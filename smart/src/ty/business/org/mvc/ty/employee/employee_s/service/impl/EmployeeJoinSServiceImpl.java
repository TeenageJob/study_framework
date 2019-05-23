package org.mvc.ty.employee.employee_s.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeJoinSService;
import org.mvc.ty.mybatis.employee.Employee;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class EmployeeJoinSServiceImpl extends BaseServiceImpl implements EmployeeJoinSService {


    @MybatisInject
    Employee employee;

    @MybatisSession
    @Override
    public void saveYw(Map paramMap) {
        employee.saveEmployeeJoin(paramMap);
        employee.saveEmployeeBank(paramMap);
    }

    @Override
    public void fuheYw(String procId) {
        employee.fuheEmployeeJoin(procId);
        employee.fuheEmployeeBank(procId);
    }


}
