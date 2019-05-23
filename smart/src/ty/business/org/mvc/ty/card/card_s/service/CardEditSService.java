package org.mvc.ty.card.card_s.service;

import java.util.List;
import java.util.Map;

public interface CardEditSService {

    List<Map<String, String>> getAllCardInfo() throws Exception;

    void reportLoss(Map paramMap) throws Exception;
}
