package org.mvc.ty.employer.employer_s.service;


import org.smart.plugin.common.IBaseService;

import java.util.Map;

public interface EmployerJoinFBService {

    /**
     * 办理业务
     */
    void saveYw(Map<String, Object> paramMap) throws Exception;

    void fuheYw(String processInstanceId) throws Exception;


}
