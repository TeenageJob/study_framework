package org.mvc.ty.mybatis.employee;

import java.util.List;
import java.util.Map;

public interface Employee {

    /**
     * 单位登记经办
     */
    int saveEmployeeInfo(Map paramMap);
    /**
     * 单位登记复核
     */
    int fuheEmployeeInfo(String AAA00A);

    /**
     * 单位参保新增/更改经办
     */
    int saveEmployeeJoin(Map paramMap);
    int saveEmployeeBank(Map paramMap);
    /**
     * 单位参保新增复核
     */
    int fuheEmployeeJoin(String AAA00A);
    int fuheEmployeeBank(String AAA00A);

    /**
     * 获取所有单位信息
     */
    List<Map> getAllEmployeeInfo();

    /**
     * 获取单位信息
     */
    List<Map<String, String>> getEmployeeInsureInfo(String ACB001);

    /**
     * 单位参保更改经办
     */
    int updateYwInsure(String buId);
    /**
     * 单位参保更改复核
     */
    int updateYwBank(String buId);
}
