package org.mvc.ty.activiti.editor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.mvc.ty.activiti.service.ConfigProcessService;
import org.plugin.activiti.ProcessHelper;
import org.plugin.rest.Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.ioc.annotation.Autowired;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
@Rest("activiti")
@Consumes(MediaType.APPLICATION_JSON)
public class ModelEditorJsonRestResource implements ModelDataJsonConstants {


    @Inject
    private ConfigProcessService configProcessService;

    protected static final Logger LOGGER = LoggerFactory.getLogger(ModelEditorJsonRestResource.class);

    private RepositoryService repositoryService = ProcessHelper.getProcessEngine().getRepositoryService();

    @Autowired
    private ObjectMapper objectMapper;

    @GET
    @Path("/service/model/{modelId}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getEditorJson(@PathParam("modelId") String modelId) {

        ObjectNode modelNode = null;

        System.out.println("ModelEditorJsonRestResource.getEditorJson---------");
        Model model = this.repositoryService.getModel(modelId);

        if (model != null) {
            try {
                if (StringUtils.isNotEmpty(model.getMetaInfo())) {
                    modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
                } else {
                    modelNode = this.objectMapper.createObjectNode();
                    modelNode.put("name", model.getName());
                }
                modelNode.put("modelId", model.getId());
                ObjectNode editorJsonNode = (ObjectNode) this.objectMapper.readTree(new String(this.repositoryService
                        .getModelEditorSource(model.getId()), "utf-8"));
                modelNode.put("model", editorJsonNode);
            } catch (Exception e) {
                LOGGER.error("Error creating model JSON", e);
                throw new ActivitiException("Error creating model JSON", e);
            }
        }
        JSONObject jsonObject = JSON.parseObject(modelNode.toString());
        return jsonObject;
    }

    @GET
    @Path("/service/editor/stencilset")
    @Produces({MediaType.APPLICATION_JSON})
    public String getStencilset() {
        System.out.println("StencilsetRestResource.getStencilset-----------");
        InputStream stencilsetStream = getClass().getClassLoader().getResourceAsStream("stencilset.json");
        try {
            return IOUtils.toString(stencilsetStream, "utf-8");
        } catch (Exception e) {
            throw new ActivitiException("Error while loading stencil set", e);
        }
    }


    @PUT
    @Path("/service/model/{modelId}/save")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response.Status saveModel(@PathParam("modelId") String modelId, MultivaluedMap<String, String> values) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("model_id", modelId);

            Model model = this.repositoryService.getModel(modelId);
            System.out.println("ModelSaveRestResource.saveModel----------");
            ObjectNode modelJson = (ObjectNode) this.objectMapper.readTree(model.getMetaInfo());

            modelJson.put("name", (String) values.getFirst("name"));
            paramMap.put("model_name", (String) values.getFirst("name"));
            modelJson.put("description", (String) values.getFirst("description"));
            paramMap.put("model_desc", (String) values.getFirst("description"));
            model.setMetaInfo(modelJson.toString());
            model.setName((String) values.getFirst("name"));

            this.repositoryService.saveModel(model);

            this.repositoryService.addModelEditorSource(model.getId(), ((String) values.getFirst("json_xml")).getBytes("utf-8"));

            InputStream svgStream = new ByteArrayInputStream(((String) values.getFirst("svg_xml")).getBytes("utf-8"));
            TranscoderInput input = new TranscoderInput(svgStream);

            PNGTranscoder transcoder = new PNGTranscoder();

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outStream);

            transcoder.transcode(input, output);
            byte[] result = outStream.toByteArray();
            this.repositoryService.addModelEditorSourceExtra(model.getId(), result);
            outStream.close();
            configProcessService.saveModelInfo(paramMap);
            return Response.Status.OK;
        } catch (Exception e) {
            LOGGER.error("Error saving model", e);
            throw new ActivitiException("Error saving model", e);
        }
    }
}