package org.mvc.ty.employerAccount.employerAccount_c.service;

import org.smart.framework.mvc.bean.Params;
import org.smart.plugin.common.BaseService;

import java.util.List;
import java.util.Map;

public interface EmployerPaymentService {

    List<Map<String,String>> getBaseNumber(Params params);
}
