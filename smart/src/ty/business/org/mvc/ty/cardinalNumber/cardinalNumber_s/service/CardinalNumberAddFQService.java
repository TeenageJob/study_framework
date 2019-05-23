package org.mvc.ty.cardinalNumber.cardinalNumber_s.service;

import java.util.List;
import java.util.Map;

public interface CardinalNumberAddFQService {
    /**
     * 获取所有险种信息
     * @return
     */
    List<Map<String, String>> getAllCardinal() throws Exception;
}
