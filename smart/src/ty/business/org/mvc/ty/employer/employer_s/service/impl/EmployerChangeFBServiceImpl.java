package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_s.service.EmployerChangeFBService;
import org.mvc.ty.employer.employer_s.service.EmployerChangeSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.List;
import java.util.Map;

@Service
public class EmployerChangeFBServiceImpl extends BaseServiceImpl implements EmployerChangeFBService {

    @Inject
    private EmployerChangeSService employerChangeSService;


    @Override
    public List<Map<String,String>> getAllEmployeeInfo() {
        return employerChangeSService.getAllEmployerInfo();
    }

    @Override
    public void saveYw(Map paramMap) {
        employerChangeSService.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String buId) {
        employerChangeSService.fuheYw(buId);
    }
}
