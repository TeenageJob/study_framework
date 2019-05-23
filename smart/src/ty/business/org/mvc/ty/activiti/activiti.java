package org.mvc.ty.activiti;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.plugin.activiti.ProcessHelper;
import org.plugin.security.SecurityHelper;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;

import java.io.UnsupportedEncodingException;

@Action("activiti")
public class activiti {

    /**
     * 创建模型
     */
    @Request.Post("index.do")
    public String create() throws UnsupportedEncodingException {
        ProcessEngine processEngine = ProcessHelper.getProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        Model modelData = repositoryService.newModel();

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, SecurityHelper.getUsername());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        String description = SecurityHelper.getUsername() + "创建的流程";
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelData.setMetaInfo(modelObjectNode.toString());
        modelData.setName(SecurityHelper.getUsername());
        modelData.setKey("12313123");

        //保存模型
        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
        return "activiti/modeler.html?modelId=" + modelData.getId();
    }
}