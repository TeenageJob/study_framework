package org.mvc.ty.employerALT.employerALT_c.service.impl;

import org.mvc.ty.employerALT.employerALT_c.service.EmployerALTBackService;
import org.mvc.ty.employerALT.employerALT_c.service.EmployerALTRepairService;
import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairFBService;
import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairFQService;
import org.mvc.ty.employerALT.employerALT_s.service.impl.EmployerALTBackFBServiceImpl;
import org.mvc.ty.employerALT.employerALT_s.service.impl.EmployerALTBackFQServiceImpl;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.util.List;
import java.util.Map;

@Service
public class EmployerALTBackServiceImpl extends BaseService implements EmployerALTBackService {


    @Inject
    private EmployerALTBackFQServiceImpl employerALTBackFQService;
    @Inject
    private EmployerALTBackFBServiceImpl employerALTBackFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap=params.getFieldMap();
        paramMap.put("AAA00A",params.getString("businessId"));
        employerALTBackFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        employerALTBackFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) throws Exception {

    }

    @Override
    public void rollbackYw(String processInstanceId) throws Exception {

    }

    @Override
    public List<Map> queryPaymentInfo(Params params) {
        return employerALTBackFQService.queryPaymentInfo(params.getFieldMap());
    }
}
