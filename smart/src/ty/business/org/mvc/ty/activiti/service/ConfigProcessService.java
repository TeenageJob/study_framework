package org.mvc.ty.activiti.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;
import java.util.Map;

public interface ConfigProcessService {

    boolean saveProcess(Params params);

    List getService();

    List getModels();

    boolean saveModelInfo(Map<String,String> paramMap);

    Map getAction(Params params);
}
