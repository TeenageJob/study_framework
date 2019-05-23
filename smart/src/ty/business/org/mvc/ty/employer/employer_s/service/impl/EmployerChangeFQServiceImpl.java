package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_s.service.EmployerChangeFQService;
import org.mvc.ty.employer.employer_s.service.EmployerChangeSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.List;
import java.util.Map;

@Service
public class EmployerChangeFQServiceImpl extends BaseServiceImpl implements EmployerChangeFQService {

    @Inject
    private EmployerChangeSService employerChangeSService;


    @Override
    public List<Map<String, String>> getAllEmployeeInfo() {
         return employerChangeSService.getAllEmployerInfo();
    }

    @Override
    public List<Map<String, String>> getEmployeeInsureInfo(String ABB001) {
        return employerChangeSService.getEmployerInsureInfo(ABB001);
    }
}
