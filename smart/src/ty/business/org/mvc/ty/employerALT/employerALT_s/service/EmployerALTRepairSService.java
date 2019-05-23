package org.mvc.ty.employerALT.employerALT_s.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;
import java.util.Map;

public interface EmployerALTRepairSService {

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


    /**医疗保险*/
    void saveAD13A(Map paramMap);
    /**生育保险*/
    void saveAD13B(Map paramMap);
    /**失业保险*/
    void saveAD13C(Map paramMap);
    /**养老保险*/
    void saveAD13D(Map paramMap);
    /**工伤保险*/
    void saveAD13E(Map paramMap);


    /**复核*/
    void fuheYw(String buId);

}
