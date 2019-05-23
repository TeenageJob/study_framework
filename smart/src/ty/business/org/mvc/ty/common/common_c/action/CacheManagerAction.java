package org.mvc.ty.common.common_c.action;

import org.mvc.ty.start.StartHelper;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("cache")
public class CacheManagerAction extends BaseAction{

    @Request.Post("cacheAction.do")
    public View execute(){
        return new View("cache/cache");
    }

    @Request.Post("clearMenuCache.do")
    public Result clearMenuCache(){
        StartHelper.start();
        return new Result(true);
    }
}
