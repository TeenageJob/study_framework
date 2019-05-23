package org.mvc.ty.employee.employee_c.service.impl;

import org.mvc.ty.employee.employee_c.service.EmployeeInsureService;
import org.mvc.ty.employee.employee_s.service.EmployeeInsureFBService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.sql.SQLException;
import java.util.Map;

@Service
public class EmployeeInsureServiceImpl extends BaseService implements EmployeeInsureService {

    @Inject
    private EmployeeInsureFBService employeeInsureFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        employeeInsureFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employeeInsureFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) {

    }

    @Override
    public void rollbackYw(String processInstanceId) {

    }


}
