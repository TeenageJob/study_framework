package org.mvc.ty.activiti.action;

import org.mvc.ty.activiti.service.DeployProcessService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("deployProcess")
public class DeployProcessAction extends BaseAction {

    @Inject
    private DeployProcessService deployProcessService;

    @Request.Post("index.do")
    public View execute() {
        setSelectInputList("page_info", deployProcessService.getAllYwid());
        return new View("activiti/deployProcess");
    }

    @Request.Post("save.do")
    public Result save(Params params){
        deployProcessService.save(params);
        return new Result(true);
    }
}
