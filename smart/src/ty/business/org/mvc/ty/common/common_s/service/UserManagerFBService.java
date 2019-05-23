package org.mvc.ty.common.common_s.service;

import org.mvc.ty.common.vo.UserInformationVO;

import java.util.Map;

public interface UserManagerFBService {

    /**
     * 保存用户
     */
    boolean saveUserInfo(UserInformationVO userInformationVO);

    void setUerRole(Map<String,String> paramMap);
}
