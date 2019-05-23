package org.mvc.ty.employee.employee_c.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;
import java.util.Map;

public interface EmployeeChangeService {

    List<Map> getAllEmployeeInfo() throws Exception ;

    List<Map<String, String>> getEmployeeInsureInfo(Params params) throws Exception ;

}
