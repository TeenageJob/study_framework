package org.mvc.ty.common.common_s.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mvc.ty.common.common_s.service.CommonSService;
import org.mvc.ty.common.vo.BusinessTitleVO;
import org.mvc.ty.common.vo.BusinessUrlVO;
import org.mvc.ty.common.vo.MenuVO;
import org.mvc.ty.common.vo.MenusVO;
import org.mvc.ty.common.vo.RoleMenuVO;
import org.mvc.ty.mybatis.common.Common;
import org.mvc.ty.start.StartHelper;
import org.plugin.activiti.ProcessHelper;
import org.plugin.cache.smart.Cache;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.plugin.security.SecurityHelper;
import org.plugin.security.fault.ExcessiveAttemptsException;
import org.plugin.security.fault.LoginException;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.CastUtil;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.MapUtil;
import org.smart.framework.util.ValidataUtil;

@Service
public class CommonSServiceImpl implements CommonSService {

    /**
     * 获取mybatis接口
     */
    @MybatisInject
    private Common common;

    @Override
    public boolean login(Map<String, String> paramMap) {
        try {
            SecurityHelper.login(paramMap.get("account"), paramMap.get("password"),
                    CastUtil.castBoolean(paramMap.get("isRememberMe")));
        } catch (LoginException e) {
            throw new LoginException("登录失败");
        } catch (ExcessiveAttemptsException e) {
            throw new ExcessiveAttemptsException("登录次数过多");
        }
        return true;
    }

    @Override
    public boolean loginOut() {
        SecurityHelper.logout();
        return true;
    }

    @MybatisSession
    @Override
    public boolean register(Map<String, Object> paramMap) {
        try {
            common.insertUser(paramMap);
            common.addUserInfo(paramMap);
            ProcessHelper.createUser(paramMap.get("username").toString(),
                    paramMap.get("username").toString(), paramMap.get("username").toString()
                    , paramMap.get("email").toString(), paramMap.get("password").toString());
            ProcessHelper.addGroupMember(paramMap.get("username").toString(), "salesmane");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取信息： <br>
     * 1 经办人信息 <br>
     * 2 菜单信息 <br>
     * 3 业务功能信息
     */
    @Override
    public MenusVO getLoginInfo() {
        MenusVO menusVO = new MenusVO();

        Map<String, String> paramMap = new HashMap<>();


        long one = new Date().getTime();
        Set<String> stringPermissions = (Set<String>) SecurityHelper.getStringPermissions();//获取用户权限
        Set<String> roles = (Set<String>) SecurityHelper.getRoles();//获取用户角色

        paramMap.put("username", SecurityHelper.getUsername());
        menusVO.setUserInformationVO(common.getUserInfo(paramMap));

        Cache<Object, Object> cache = StartHelper.getCache();

        cache.put("userInfo", menusVO.getUserInformationVO());

        @SuppressWarnings("unchecked")
        Map<String, MenuVO> menuCache = (Map<String, MenuVO>) cache.get("menus");//所有菜单
        @SuppressWarnings("unchecked")
        List<RoleMenuVO> rmCache = (List<RoleMenuVO>) cache.get("rolemenu");//角色对应菜单
        Set<String> menus = new HashSet<>();
        // 获取该用户角色下的所有菜单
        for (RoleMenuVO r : rmCache) {
            if (roles.contains(r.getRole())) {
                menus.add(r.getMenu());
            }
        }
        // 去除没有的菜单、标题、资源
        final Map<String, MenuVO> mc = new HashMap<>(menuCache);
        for (String key : mc.keySet()) {
            if (!menus.contains(key)) {// 除去没有的菜单的项目
                menuCache.remove(key);
                //menuCache.get(key).setBusiness(null);
            } else {
                Map<String, BusinessTitleVO> business = menuCache.get(key).getBusiness();
                final Map<String, BusinessTitleVO> bs = new HashMap<>(business);
                for (String titlekey : bs.keySet()) {// 除去没有的标题
                    List<BusinessUrlVO> business_url = business.get(titlekey).getBusiness_url();
                    final List<BusinessUrlVO> burl = new ArrayList<>(business_url);
                    for (BusinessUrlVO bu : burl) {// 除去没有的资源
                        boolean flag = false;
                        for (String permission : stringPermissions) {
                            if (ValidataUtil.stringLike(permission, bu.getPermission())) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            business_url.remove(bu);
                        }
						/*if (!stringPermissions.contains(bu.getPermission())) {
							business_url.remove(bu);
						}*/
                    }
                    if (CollectionUtil.isEmpty(business_url)) {
                        business.remove(titlekey);
                    }
                }
                //出去没有的菜单，不用
				/*if (MapUtil.isEmpty(business)) {
					menuCache.remove(key);
				}*/
            }
        }
        long two = new Date().getTime();
        System.out.println("加载页面花费了：" + (two - one) + "  毫秒时间");
        menusVO.setMenu(menuCache);
        return menusVO;
    }
}
