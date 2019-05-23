package org.mvc.ty.cardinalNumber.cardinalNumber_s.service;

import java.util.Map;

public interface CardinalNumberAddFBService {

    /**
     * 经办：保存险种
     */
    void saveYw(Map<String, String> paramMap)throws Exception;

    /**
     * 复核：审核险种
     */
    void fuheYw(String buId)throws Exception;
}
