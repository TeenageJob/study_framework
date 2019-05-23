package org.mvc.ty.employerALT.employerALT_s.service.impl;


import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTBackFBService;
import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTBackSService;
import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairFBService;
import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;

@Service
public class EmployerALTBackFBServiceImpl implements EmployerALTBackFBService {


    @Inject
    private EmployerALTBackSService employerALTBackSService;

    @Override
    public void saveYw(Map paramMap) throws Exception {
        switch (paramMap.get("ADA00J").toString()){
            case "医疗保险":
                employerALTBackSService.saveAD13A(paramMap);
                break;
            case "生育保险":
                employerALTBackSService.saveAD13B(paramMap);
                break;
            case "失业保险":
                employerALTBackSService.saveAD13C(paramMap);
                break;
            case "养老保险":
                employerALTBackSService.saveAD13D(paramMap);
                break;
            case "工伤保险":
                employerALTBackSService.saveAD13E(paramMap);
                break;
        }
    }

    @Override
    public void fuheYw(String buId) throws Exception {
        employerALTBackSService.fuheYw(buId);
    }
}
