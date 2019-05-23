package org.mvc.ty.activiti.action;

import org.activiti.engine.task.Task;
import org.mvc.ty.activiti.service.TaskService;
import org.plugin.activiti.vo.RollbackHtmlVO;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Action("task")
public class TaskAction extends BaseAction {

    @Inject
    private TaskService taskService;

    @Request.Post("index.do")
    public View execute() {
        View view = new View("activiti/task-list");
        List<Task> list = taskService.getUserTaskList();
        view.put("taskList", list);
        List<Map> val = new ArrayList<>();
        for (Task task : list) {
            Map map = new HashMap();
            map.put("id", task.getId());
            map.put("name", task.getName());
            map.put("processInstanceId", task.getProcessInstanceId());
            map.put("processDefinitionId", task.getProcessDefinitionId());
            map.put("createTime", task.getCreateTime());
            map.put("assignee", task.getAssignee());
            val.add(map);
        }

        setList("grid_taskList", val);
        return view;
    }

    /**
     * 签收任务
     *
     * @param params
     * @return
     */
    @Request.Post("claim.do")
    public Result claim(Params params){
        taskService.claim(params);
        return new Result(true);
    }

    /**
     * 回显表单
     *
     * @param params
     * @return
     */
    @Request.Post("getform.do")
    public View getform(Params params){
        View view = new View("activiti/task-complete");
        view.put("taskId", params.getString("taskId"));
        RollbackHtmlVO rollbackHtmlVO = taskService.getform(params);
        if (rollbackHtmlVO == null) {
            return view;
        }
        view.put("html", rollbackHtmlVO.getHtml());
        view.put("service", rollbackHtmlVO.getService());
        return view;
    }

    /**
     * 完成任务
     *
     * @param params
     * @return
     */
    @Request.Post("completeTask.do")
    public Result completeTask(Params params){
        taskService.completeTask(params);
        return new Result(true);
    }

    /**
     * 回退任务
     *
     * @return
     */
    @Request.Post("rollbackTask.do")
    public Result rollbackTask(Params params){
        taskService.rollbackTask(params);
        return new Result(true);
    }

    /**
     * 取消任务
     *
     * @param params
     * @return
     */
    @Request.Post("cancelTask.do")
    public Result cancelTask(Params params){
        taskService.cancelTask(params);
        return new Result(true);
    }

}
