package org.mvc.ty.mybatis.employer;

import java.util.List;
import java.util.Map;

public interface Employer {

    /**
     * 办理业务，保存个人信息
     */
    int saveYw(Map<String,Object> paramMap);

    /**
     * 复核业务，复核个人信息
     */
    int checkYw(String businessId);

    /**
     * 取消任务，删除个人信息
     */
    int cancelYw(String businessId);

    /**
     *经办：保存个人参保
     */
    int saveInsureYw(Map paramMap);
    /**
     *经办：保存个人参保银行
     */
    int saveInsureYwBank(Map paramMap);

    /**
     *复核：保存个人参保
     */
    int fuheInsureYw(String buId);
    /**
     *复核：保存个人参保银行
     */
    int fuheInsureYwBank(String buId);

    /**
     * 获取全部参保人
     */
    List<Map<String, String>> getAllEmployerInfo();

    /**
     * 获取参保人
     */
    List<Map<String, String>> getEmployerInsureInfo(String ABB001);

    /**
     * 个人参保更改经办
     */
    int updateYwInsure(String buId);
    /**
     * 个人参保更改复核
     */
    int updateYwBank(String buId);

}
