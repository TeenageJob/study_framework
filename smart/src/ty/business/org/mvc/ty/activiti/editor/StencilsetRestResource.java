package org.mvc.ty.activiti.editor;

import org.activiti.engine.ActivitiException;
import org.apache.commons.io.IOUtils;
import org.plugin.rest.Rest;
import org.smart.framework.tx.annotation.Service;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Service
@Rest("stencil")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
public class StencilsetRestResource {

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
}