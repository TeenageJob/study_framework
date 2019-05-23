package org.mvc.ty.activiti.editor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.plugin.activiti.ProcessHelper;
import org.plugin.rest.Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.ioc.annotation.Autowired;
import org.smart.framework.tx.annotation.Service;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Service
@Rest("constants")
public class ModelSaveRestResource
        implements ModelDataJsonConstants {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ModelSaveRestResource.class);

    private RepositoryService repositoryService= ProcessHelper.getProcessEngine().getRepositoryService();

    @Autowired
    private ObjectMapper objectMapper;

    @PUT
    @Path("/service/model/{modelId}/save")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response.Status saveModel(@PathParam("modelId") String modelId,MultivaluedMap<String, String> values) {
        try {

            Model model = this.repositoryService.getModel(modelId);
            System.out.println("ModelSaveRestResource.saveModel----------");
            ObjectNode modelJson = (ObjectNode) this.objectMapper.readTree(model.getMetaInfo());

            modelJson.put("name", (String) values.getFirst("name"));
            modelJson.put("description", (String) values.getFirst("description"));
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
            return  Response.Status.OK;
        } catch (Exception e) {
            LOGGER.error("Error saving model", e);
            throw new ActivitiException("Error saving model", e);
        }
    }
}