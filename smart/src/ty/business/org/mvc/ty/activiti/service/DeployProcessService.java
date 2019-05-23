package org.mvc.ty.activiti.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;

public interface DeployProcessService {

    /**
     * 获取业务的id和名称
     * @return
     */
    List<String> getAllYwid();


    /**
     * 保存任务配置信息
     * @return
     */
    boolean save(Params params);
}
