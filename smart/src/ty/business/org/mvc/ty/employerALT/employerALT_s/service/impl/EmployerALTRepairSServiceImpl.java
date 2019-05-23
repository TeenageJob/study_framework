package org.mvc.ty.employerALT.employerALT_s.service.impl;


import org.mvc.ty.employerALT.employerALT_s.service.EmployerALTRepairSService;
import org.mvc.ty.mybatis.employerALT.EmployerALT;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmployerALTRepairSServiceImpl implements EmployerALTRepairSService {

    @MybatisInject
    EmployerALT employerALT;

    @Override
    public List<Map> queryAD13A(Map paramMap) {
        return employerALT.queryAD13A_r(paramMap);
    }

    @Override
    public List<Map> queryAD13B(Map paramMap) {
        return employerALT.queryAD13B_r(paramMap);
    }

    @Override
    public List<Map> queryAD13C(Map paramMap) {
        return employerALT.queryAD13C_r(paramMap);
    }

    @Override
    public List<Map> queryAD13D(Map paramMap) {
        return employerALT.queryAD13D_r(paramMap);
    }

    @Override
    public List<Map> queryAD13E(Map paramMap) {
        return employerALT.queryAD13E_r(paramMap);
    }

    @Override
    public void saveAD13A(Map paramMap) {
        employerALT.saveAD13A_r(paramMap);
    }

    @Override
    public void saveAD13B(Map paramMap) {
        employerALT.saveAD13B_r(paramMap);
    }

    @Override
    public void saveAD13C(Map paramMap) {
        employerALT.saveAD13C_r(paramMap);
    }

    @Override
    public void saveAD13D(Map paramMap) {
        employerALT.saveAD13D_r(paramMap);
    }

    @Override
    public void saveAD13E(Map paramMap) {
        employerALT.saveAD13E_r(paramMap);
    }

    @MybatisSession
    @Override
    public void fuheYw(String buId) {
        Map paramMap=new HashMap();
        paramMap.put("AAA00A",buId);
        paramMap.put("flag","1");
        employerALT.fuheAD13A(paramMap);
        employerALT.fuheAD13B(paramMap);
        employerALT.fuheAD13C(paramMap);
        employerALT.fuheAD13D(paramMap);
        employerALT.fuheAD13E(paramMap);
    }
}
