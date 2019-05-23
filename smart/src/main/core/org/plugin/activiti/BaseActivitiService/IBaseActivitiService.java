package org.plugin.activiti.BaseActivitiService;

import org.smart.framework.mvc.bean.Params;

public interface IBaseActivitiService {

    /**
     * 经办业务
     */
   void saveYw(Params params) throws Exception;

    /**
     * 审核业务
     */
    void checkYw(String processInstanceId) throws Exception;

    /**
     *撤销业务
     */
    void revocateYw(String processInstanceId) throws Exception;

    /**
     * 回退业务
     */
    void rollbackYw(String processInstanceId) throws Exception;

}
