package org.mvc.ty.employee.employee_c.service.impl;

import org.mvc.ty.employee.employee_c.service.EmployeeInsureService;
import org.mvc.ty.employee.employee_s.service.EmployeeJoinFBService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.sql.SQLException;
import java.util.Map;

@Service
public class EmployeeJoinServiceImpl extends BaseService implements EmployeeInsureService {

    @Inject
    private EmployeeJoinFBService employeeJoinFBService;

    @Override
    public void saveYw(Params params) throws Exception{
            saveProcess(params);
            Map paramMap = params.getFieldMap();
            paramMap.put("AAA00A", params.getString("businessId"));
            employeeJoinFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        try {
            employeeJoinFBService.fuheYw(fuheProcess(processInstanceId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void revocateYw(String processInstanceId) {

    }

    @Override
    public void rollbackYw(String processInstanceId) {

    }


}
