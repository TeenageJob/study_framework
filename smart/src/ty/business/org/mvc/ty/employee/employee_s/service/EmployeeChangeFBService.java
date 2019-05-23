package org.mvc.ty.employee.employee_s.service;

import java.util.List;
import java.util.Map;

public interface EmployeeChangeFBService {

    List<Map> getAllEmployeeInfo();

    void saveYw(Map paramMap);

    void fuheYw(String buId);
}
