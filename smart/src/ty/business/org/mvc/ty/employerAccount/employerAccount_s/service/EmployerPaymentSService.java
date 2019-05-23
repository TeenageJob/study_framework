package org.mvc.ty.employerAccount.employerAccount_s.service;

import java.util.List;
import java.util.Map;

public interface EmployerPaymentSService {

    List<Map<String, String>> getBaseNumber(Map paramMap);

    /**
     * 医疗
     * @param paramMap
     */
    void saveAd13A(Map paramMap) throws Exception;

    /**
     * 生育
     * @param paramMap
     */
    void saveAd13B(Map paramMap) throws Exception;

    /**
     * 失业
     * @param paramMap
     */
    void saveAd13C(Map paramMap) throws Exception;

    /**
     * 养老
     * @param paramMap
     */
    void saveAd13D(Map paramMap) throws Exception;

    /**
     * 工伤
     * @param paramMap
     */
    void saveAd13E(Map paramMap) throws Exception;

    void fuheYw(String buId) throws Exception;


}
