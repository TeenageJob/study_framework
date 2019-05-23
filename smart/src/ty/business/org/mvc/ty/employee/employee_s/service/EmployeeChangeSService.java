package org.mvc.ty.employee.employee_s.service;

import java.util.List;
import java.util.Map;

public interface EmployeeChangeSService {

    List<Map> getAllEmployeeInfo();

    List<Map<String, String>> getEmployeeInsureInfo(String ACB001);

    void saveYw(Map paramMap);

    void fuheYw(String buId);
}
