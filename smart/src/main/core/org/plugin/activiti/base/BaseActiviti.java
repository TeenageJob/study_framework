package org.plugin.activiti.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseActiviti {

    protected static ProcessEngineConfiguration config;
    /**
     * ProcessEngine实例代表一个流程引擎
     */
    protected static ProcessEngine engine;
    /**
     * RepositoryService：提供一系列管理流程定义和流程部署的API。
     */
    protected static RepositoryService repositoryService;
    /**
     * RuntimeService：在流程运行时对流程实例进行管理与控制。
     */
    protected static RuntimeService runtimeService;
    /**
     * TaskService：对流程任务进行管理，例如任务提醒、任务完成和创建任务等。
     */
    protected static TaskService taskService;
    /**
     * IdentityService：提供对流程角色数据进行管理的API，这些角色数据包括用户组、用户及它们之间的关系。
     */
    protected static IdentityService identityService;
    /**
     * ManagementService：提供对流程引擎进行管理和维护的服务。
     */
    protected static ManagementService managementService;
    /**
     * HistoryService：对流程的历史数据进行操作，包括查询、删除这些历史数据。
     */
    protected static HistoryService historyService;
    /**
     * DynamicBpmnService：使用该服务，可以不需要重新部署流程模型，就可以实现对流程模型的部分修改。
     */
    protected static DynamicBpmnService dynamicBpmnService;

    /**
     * 流程表单
     */
    protected static FormService formService;

    /**
     * 单例模式获取引擎对象
     */
    public static ProcessEngine getProcessEngine() {
        if (engine == null) {
            /*
             * 使用默认的配置文件名称（activiti.cfg.xml）创建引擎对象
             */
            engine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
            repositoryService = engine.getRepositoryService();
            runtimeService = engine.getRuntimeService();
            taskService = engine.getTaskService();
            identityService = engine.getIdentityService();
            managementService = engine.getManagementService();
            historyService = engine.getHistoryService();
            dynamicBpmnService = engine.getDynamicBpmnService();
            formService = engine.getFormService();
        }
        return engine;
    }

    public static ProcessEngineConfiguration getConfig() {
        return config;
    }

    public static ProcessEngine getEngine() {
        return engine;
    }

    public static RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public static RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public static TaskService getTaskService() {
        return taskService;
    }

    public static IdentityService getIdentityService() {
        return identityService;
    }

    public static ManagementService getManagementService() {
        return managementService;
    }

    public static HistoryService getHistoryService() {
        return historyService;
    }

    public static DynamicBpmnService getDynamicBpmnService() {
        return dynamicBpmnService;
    }

    public static FormService getFormService() {
        return formService;
    }
}
