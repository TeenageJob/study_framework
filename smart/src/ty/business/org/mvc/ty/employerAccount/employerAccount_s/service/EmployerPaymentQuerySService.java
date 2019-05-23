package org.mvc.ty.employerAccount.employerAccount_s.service;

import java.util.List;
import java.util.Map;

public interface EmployerPaymentQuerySService {

    /**医疗保险*/
    List<Map> queryAD13A(Map paramMap);
    /**生育保险*/
    List<Map> queryAD13B(Map paramMap);
    /**失业保险*/
    List<Map> queryAD13C(Map paramMap);
    /**养老保险*/
    List<Map> queryAD13D(Map paramMap);
    /**工伤保险*/
    List<Map> queryAD13E(Map paramMap);

}
