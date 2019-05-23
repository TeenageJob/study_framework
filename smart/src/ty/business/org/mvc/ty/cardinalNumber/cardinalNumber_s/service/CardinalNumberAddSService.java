package org.mvc.ty.cardinalNumber.cardinalNumber_s.service;

import java.util.List;
import java.util.Map;

public interface CardinalNumberAddSService {

    /**
     * 获取所有险种信息
     *
     * @return
     */
    List<Map<String, String>> getAllCardinal()throws Exception;
    /**
     * 删除险种
     */
    void delCardinal(Map paramMap)throws Exception;

    /**
     * 更新险种
     */
    void updateCardianl(Map paramMap)throws Exception;

    /**
     * @param buId
     */
    void fuheYw(String buId)throws Exception;
}
