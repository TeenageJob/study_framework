package org.mvc.ty.common.common_s.service.impl;

import org.mvc.ty.common.common_s.service.MenuManagerSService;
import org.mvc.ty.common.vo.BusinessTitleVO;
import org.mvc.ty.common.vo.BusinessUrlVO;
import org.mvc.ty.common.vo.MenuVO;
import org.mvc.ty.mybatis.common.Common;
import org.mvc.ty.start.StartHelper;
import org.plugin.cache.smart.Cache;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.PinyinConvertUtil;
import org.smart.framework.util.StringUtil;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuManagerSServiceImpl implements MenuManagerSService {


    /**
     * 获取mybatis接口
     */
    @MybatisInject
    private Common common;
    @MybatisSession
    @Override
    public TreeVO getTreeDataByMenu() {
        Cache<Object, Object> cache = StartHelper.getCache();

        Map<String, MenuVO> menuCache = (Map<String, MenuVO>) cache.get("menus");//所有菜单

        TreeVO treeVO = new TreeVO();
        treeVO.setText("菜单");
        for (Map.Entry<String, MenuVO> map : menuCache.entrySet()) {
            TreeVO treeVO1 = new TreeVO();
            treeVO1.setText(map.getValue().getLabel_name());
            treeVO1.setIcon(map.getValue().getSpan_class());
            treeVO1.setIconColor(map.getValue().getSpan_style());
            treeVO.addChrildren(treeVO1);
            for (Map.Entry<String, BusinessTitleVO> mpas : map.getValue().getBusiness().entrySet()) {
                TreeVO treeVO2 = new TreeVO();
                treeVO2.setText(mpas.getValue().getTitle_name());
                treeVO2.setIcon(mpas.getValue().getSpan_class());
                treeVO1.addChrildren(treeVO2);
                for (BusinessUrlVO list : mpas.getValue().getBusiness_url()) {
                    TreeVO treeVO3 = new TreeVO();
                    treeVO3.setText(list.getUrl_name());
                    treeVO3.setHref(list.getUrl());
                    treeVO3.setId(list.getPermission());
                    treeVO2.addChrildren(treeVO3);
                }
            }
        }
        return treeVO;
    }

    @MybatisSession
    @Override
    public boolean addNode(Map<String, Object> paramMap) {
        if (paramMap.get("menu").equals("")) {
            return false;
        }
        if (!paramMap.get("url").equals("")) {
            String permission = PinyinConvertUtil.ToPinyin(paramMap.get("title").toString()) + ":" + PinyinConvertUtil.ToPinyin(paramMap.get("url_name").toString());
            paramMap.put("permission", permission);
            common.addUrlNode(paramMap);
            common.addPermission(paramMap);
        } else if (!paramMap.get("title").equals("")) {
            paramMap.put("id_flag", "heading" + PinyinConvertUtil.ToPinyin(paramMap.get("title").toString()));
            paramMap.put("collapse", "collapse" + PinyinConvertUtil.ToPinyin(paramMap.get("title").toString()));
            common.addTitleNode(paramMap);
        } else {
            paramMap.put("tab_id", PinyinConvertUtil.ToPinyin(paramMap.get("menu").toString()));
            paramMap.put("warp_id", PinyinConvertUtil.ToPinyin(paramMap.get("menu").toString()) + "_warp");
            common.addMenuNode(paramMap);
        }
        return true;
    }
    @MybatisSession
    @Override
    public Boolean delNode(Map<String, String> paramMap) {
        Map<String, String> map = new HashMap<>();
        switch (paramMap.size()) {
            case 1://删除菜单项
                map.put("value", paramMap.get("menu"));
                map.put("key", "label_name");
                common.delMenu(map);
                common.delTitle(map);
                common.delUrl(map);
                break;
            case 2://删除标题项
                map.put("value", paramMap.get("title"));
                map.put("key", "title_name");
                common.delTitle(map);
                common.delUrl(map);
                break;
            case 3://删除页面项
                map.put("value", paramMap.get("url_name"));
                map.put("key", "url_name");
                common.delUrl(map);
                break;
        }
        return true;
    }
    @MybatisSession
    @Override
    public boolean edtNode(Map<String, Object> paramMap) {
        if (StringUtil.isNotEmpty(paramMap.get("url_name").toString())) {
            common.edtNodeUrl(paramMap);
        } else if (StringUtil.isNotEmpty(paramMap.get("title").toString())) {
            common.edtNodeTitle(paramMap);
        } else if (StringUtil.isNotEmpty(paramMap.get("menu").toString())) {
            common.edtNodeMenu(paramMap);
        } else {
            return false;
        }
        return true;
    }
}
