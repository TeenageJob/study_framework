package org.mvc.ty.employer.employer_c.action;

import org.mvc.ty.employer.employer_c.service.EmployerChangeService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

import java.util.List;
import java.util.Map;

@Action("employerEdit")
public class EmployerEditAction extends BaseAction {

    @Inject
    private EmployerChangeService employerChangeService;

    @Request.Post("index.do")
    public View execute(Params params) {
        initActiviti();
        View view = new View("employer/employerEdit");
        List<Map<String, String>> list = employerChangeService.getEmployerInsureInfo(params);
        for (Map.Entry<String, String> map : list.get(0).entrySet()) {
            if (map.getValue().equals("已参加")) {
                setChecked(map.getKey());
            } else {//if(map.getKey().equals("ABC005")||map.getKey().equals("ACB002"))
                setData(map.getKey(), map.getValue());
            }
        }
        return view;
    }

    /**
     * 查询所有参保单位
     *
     * @return
     */
    @Request.Post("getInfoGrid.do")
    public View getInfoGrid() {
        View view = new View("employer/employerInsureQuery");
        List list = employerChangeService.getAllEmployerInfo();
        setList("grid_AB11B", list);
        return view;
    }

    @Request.Post("save.do")
    public Result saveEmployeeEdit(Params params) throws Exception{
       process(params);
        return new Result(true);
    }
}
