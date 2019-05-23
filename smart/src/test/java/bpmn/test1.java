package bpmn;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;


public class test1 {

    public static void main(String[] args){
        // 创建流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//      ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        System.out.println(processEngine);
        // 得到流程存储服务组件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 得到运行时服务组件
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 获取流程任务组件
        TaskService taskService = processEngine.getTaskService();
        // 部署流程定义文件
        repositoryService.createDeployment().addClasspathResource("bpmn/helloworld.bpmn").deploy();
        // 启动流程
        runtimeService.startProcessInstanceByKey("HelloWorld");
        // 查询第一个任务
        Task task = taskService.createTaskQuery().singleResult();
        System.out.println("第一个任务完成前，当前任务名称:"+task.getName());
        // 完成第一个任务
        taskService.complete(task.getId());
        // 查询第二个任务
        task = taskService.createTaskQuery().singleResult();
        System.out.println("第二个任务完成前，当前任务名称:"+task.getName());
        // 完成第二个任务(流程结束)
        taskService.complete(task.getId());
        task = taskService.createTaskQuery().singleResult();
        System.out.println("流程结束后，查找任务：" + task);

    }

    //创建核心引擎对象

    /**
     * 部署流程定义
     */
    @Test
    public void deploymentProcessDefinition() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
                .createDeployment()// 创建一个部署对象
                .name("helloworld入门程序")// 添加部署的名称
                .addClasspathResource("bpmn/helloworld.bpmn")// classpath的资源中加载，一次只能加载
                // 一个文件
                .addClasspathResource("bpmn/helloworld.png")// classpath的资源中加载，一次只能加载
                // 一个文件
                .deploy();// 完成部署
        System.out.println("部署ID:" + deployment.getId());
        System.out.println("部署名称：" + deployment.getName());
    }

    /**
     * 启动流程实例
     */
    @Test
    public void startProcessInstance() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程定义的key
        String processDefinitionKey = "HelloWorld";
        ProcessInstance pi = processEngine.getRuntimeService()// 于正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应hellworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        System.out.println("流程实例ID:" + pi.getId());// 流程实例ID 101
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId()); // 流程定义ID HelloWorld:1:4
    }


    /**
     * 查询当前人的个人任务
     */
    @Test
    public void findMyPersonTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String assignee = "张三";
        List<Task> list = processEngine.getTaskService()// 与正在执行的认为管理相关的Service
                .createTaskQuery()// 创建任务查询对象
                .taskAssignee(assignee)// 指定个人认为查询，指定办理人
                .list();

        if (list != null && list.size() > 0) {
            for (Task task:list) {
                System.out.println("任务ID:"+task.getId());
                System.out.println("任务名称:"+task.getName());
                System.out.println("任务的创建时间"+task);
                System.out.println("任务的办理人:"+task.getAssignee());
                System.out.println("流程实例ID:"+task.getProcessInstanceId());
                System.out.println("执行对象ID:"+task.getExecutionId());
                System.out.println("流程定义ID:"+task.getProcessDefinitionId());
                System.out.println("#################################");
            }
        }
    }

    /**
     * 完成我的任务
     */
    @Test
    public void completeMyPersonTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //任务Id
        String taskId="2501";
        processEngine.getTaskService()//与正在执行的认为管理相关的Service
                .complete(taskId);
        System.out.println("完成任务:任务ID:"+taskId);

    }
}
