package org.mvc.ty.mybatis.cardinalNumber;

import java.util.List;
import java.util.Map;

public interface CardinalNumber {

    /**
     * 获取所有险种信息
     */
    List<Map<String, String>> getAllCardinal();
    /**删除险种*/
    int delCardinal(Map paramMap);
    /**更新险种*/
    int updateCardianl(Map paramMap);

    /**复核*/
    int fuheUpdate(String buId);
    int fuheDelete(String buId);
    int fuheInsert(String buId);
}
