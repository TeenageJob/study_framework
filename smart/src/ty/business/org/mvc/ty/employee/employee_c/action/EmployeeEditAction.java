package org.mvc.ty.employee.employee_c.action;

import org.mvc.ty.employee.employee_c.service.EmployeeChangeService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.Result;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

import java.util.List;
import java.util.Map;


@Action("employeeEdit")
public class EmployeeEditAction  extends BaseAction{

    @Inject
    private EmployeeChangeService employeeChangeService;

    /**
     * 进入编辑单位页面
     * @param params
     * @return
     */
    @Request.Post("index.do")
    public View execute(Params params) throws Exception {
        initActiviti();
        View view=new View("employee/employeeEdit");
        List<Map<String,String>> list=employeeChangeService.getEmployeeInsureInfo(params);
        for(Map.Entry<String,String> map:list.get(0).entrySet()){
            if(map.getValue().equals("已参加")){
                setChecked(map.getKey());
            }else {//if(map.getKey().equals("ABC005")||map.getKey().equals("ACB002"))
                setData(map.getKey(),map.getValue());
            }
        }
        return view;
    }

    /**
     * 查询所有参保单位
     * @return
     */
    @Request.Post("getInfoGrid.do")
    public View getInfoGrid() throws Exception{
        initActiviti();
        View view=new View("employee/employeeInsureQuery");
        List list= employeeChangeService.getAllEmployeeInfo();
        setList("grid_ACB001",list);
        return view;
    }

    @Request.Post("save.do")
    public Result save(Params params) throws Exception {
       process(params);
        return new Result(true);
    }
}
