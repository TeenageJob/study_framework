package org.mvc.ty.mybatis.employerAccount;

import java.util.List;
import java.util.Map;

public interface EmployerAccount {

    List<Map<String, String>> getBaseNumber(Map paramMap);

    /**
     * 医疗
     */
    void saveAd13A(Map paramMap);

    /**
     * 生育
     */
    void saveAd13B(Map paramMap);

    /**
     * 失业
     */
    void saveAd13C(Map paramMap);

    /**
     * 养老
     */
    void saveAd13D(Map paramMap);

    /**
     * 工伤
     */
    void saveAd13E(Map paramMap);

    /**
     * 医疗
     */
    void fuheAd13A(String buId);

    /**
     * 生育
     */
    void fuheAd13B(String buId);

    /**
     * 失业
     */
    void fuheAd13C(String buId);

    /**
     * 养老
     */
    void fuheAd13D(String buId);

    /**
     * 工伤
     */
    void fuheAd13E(String buId);

    /**
     * 医疗保险
     */
    List<Map> queryAD13A(Map paramMap);

    /**
     * 生育保险
     */
    List<Map> queryAD13B(Map paramMap);

    /**
     * 失业保险
     */
    List<Map> queryAD13C(Map paramMap);

    /**
     * 养老保险
     */
    List<Map> queryAD13D(Map paramMap);

    /**
     * 工伤保险
     */
    List<Map> queryAD13E(Map paramMap);
}
