package org.plugin.activiti.task;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskExecuteListener implements  TaskListener {


    @Override
    public void notify(DelegateTask delegateTask) {
        //指定个人任务
        //delegateTask.setAssignee("zhangsan");
        //指定组
        delegateTask.addCandidateGroup("salesmane");
        delegateTask.addCandidateUser("zhangsan");
        delegateTask.addCandidateUser("lisi");
    }
}
