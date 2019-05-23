package org.mvc.ty.common.common_s.service;

import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserManagerFQService {

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
     * 获取所有用户，返回用户名和id
     */
    List<String> getAllUserList();

    /**
     * 获取所有角色
     */
    List<String> getAllRoleList();
}
