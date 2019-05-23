package org.mvc.ty.card.card_c.service;

import org.smart.framework.mvc.bean.Params;

import java.util.List;
import java.util.Map;

public interface CardEditService {

    List<Map<String,String>> getAllCardInfo() throws Exception;

    void reportLoss(Params params) throws Exception;
}
