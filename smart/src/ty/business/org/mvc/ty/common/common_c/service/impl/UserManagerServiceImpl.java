package org.mvc.ty.common.common_c.service.impl;

import org.apache.shiro.crypto.hash.Hash;
import org.mvc.ty.common.common_c.service.UserManagerService;
import org.mvc.ty.common.common_s.service.UserManagerFBService;
import org.mvc.ty.common.common_s.service.UserManagerFQService;
import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.common.vo.UserVO;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Inject
    private UserManagerFQService userManagerFQService;
    @Inject
    private UserManagerFBService userManagerFBService;

    @Override
    public List<UserVO> getAllUser() {
        return userManagerFQService.getAllUser();
    }

    @Override
    public boolean saveUserInfo(Params params) {
        UserInformationVO userInformationVO=new UserInformationVO();
        userInformationVO.setEmail(params.getString("email"));
        userInformationVO.setOperator(params.getString("operator"));
        userInformationVO.setOperatorId(params.getString("operator_id"));
        userInformationVO.setOperatorOrganization(params.getString("operator_organzation"));
        userInformationVO.setPhone(params.getString("phone"));
        userInformationVO.setUsername(params.getString("username"));
        return userManagerFBService.saveUserInfo(userInformationVO);
    }

    @Override
    public UserInformationVO getData(Params params) {
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("username",params.getString("username"));
        return userManagerFQService.getData(paramMap);
    }

    @Override
    public List<String> getAllUserList(){
        return userManagerFQService.getAllUserList();
    }

    @Override
    public List<String> getAllRoleList() {
        return userManagerFQService.getAllRoleList();
    }

    @Override
    public void setUserRole(Params params) {
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("user",params.getString("user"));
        paramMap.put("role",params.getString("role"));
        userManagerFBService.setUerRole(paramMap);
    }
}
