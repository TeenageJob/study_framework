package org.mvc.ty.employee.employee_c.service.impl;

import org.mvc.ty.employee.employee_c.service.EmployeeChangeService;
import org.mvc.ty.employee.employee_s.service.EmployeeChangeFBService;
import org.mvc.ty.employee.employee_s.service.EmployeeChangeFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeChangeServiceImpl extends BaseService implements EmployeeChangeService {

    @Inject
    private EmployeeChangeFBService employeeChangeFBService;

    @Inject
    private EmployeeChangeFQService employeeChangeFQService;

    @Override
    public List<Map> getAllEmployeeInfo() {
        return employeeChangeFQService.getAllEmployeeInfo();
    }

    @Override
    public List<Map<String, String>> getEmployeeInsureInfo(Params params) {
        String ACB001 = params.getString("ACB001");
        return employeeChangeFQService.getEmployeeInsureInfo(ACB001);
    }


    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        employeeChangeFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employeeChangeFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) {
    }

    @Override
    public void rollbackYw(String processInstanceId) {
    }
}
