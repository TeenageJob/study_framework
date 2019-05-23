package org.mvc.ty.employerAccount.employerAccount_s.service;

import org.smart.plugin.common.IBaseService;

import java.util.Map;

public interface EmployerPaymentFBService {

    void saveYw(Map<String,String>  paramMap) throws Exception;

    void fuheYw(String buId) throws Exception;
}
