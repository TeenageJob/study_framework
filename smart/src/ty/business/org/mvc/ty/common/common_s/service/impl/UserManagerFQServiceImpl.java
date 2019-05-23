package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.UserManagerFQService;
import org.mvc.ty.common.common_s.service.UserManagerSService;
import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserManagerFQServiceImpl implements UserManagerFQService {

    @Inject
    private UserManagerSService userManagerSService;

    @Override
    public List<UserVO> getAllUser() {
        return userManagerSService.getAllUser();
    }

    @Override
    public UserInformationVO getData(Map<String, String> paramMap) {
        return userManagerSService.getData(paramMap);
    }

    /**
     * 获取所有用户，返回用户名和id
     */
    @Override
    public List<String> getAllUserList() {
        List<String> list = new ArrayList<>();
        List<UserVO> allUser = userManagerSService.getAllUser();
        for (UserVO userVO : allUser) {
            list.add(userVO.getId() + "," + userVO.getUsername());
        }
        return list;
    }

    /**
     * 获取所有角色
     */
    @Override
    public List<String> getAllRoleList() {
        return userManagerSService.getAllRoleList();
    }
}
