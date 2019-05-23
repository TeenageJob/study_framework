package org.smart.plugin.common;

import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.start.StartHelper;
import org.plugin.activiti.BaseActivitiService.BaseActivitiServiceImpl;
import org.plugin.activiti.BaseActivitiService.IBaseActivitiService;
import org.plugin.cache.smart.Cache;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.util.ClassUtil;
import org.smart.framework.util.DateUtil;

import java.io.Serializable;
import java.sql.SQLException;

public abstract class BaseService implements IBaseActivitiService {

    /**
     * 获取当前日期
     */
    public String getDate() {
        return DateUtil.getCurrentDate();
    }


    public void saveProcess(Params params) throws Exception {
        try {
            String sql = "insert into incident(business_id,process,user,user_id)values(?,?,?,?)";
            Serializable a = DatabaseHelper.insertReturnPK(sql, params.getString("businessId"),
                    params.getString("processInstanceId"), params.getString("bpmn_user_name"),
                    params.getString("bpmn_user_id"));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String fuheProcess(String processId) throws Exception {
        try {
            Cache<Object, Object> cache = StartHelper.getCache();
            UserInformationVO userInformationVO = (UserInformationVO) cache.get("userInfo");
            String sql = "update incident set re_check_flag=1,re_user=?,re_user_id=? where process=?";
            Serializable a = DatabaseHelper.update(sql, userInformationVO.getUsername(), userInformationVO.getOperator(), processId);
            return getBusinessId(processId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String cancelProcess(String processId) throws Exception {
        try {
            String businessId = getBusinessId(processId);
            String sql = "delete from incident where process=?";
            DatabaseHelper.update(sql, processId);
            return businessId;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String getBusinessId(String processId) throws Exception {
        try {
            String sql_business = "select business_id from incident where process=?";
            return DatabaseHelper.queryColumn(sql_business, processId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
