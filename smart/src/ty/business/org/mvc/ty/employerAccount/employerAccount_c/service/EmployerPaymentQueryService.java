package org.mvc.ty.employerAccount.employerAccount_c.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;
import java.util.Map;

public interface EmployerPaymentQueryService {

    List<Map> queryPaymentInfo(Params params);
}
