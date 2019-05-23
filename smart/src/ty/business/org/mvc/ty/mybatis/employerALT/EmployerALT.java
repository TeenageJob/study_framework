package org.mvc.ty.mybatis.employerALT;

import java.util.List;
import java.util.Map;

public interface EmployerALT {

    List<Map<String, String>> getBaseNumber(Map paramMap);

    /**
     * 医疗
     */
    void saveAD13A_r(Map paramMap);

    /**
     * 生育
     */
    void saveAD13B_r(Map paramMap);

    /**
     * 失业
     */
    void saveAD13C_r(Map paramMap);

    /**
     * 养老
     */
    void saveAD13D_r(Map paramMap);

    /**
     * 工伤
     */
    void saveAD13E_r(Map paramMap);

    /**
     * 医疗
     */
    void fuheAD13A(Map paramMap);

    /**
     * 生育
     */
    void fuheAD13B(Map paramMap);

    /**
     * 失业
     */
    void fuheAD13C(Map paramMap);

    /**
     * 养老
     */
    void fuheAD13D(Map paramMap);

    /**
     * 工伤
     */
    void fuheAD13E(Map paramMap);

    /**
     * 医疗
     */
    void saveAD13A_p(Map paramMap);

    /**
     * 生育
     */
    void saveAD13B_p(Map paramMap);

    /**
     * 失业
     */
    void saveAD13C_p(Map paramMap);

    /**
     * 养老
     */
    void saveAD13D_p(Map paramMap);

    /**
     * 工伤
     */
    void saveAD13E_p(Map paramMap);

    /**
     * 医疗保险
     */
    List<Map> queryAD13A_r(Map paramMap);

    /**
     * 生育保险
     */
    List<Map> queryAD13B_r(Map paramMap);

    /**
     * 失业保险
     */
    List<Map> queryAD13C_r(Map paramMap);

    /**
     * 养老保险
     */
    List<Map> queryAD13D_r(Map paramMap);

    /**
     * 工伤保险
     */
    List<Map> queryAD13E_r(Map paramMap);

    /**
     * 医疗保险
     */
    List<Map> queryAD13A_p(Map paramMap);

    /**
     * 生育保险
     */
    List<Map> queryAD13B_p(Map paramMap);

    /**
     * 失业保险
     */
    List<Map> queryAD13C_p(Map paramMap);

    /**
     * 养老保险
     */
    List<Map> queryAD13D_p(Map paramMap);

    /**
     * 工伤保险
     */
    List<Map> queryAD13E_p(Map paramMap);
}
