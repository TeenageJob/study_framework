package org.mvc.ty.employer.employer_s.service.impl;

import org.mvc.ty.employer.employer_s.service.EmployerChangeSService;
import org.mvc.ty.mybatis.employer.Employer;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.List;
import java.util.Map;

@Service
public class EmployerChangeSServiceImpl extends BaseServiceImpl implements EmployerChangeSService {

    @MybatisInject
    Employer employer;

    @Override
    public List<Map<String, String>> getAllEmployerInfo() {
        return employer.getAllEmployerInfo();
    }

    @Override
    public List<Map<String, String>> getEmployerInsureInfo(String ABB001) {
        return employer.getEmployerInsureInfo(ABB001);
    }

    @MybatisSession
    @Override
    public void saveYw(Map paramMap) {
        employer.saveInsureYw(paramMap);
        employer.saveInsureYwBank(paramMap);
    }
    @MybatisSession
    @Override
    public void fuheYw(String buId) {
        employer.updateYwBank(buId);
        employer.updateYwInsure(buId);
    }
}
