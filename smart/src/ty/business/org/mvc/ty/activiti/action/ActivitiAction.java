package org.mvc.ty.activiti.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.plugin.activiti.base.BaseActiviti;
import org.smart.framework.mvc.DataContext;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Page;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Action("activitis")
public class ActivitiAction  {

    @Request.Post("index.do")
    public View execute() {
        return new View("");
    }

    @Request.Post("getAllModel.do")
    @Deprecated
    public String getAllModel() {
        Map<String, Object> map = new HashMap<>();
        String modelId = "72501";
        try {
            Model modelData = BaseActiviti.getRepositoryService().getModel(modelId);
            byte[] s = BaseActiviti.getRepositoryService().getModelEditorSource(modelData.getId());
            ObjectNode modelNode = (ObjectNode) new ObjectMapper()
                    .readTree(BaseActiviti.getRepositoryService().getModelEditorSource(modelData.getId()));
            byte[] bpmnBytes = null;
            BpmnModel model = new BpmnJsonConverter()
                    .convertToBpmnModel(modelNode);
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = BaseActiviti.getRepositoryService().createDeployment()
                    .name(modelData.getName())
                    .addString(processName, new String(bpmnBytes)).deploy();
            // 启动流程
            ProcessInstance processInstance = BaseActiviti.getRuntimeService().startProcessInstanceByKey("process");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 部署指定流程
     *
     * @param params
     * @return
     */
    @Request.Post("deployProcess.do")
    public Result deployProcess(Params params) {
        String modelId = params.getString("deploymentId");
        try {
            Model modelData = BaseActiviti.getRepositoryService().getModel(modelId);
            byte[] s = BaseActiviti.getRepositoryService().getModelEditorSource(modelData.getId());
            ObjectNode modelNode = (ObjectNode) new ObjectMapper()
                    .readTree(BaseActiviti.getRepositoryService().getModelEditorSource(modelData.getId()));
            byte[] bpmnBytes = null;
            BpmnModel model = new BpmnJsonConverter()
                    .convertToBpmnModel(modelNode);
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = BaseActiviti.getRepositoryService().createDeployment()
                    .name(modelData.getName())
                    .addString(processName, new String(bpmnBytes)).deploy();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
        return new Result(true);
    }

    /**
     * 获取全部部署
     *
     * @return
     */
    @Request.Post("processList.do")
    public View processList() {
        View view = new View("activiti/process-list");
        List<ProcessDefinition> processDefinitionList = BaseActiviti.getRepositoryService().createProcessDefinitionQuery().list();
        List<Model> model = BaseActiviti.getRepositoryService().createModelQuery().list();
        view.put("modelList", model);
        view.put("processDefinitionList", processDefinitionList);
        return view;
    }

    @Request.Post("deleteModel.do")
    public Result deleteModel(Params params) {
        BaseActiviti.getRepositoryService().deleteModel(params.getString("deploymentId"));
        return new Result(true);
    }

    /**
     * 读取资源
     *
     * @param params
     * @return
     * @throws IOException
     */
    @Request.Get("readResource.do")
    public Page readResource(Params params) throws IOException {
        HttpServletResponse response = DataContext.getResponse();
        String processDefinitionId = params.getString("pdid");
        ProcessDefinitionQuery pdq = BaseActiviti.getRepositoryService().createProcessDefinitionQuery();
        ProcessDefinition pd = pdq.processDefinitionId(processDefinitionId).singleResult();
        String resourceName = params.getString("resourceName");
        // 通过接口读取
        InputStream resourceAsStream = BaseActiviti.getRepositoryService().getResourceAsStream(pd.getDeploymentId(), resourceName);

        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
        return new Page();
    }

    /**
     * 删除部署
     */
    @Request.Post("deleteProcess.do")
    public Result deleteProcess(Params params) {
        BaseActiviti.getRepositoryService().deleteDeployment(params.getString("deploymentId"), true);
        return new Result(true);
    }

}
