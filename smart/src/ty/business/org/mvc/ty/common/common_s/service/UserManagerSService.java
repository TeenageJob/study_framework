package org.mvc.ty.common.common_s.service;

import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserManagerSService {

    /**
     * 获取所有用户
     *
     * @return
     */
    List<UserVO> getAllUser();

    /**
     * 获取用户
     */
    UserInformationVO getData(Map<String, String> paramMap);

    /**
     * 保存用户
     */
    boolean saveUserInfo(UserInformationVO userInformationVO);


    List<String> getAllRoleList();

    void setUerRole(Map<String, String> paramMap);
}
