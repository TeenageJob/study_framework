package org.mvc.ty.activiti.service;

import org.activiti.engine.task.Task;
import org.plugin.activiti.vo.RollbackHtmlVO;
import org.smart.framework.mvc.bean.Params;

import java.util.List;

public interface TaskService {


    /**
     * 获取用户所有任务
     * @return
     */
    List<Task> getUserTaskList();


    /**
     * 办理业务，回显页面
     */
    RollbackHtmlVO getform(Params params);

    /**
     * 取消任务
     * @param params
     */
    void cancelTask(Params params);

    /**
     * 回退任务
     * @param params
     */
    void rollbackTask(Params params);

    /**
     * 完成任务
     * @param params
     */
    void completeTask(Params params);

    /**
     * 签收任务
     * @param params
     */
    void claim(Params params);

}
