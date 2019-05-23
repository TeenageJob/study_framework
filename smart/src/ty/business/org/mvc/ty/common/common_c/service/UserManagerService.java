package org.mvc.ty.common.common_c.service;

import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;
import org.smart.framework.mvc.bean.Params;

import java.util.List;

public interface UserManagerService {

    /**
     * 获取所有用户
     *
     * @return
     */
    List<UserVO> getAllUser();

    /**
     * 保存用户信息
     */
    boolean saveUserInfo(Params params);

    /**
     * 获取用户信息
     *
     * @param params
     * @return
     */
    UserInformationVO getData(Params params);

    List<String> getAllUserList();

    List<String> getAllRoleList();

    void setUserRole(Params params);
}
