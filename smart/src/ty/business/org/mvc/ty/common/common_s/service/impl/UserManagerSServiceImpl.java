package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.UserManagerSService;
import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;
import org.mvc.ty.mybatis.common.UserManager;
import org.plugin.mybatis.MybatisInject;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.CollectionUtil;

import java.util.List;
import java.util.Map;

@Service
public class UserManagerSServiceImpl implements UserManagerSService {


    @MybatisInject
    private UserManager userManager;

    @Override
    public List<UserVO> getAllUser() {
        return userManager.getAllUser();
    }

    @Override
    public UserInformationVO getData(Map<String, String> paramMap) {
        List<UserInformationVO> list = userManager.getData(paramMap);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean saveUserInfo(UserInformationVO userInformationVO) {
        userManager.saveUserInfo(userInformationVO);
        return true;
    }

    @Override
    public List<String> getAllRoleList() {
        return userManager.getAllRoleList();
    }

    @Override
    public void setUerRole(Map<String, String> paramMap) {
        userManager.setUerRole(paramMap);
    }
}
