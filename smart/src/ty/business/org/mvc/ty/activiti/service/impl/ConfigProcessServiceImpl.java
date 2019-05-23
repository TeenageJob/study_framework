package org.mvc.ty.activiti.service.impl;

import org.mvc.ty.activiti.service.ConfigProcessService;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConfigProcessServiceImpl implements ConfigProcessService {

    @Override
    public boolean saveProcess(Params params) {
        String model = params.getString("sl_model");
        String service = params.getString("txt_service");
        String page = params.getString("txt_page");
        String action = params.getString("txt_action");
        String sql;
        long count = DatabaseHelper.queryCount("select count(*) from act_yw where page=?", page);
        if (count == 1) {
            sql = "update act_yw set model=? , service=? , action=? where page=? ";
        } else {
            sql = "insert into act_yw(model,service,action,page)values(?,?,?,?)";
        }
        DatabaseHelper.insertReturnPK(sql, model, service, action, page);
        return true;
    }

    @Override
    public List getService() {
        String sql = "select concat(id,',',url_name) from business_url";
        return DatabaseHelper.queryColumnList(sql);
    }

    @Override
    public List getModels() {
        String sql = "select concat(model_name,',',model_name) from process_info";
        return DatabaseHelper.queryColumnList(sql);
    }

    @Override
    public boolean saveModelInfo(Map<String, String> paramMap) {
        String model_id = paramMap.get("model_id");
        String model_name = paramMap.get("model_name");
        String model_desc = paramMap.get("model_desc");
        String sql = "insert into process_info(model_id,model_name,model_desc)values(?,?,?)";
        DatabaseHelper.insertReturnPK(sql, model_id, model_name, model_desc);
        return true;
    }

    @Override
    public Map getAction(Params params) {
        String page = params.getString("page");
        String sql = "select action,service,model from act_yw where page=?";
        return DatabaseHelper.queryMap(sql, page);
    }
}
