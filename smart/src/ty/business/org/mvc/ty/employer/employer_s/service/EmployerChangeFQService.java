package org.mvc.ty.employer.employer_s.service;

import java.util.List;
import java.util.Map;

public interface EmployerChangeFQService {

    List<Map<String, String>> getAllEmployeeInfo();

    List<Map<String, String>> getEmployeeInsureInfo(String ABB001);
}
