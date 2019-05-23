package org.mvc.ty.common.common_c.action;

import org.mvc.ty.common.query.CommonQuery;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.util.JsonUtil;
import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.impl.BaseAction;

import java.util.HashMap;
import java.util.Map;

@Action("publicQuery")
public class PublicQuery extends BaseAction {

    @Request.Post("getCities.do")
    public Result getCities(Params params) {
        Result result = new Result(true);
        String AAA001 = params.getString("AAA001");
        String AAA02 = params.getString("aid");
        result.setData(CommonQuery.queryCollectionAAA004(AAA001, AAA02));
        return result;
    }

    @Request.Post("queryBaseInfo.do")
    public Result queryemployeeInfo(Params params) {
        Result result = new Result(true);
        String value = params.getString("value");
        Map map = new HashMap();
        map = CommonQuery.queryemployeeInfo(value);//查询单位
        if (MapUtil.isEmpty(map)) {//查询个人
            map = CommonQuery.queryemployerInfo(value);
        }
        if(MapUtil.isNotEmpty(map)) {
            result.setData(JsonUtil.mapToJson(map));
        }
        return result;
    }
}
