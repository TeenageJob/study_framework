package org.mvc.ty.common.common_c.service.impl;

import org.mvc.ty.common.common_c.service.MenuManagerService;
import org.mvc.ty.common.common_s.service.MenuManagerFBService;
import org.mvc.ty.common.common_s.service.MenuManagerFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.JsonUtil;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuManagerServiceImpl implements MenuManagerService {

    @Inject
    private MenuManagerFQService menuManagerFQService;
    @Inject
    private MenuManagerFBService menuManagerFBService;

    @Override
    public TreeVO getTreeDataByMenu() {
        return menuManagerFQService.getTreeDataByMenu();
    }

    @Override
    public boolean addNode(Params params) {
        Map<String, Object> paramMap = params.getFieldMap();
        return menuManagerFBService.addNode(paramMap);
    }

    @Override
    public Boolean delNode(Params params) {
        Map<String, String> paramMap = new HashMap<>();
        List<String> list = JsonUtil.parseArray(params.getString("node"), String.class);
        switch (list.size()) {
            case 4: {
                paramMap.put("url_name", list.get(0));
                list.remove(0);
            }
            case 3: {
                paramMap.put("title", list.get(0));
                list.remove(0);
            }
            case 2: {
                paramMap.put("menu", list.get(0));
            }
        }
        return menuManagerFBService.delNode(paramMap);
    }

    @Override
    public boolean edtNode(Params params) {
        Map<String, Object> map = params.getFieldMap();
        return menuManagerFBService.edtNode(map);
    }


}
