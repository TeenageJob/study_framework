package org.plugin.activiti.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class SmartTaskListener implements ExecutionListener {



    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        System.out.println("xml任务：" + delegateExecution.getId() + " DelegateExecution" + this.toString());

    }
}
