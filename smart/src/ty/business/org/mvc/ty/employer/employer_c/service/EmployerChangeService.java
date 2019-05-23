package org.mvc.ty.employer.employer_c.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;
import java.util.Map;

public interface EmployerChangeService {

    List<Map<String, String>> getAllEmployerInfo();

    List<Map<String, String>> getEmployerInsureInfo(Params params);
}
