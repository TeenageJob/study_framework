package org.mvc.ty.mybatis.card;

import java.util.List;
import java.util.Map;

public interface Card {

    void saveYw(Map paramMap) throws Exception;

    void fuheYw(String buId) throws Exception;

    List<Map<String, String>> getAllCardInfo() throws Exception;

    void reportLoss(Map paramMap) throws Exception;
    void reportLossH(Map paramMap) throws Exception;
}
