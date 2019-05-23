package org.mvc.ty.employer.employer_c.service.impl;

import org.mvc.ty.employer.employer_c.service.EmployerChangeService;
import org.mvc.ty.employer.employer_s.service.EmployerChangeFBService;
import org.mvc.ty.employer.employer_s.service.EmployerChangeFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;
import org.smart.plugin.common.BaseServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class EmployerChangeServiceImpl extends BaseService implements EmployerChangeService {


    @Inject
    private EmployerChangeFQService employerChangeFQService;

    @Inject
    private EmployerChangeFBService employerChangeFBService;

    @Override
    public List<Map<String, String>> getAllEmployerInfo() {
        return employerChangeFQService.getAllEmployeeInfo();
    }

    @Override
    public List<Map<String, String>> getEmployerInsureInfo(Params params) {
        String ABB001 = params.getString("ABB001");
        return employerChangeFQService.getEmployeeInsureInfo(ABB001);
    }

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        employerChangeFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employerChangeFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) {

    }

    @Override
    public void rollbackYw(String processInstanceId) {

    }
}
