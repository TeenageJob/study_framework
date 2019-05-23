package org.plugin.activiti.task;

import org.activiti.engine.TaskService;
import org.plugin.activiti.base.BaseActiviti;

public class TaskActiviti extends BaseActiviti {


    /**
     * 根据用户，查询任务
     * @param userId
     */
    public void queryTaskByUser(String userId){
        taskService.createTaskQuery().taskCandidateUser(userId).singleResult();
    }

    public void claimTask(){

    }



}
