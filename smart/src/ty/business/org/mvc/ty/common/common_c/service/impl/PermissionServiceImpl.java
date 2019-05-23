package org.mvc.ty.common.common_c.service.impl;

import org.mvc.ty.common.common_c.service.PermissionService;
import org.mvc.ty.common.common_s.service.PermissionFBService;
import org.mvc.ty.common.common_s.service.PermissionFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.JsonUtil;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Inject
    private PermissionFQService permissionFQService;
    @Inject
    private PermissionFBService permissionFBService;

    @Override
    public List<?> getAllRoleName() {
        return permissionFQService.getAllRoleName();
    }

    @Override
    public TreeVO getTreeDataByMenu() {
        return permissionFQService.getTreeDataByMenu();
    }

    @Override
    public List getRolePermissionPage(Params params) {
        Map<String, String> paramMpa = new HashMap<>();
        paramMpa.put("role", params.getString("role"));
        return permissionFQService.getRolePermissionPage(paramMpa);
    }

    @Override
    public boolean updateRolePage(Params param) {
        List<String> add = JsonUtil.parseArray(param.getString("add"), String.class);
        List<String> del = JsonUtil.parseArray(param.getString("del"), String.class);
        if(CollectionUtil.isEmpty(add)&&CollectionUtil.isEmpty(del)){
            return false;
        }
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("add",add);
        paramMap.put("del",del);
        paramMap.put("role",param.getString("role"));
        return permissionFBService.updateRolePage(paramMap);
    }
}
