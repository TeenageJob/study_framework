package org.mvc.ty.employerAccount.employerAccount_s.service.impl;

import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentFBService;
import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.StringUtil;

import java.util.Map;

@Service
public class EmployerPaymentFBServiceImpl implements EmployerPaymentFBService {

    @Inject
    private EmployerPaymentSService employerPaymentSService;

    @Override
    public void saveYw(Map<String, String> paramMap) throws Exception {
        if (StringUtil.isNotEmpty(paramMap.get("ADA001"))) {
            employerPaymentSService.saveAd13A(paramMap);
        }
        if (StringUtil.isNotEmpty(paramMap.get("ADB001"))) {
            employerPaymentSService.saveAd13B(paramMap);
        }
        if (StringUtil.isNotEmpty(paramMap.get("ADC001"))) {
            employerPaymentSService.saveAd13C(paramMap);
        }
        if (StringUtil.isNotEmpty(paramMap.get("ADD001"))) {
            employerPaymentSService.saveAd13D(paramMap);
        }
        if (StringUtil.isNotEmpty(paramMap.get("ADE001"))) {
            employerPaymentSService.saveAd13E(paramMap);
        }
    }

    @Override
    public void fuheYw(String buId) throws Exception {
        employerPaymentSService.fuheYw(buId);
    }


}
