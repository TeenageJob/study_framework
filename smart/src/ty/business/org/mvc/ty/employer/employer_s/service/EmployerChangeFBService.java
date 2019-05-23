package org.mvc.ty.employer.employer_s.service;

import java.util.List;
import java.util.Map;

public interface EmployerChangeFBService {

    List<Map<String,String>> getAllEmployeeInfo();

    void saveYw(Map paramMap);

    void fuheYw(String buId);
}
