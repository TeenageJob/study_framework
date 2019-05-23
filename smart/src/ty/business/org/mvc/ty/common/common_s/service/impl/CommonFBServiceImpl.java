package org.mvc.ty.common.common_s.service.impl;

import java.util.Map;

import org.mvc.ty.common.common_s.service.CommonFBService;
import org.mvc.ty.common.common_s.service.CommonSService;
import org.plugin.activiti.ProcessHelper;
import org.plugin.security.SecurityHelper;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

@Service
public class CommonFBServiceImpl implements CommonFBService {

    @Inject
    private CommonSService loginSService;

    @Override
    public boolean register(Map<String, Object> paramMap) throws Exception {
        String password = SecurityHelper.encrypt(paramMap.get("password").toString(), paramMap.get("username").toString());
        paramMap.put("password", password);


        return loginSService.register(paramMap);
    }

}
