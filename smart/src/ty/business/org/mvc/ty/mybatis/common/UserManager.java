package org.mvc.ty.mybatis.common;

import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserManager {

    /**
     * 获取全部用户
     * @return
     */
    List<UserVO> getAllUser();

    /**
     * 获取用户
     * @param paramMap
     * @return
     */
    List<UserInformationVO> getData(Map<String, String> paramMap);

    /**
     * 保存用户
     * @param userInformationVO
     * @return
     */
    int saveUserInfo(UserInformationVO userInformationVO);

    List<String> getAllRoleList();

    void setUerRole(Map<String, String> paramMap);

}
