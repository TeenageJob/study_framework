package org.mvc.ty.employee.employee_s.service;

import java.util.List;
import java.util.Map;

public interface EmployeeChangeFQService {

    List<Map> getAllEmployeeInfo();

    List<Map<String, String>> getEmployeeInsureInfo(String ACB001);
}
