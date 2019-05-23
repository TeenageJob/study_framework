package org.mvc.ty.employer.employer_s.service;

import java.util.List;
import java.util.Map;

public interface EmployerChangeSService {

    List<Map<String, String>> getAllEmployerInfo();

    List<Map<String, String>> getEmployerInsureInfo(String ABB001);

    void saveYw(Map paramMap);

    void fuheYw(String buId);
}
