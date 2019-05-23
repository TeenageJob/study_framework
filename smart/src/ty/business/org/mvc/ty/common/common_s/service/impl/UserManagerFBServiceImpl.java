package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.UserManagerFBService;
import org.mvc.ty.common.common_s.service.UserManagerSService;
import org.mvc.ty.common.vo.UserInformationVO;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;

@Service
public class UserManagerFBServiceImpl implements UserManagerFBService {

    @Inject
    private UserManagerSService userManagerSService;
    @Override
    public boolean saveUserInfo(UserInformationVO userInformationVO) {
        return userManagerSService.saveUserInfo(userInformationVO);
    }


    @Override
    public void setUerRole(Map<String, String> paramMap) {
        userManagerSService.setUerRole(paramMap);
    }
}
