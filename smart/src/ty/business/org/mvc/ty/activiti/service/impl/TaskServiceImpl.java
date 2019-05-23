package org.mvc.ty.activiti.service.impl;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.mvc.ty.activiti.service.TaskService;
import org.plugin.activiti.base.BaseActiviti;
import org.plugin.activiti.vo.RollbackHtmlVO;
import org.plugin.security.SecurityHelper;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.StringUtil;
import org.smart.plugin.common.ActivitiBPMN;

import java.util.List;

@Service
public class TaskServiceImpl extends ActivitiBPMN implements TaskService {

    public List<Task> getUserTaskList() {
        List<Task> list = BaseActiviti.getTaskService().createTaskQuery().
                taskCandidateOrAssigned(SecurityHelper.getUsername()).list();
        return list;
    }

    @Override
    public RollbackHtmlVO getform(Params params) {
        String taskId = params.getString("taskId");
        Task task = BaseActiviti.getTaskService().createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        ProcessInstance processInstance = BaseActiviti.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        String businesssKey = processInstance.getBusinessKey();
        return getHtml(businesssKey);
    }

    @Override
    public void cancelTask(Params params) {
        try {
            String taskId = params.getString("taskId");
            String service = params.getString("service");
            Task task = BaseActiviti.getTaskService().createTaskQuery().taskId(taskId).singleResult();
            String processInstanceId = task.getProcessInstanceId();
            if (StringUtil.isNotEmpty(service)) {
                callServiceRevocateYw(service, processInstanceId);
            }
            BaseActiviti.getRuntimeService().deleteProcessInstance(processInstanceId, "ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollbackTask(Params params) {
        try {
            String taskId = params.getString("taskId");
            String service = params.getString("service");
            Task task = BaseActiviti.getTaskService().createTaskQuery().taskId(taskId).singleResult();
            String processInstanceId = task.getProcessInstanceId();
            if (StringUtil.isNotEmpty(service)) {
                callServiceRollbackYw(service, processInstanceId);
            }
            BaseActiviti.getTaskService().setAssignee(taskId, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completeTask(Params params) {
        try {
            String taskId = params.getString("taskId");
            String service = params.getString("service");
            Task task = BaseActiviti.getTaskService().createTaskQuery().taskId(taskId).singleResult();
            String processInstanceId = task.getProcessInstanceId();
            if (StringUtil.isNotEmpty(service)) {
                callServiceCheckYw(service, processInstanceId);
            }
            BaseActiviti.getTaskService().complete(taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void claim(Params params) {
        String taskId = params.getString("taskId");
        BaseActiviti.getTaskService().claim(taskId, SecurityHelper.getUsername());
    }


}
