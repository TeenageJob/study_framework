package org.mvc.ty.activiti.service.impl;

import org.mvc.ty.activiti.service.DeployProcessService;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

import java.util.List;

@Service
public class DeployProcessServiceImpl implements DeployProcessService{
    @Override
    public List<String> getAllYwid() {
        return DatabaseHelper.queryColumnList("select concat(id,',',url_name) from business_url");
    }

    @Override
    public boolean save(Params params) {
        DatabaseHelper.insertReturnPK("insert into act_yw(model,service,page)values(?,?,?)",
                params.getString("model"),params.getString("service"),params.getString("page"));
        return true;
    }
}
