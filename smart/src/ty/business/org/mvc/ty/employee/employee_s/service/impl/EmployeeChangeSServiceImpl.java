package org.mvc.ty.employee.employee_s.service.impl;

import org.mvc.ty.employee.employee_s.service.EmployeeChangeSService;
import org.mvc.ty.mybatis.employee.Employee;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeChangeSServiceImpl extends BaseServiceImpl implements EmployeeChangeSService {

    @MybatisInject
    Employee employee;

    @Override
    public List<Map> getAllEmployeeInfo() {
        return employee.getAllEmployeeInfo();
    }

    @Override
    public List<Map<String, String>> getEmployeeInsureInfo(String ACB001) {
        return employee.getEmployeeInsureInfo(ACB001);
    }

    @MybatisSession
    @Override
    public void saveYw(Map paramMap) {
        employee.saveEmployeeJoin(paramMap);
        employee.saveEmployeeBank(paramMap);
    }

    @MybatisSession
    @Override
    public void fuheYw(String buId) {
        employee.updateYwBank(buId);
        employee.updateYwInsure(buId);
    }


}
