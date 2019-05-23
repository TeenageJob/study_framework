package org.mvc.ty.activiti.action;

import org.mvc.ty.activiti.service.ConfigProcessService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.impl.BaseAction;

import java.util.Map;

/**
 * 配置流程
 */
@Action("configProcess")
public class ConfigProcessAction extends BaseAction {


    @Inject
    private ConfigProcessService configProcessService;

    @Request.Post("index.do")
    public View execute(){
        setSelectInputList("li_page", configProcessService.getService());
        setSelectInputList("sl_model", configProcessService.getModels());
        return new View("activiti/configProcess");
    }

    @Request.Post("saveProcess.do")
    public Result saveProcess(Params params){
        configProcessService.saveProcess(params);
        return new Result(true);
    }

    @Request.Post("getAction.do")
    public String getAction(Params params){
        Map map = configProcessService.getAction(params);
        if (MapUtil.isNotEmpty(map)) {
            setData("sl_model",map.get("model"));
            setData("txt_action", map.get("action"));
            setData("txt_service", map.get("service"));
            setFocus("txt_action");
            setReadOnly("txt_page");
        }
        return JSON;
    }
}
