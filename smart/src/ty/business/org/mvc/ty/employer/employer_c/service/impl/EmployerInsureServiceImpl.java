package org.mvc.ty.employer.employer_c.service.impl;

import org.mvc.ty.employer.employer_c.service.EmployerInsureService;

import org.mvc.ty.employer.employer_s.service.EmployerInsureFBService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployerInsureServiceImpl extends BaseService implements EmployerInsureService {

    @Inject
    private EmployerInsureFBService employerInsureFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        Map paramMap = params.getFieldMap();
           /* paramMap.put("business_id", params.getString("businessId"));
            paramMap.put("start_time", params.getString("txt_start_time"));
            paramMap.put("end_time", params.getString("txt_end_time"));
            paramMap.put("why", params.getString("txt_why"));*/

        paramMap.put("AAA00A", params.getString("businessId"));
        saveProcess(params);
        employerInsureFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String procId) throws Exception {
        String businessId = fuheProcess(procId);
        employerInsureFBService.checkYw(businessId);
    }


    @Override
    public void revocateYw(String procId) throws Exception {
        String business = cancelProcess(procId);
        employerInsureFBService.revocateYw(business);
    }

    @Override
    public void rollbackYw(String businessId) {

    }


}
