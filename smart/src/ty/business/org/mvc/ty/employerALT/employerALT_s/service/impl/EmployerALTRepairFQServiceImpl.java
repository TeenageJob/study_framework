package org.mvc.ty.employerALT.employerALT_s.service.impl;


import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairFQService;
import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;
@Service
public class EmployerALTRepairFQServiceImpl implements EmployerALTRepairFQService {


    @Inject
    private EmployerALTRepairSService employerALTRepairSService;


    @Override
    public List<Map> queryPaymentInfo(Map paramMap) {
        switch (paramMap.get("ADA00J").toString()) {
            case "失业保险":
                return employerALTRepairSService.queryAD13C(paramMap);
            case "生育保险":
                return employerALTRepairSService.queryAD13B(paramMap);
            case "医疗保险":
                return  employerALTRepairSService.queryAD13A(paramMap);
            case "养老保险":
                return  employerALTRepairSService.queryAD13D(paramMap);
            case "工伤保险":
                return  employerALTRepairSService.queryAD13E(paramMap);
        }
        return null;
    }


}
