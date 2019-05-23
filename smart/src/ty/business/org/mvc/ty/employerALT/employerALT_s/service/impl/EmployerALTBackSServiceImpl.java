package org.mvc.ty.employerALT.employerALT_s.service.impl;


import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTBackSService;
import org.mvc.ty.mybatis.employerALT.EmployerALT;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmployerALTBackSServiceImpl implements EmployerALTBackSService {

    @MybatisInject
    EmployerALT employerALT;

    @Override
    public List<Map> queryAD13A(Map paramMap) {
        return employerALT.queryAD13A_p(paramMap);
    }

    @Override
    public List<Map> queryAD13B(Map paramMap) {
        return employerALT.queryAD13B_p(paramMap);
    }

    @Override
    public List<Map> queryAD13C(Map paramMap) {
        return employerALT.queryAD13C_p(paramMap);
    }

    @Override
    public List<Map> queryAD13D(Map paramMap) {
        return employerALT.queryAD13D_p(paramMap);
    }

    @Override
    public List<Map> queryAD13E(Map paramMap) {
        return employerALT.queryAD13E_p(paramMap);
    }





    @Override
    public void saveAD13A(Map paramMap) {
        employerALT.saveAD13A_p(paramMap);
    }

    @Override
    public void saveAD13B(Map paramMap) {
        employerALT.saveAD13B_p(paramMap);
    }

    @Override
    public void saveAD13C(Map paramMap) {
        employerALT.saveAD13C_p(paramMap);
    }

    @Override
    public void saveAD13D(Map paramMap) {
        employerALT.saveAD13D_p(paramMap);
    }

    @Override
    public void saveAD13E(Map paramMap) {
        employerALT.saveAD13E_p(paramMap);
    }



    @MybatisSession
    @Override
    public void fuheYw(String buId) {
        Map paramMap=new HashMap();
        paramMap.put("AAA00A",buId);
        paramMap.put("flag","2");
        employerALT.fuheAD13A(paramMap);
        employerALT.fuheAD13B(paramMap);
        employerALT.fuheAD13C(paramMap);
        employerALT.fuheAD13D(paramMap);
        employerALT.fuheAD13E(paramMap);
    }
}
