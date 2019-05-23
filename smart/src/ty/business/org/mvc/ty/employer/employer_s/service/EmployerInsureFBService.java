package org.mvc.ty.employer.employer_s.service;


import org.smart.plugin.common.IBaseService;

import java.util.Map;

public interface EmployerInsureFBService extends IBaseService {

    /**
     * 办理业务
     */
    void saveYw(Map<String, Object> paramMap) throws Exception;


}
