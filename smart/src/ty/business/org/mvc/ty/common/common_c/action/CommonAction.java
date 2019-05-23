package org.mvc.ty.common.common_c.action;

import org.mvc.ty.common.common_c.service.CommonService;
import org.mvc.ty.common.vo.MenusVO;
import org.mvc.ty.start.StartHelper;
import org.plugin.security.annotation.*;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.DataContext;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;
import org.smart.plugin.common.util.PageUtil;

/**
 * 登陆Action <br>
 * 用于用户登陆
 *
 * @author TY
 * @Time 2017年11月4日 下午4:33:39
 * @since 1.0.0
 */
@Action("common")
public class CommonAction extends BaseAction {
    @Inject
    private CommonService commonService;

    @Request.Post("test.do")
    public View execute() {
        return new View("login");
    }


    /**
     * 登录成功
     * <p>
     * <br>
     * create by on TY <br>
     * 2018年1月7日 下午6:30:40
     *
     * @return
     */
    @Request.Get("index.do")
    public View Login() {
        MenusVO menusVO = commonService.getLoginInfo();
        DataContext.Request.put("INFO", menusVO);
        return new View("index");
    }

    /**
     * 注销
     * <p>
     * <br>
     * create by on TY <br>
     * 2018年1月7日 下午6:30:53
     *
     * @return
     */
    @Request.Get("loginOut.do")
    public View loginOutAction() {
        commonService.loginOut();
        return execute();
    }

    /**
     * 进入注册页面
     * <p>
     * <br>
     * create by on TY 2017年11月22日 上午9:02:48
     *
     * @return
     */
    @Request.Post("register.do")
    public View goRegisterAction() {
        return new View("register");
    }

    /**
     * 注册用户
     * <p>
     * <br>
     * create by on TY <br>
     * 2017年11月21日 下午3:23:01
     *
     * @param params
     * @return 页面
     */
    @Request.Post("registers.do")
    public Result registerAction(Params params) {
        try {
            commonService.register(params);
        } catch (Exception e) {
            PageUtil.setMessage("注册失败", "warn");

        }
        return new Result(true);
    }

    /**
     * 刷新菜单缓存
     *
     * @return
     */
    @Request.Post("clearMenuCache.do")
    public Result clearMenuCache() {
        StartHelper.start();
        return new Result(true);
    }

    /**
     * 跳转到404页面
     */
    @Request.Post("notFoundPage.do")
    public View notFoundPage() {
        return new View("error/404", "html");
    }

    /**
     * 跳转到未授权页面
     *
     * @return
     */
    @Request.Get("unauthorized.do")
    public View unauthorized() {
        return new View("error/403");
    }

    /**
     * 认证测试
     * <p>
     * <br>
     * create by on TY 2017年11月21日 下午4:52:35
     *
     * @return
     */
    @Authenticated
    @Request.Post("test")
    public Result test() {
        return new Result(true);
    }

    /**
     * 游客认证
     * <p>
     * <br>
     * create by on TY 2017年11月21日 下午4:53:14
     *
     * @return
     */
    @Guest
    @Request.Post("test2")
    public Result test2() {
        return new Result(true);
    }

    /**
     * 是否已登录认证
     * <p>
     * <br>
     * create by on TY 2017年11月21日 下午4:52:44
     *
     * @return
     */
    @User
    @Request.Post("test3")
    public Result test3() {
        return new Result(true);
    }

    /**
     * 角色认证
     * <p>
     * <br>
     * create by on TY 2017年11月21日 下午4:53:24
     *
     * @return
     */
    @HasRoles("user")
    @Request.Post("test4")
    public Result test4() {
        return new Result(true);
    }

    /**
     * 权限认证
     * <p>
     * <br>
     * create by on TY 2017年11月21日 下午4:53:32
     *
     * @return
     */
    @HasPermissions("ty.view")
    @Request.Post("test5")
    public Result test5() {
        return new Result(true);
    }

}
