package org.mvc.ty.cardinalNumber.cardinalNumber_c.action;

import org.mvc.ty.cardinalNumber.cardinalNumber_c.service.CardinalNumberAddService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.View;
import org.smart.framework.util.CollectionUtil;
import org.smart.plugin.common.impl.BaseAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Action("cardinalNumberAdd")
public class CardinalNumberAddAction extends BaseAction {

    @Inject
    private CardinalNumberAddService cardinalNumberAddService;

    @Request.Post("index.do")
    public View execute() {
        initActiviti();
        Map<String, String> flag = new HashMap<>();
        List<Map<String, String>> list = cardinalNumberAddService.getAllCardinal();
        if (CollectionUtil.isNotEmpty(list)) {
            for (Map<String, String> maps : list) {
                switch (maps.get("ADA00B").toString()) {
                    case "A":
                        for (Map.Entry emap : maps.entrySet())
                            setData("A" + emap.getKey(), emap.getValue());
                        flag.put("AA", "A");
                        break;
                    case "B":
                        for (Map.Entry emap : maps.entrySet())
                            setData("B" + emap.getKey(), emap.getValue());
                        flag.put("BB", "B");
                        break;
                    case "C":
                        for (Map.Entry emap : maps.entrySet())
                            setData("C" + emap.getKey(), emap.getValue());
                        flag.put("CC", "C");
                        break;
                    case "D":
                        for (Map.Entry emap : maps.entrySet())
                            setData("D" + emap.getKey(), emap.getValue());
                        flag.put("DD", "D");
                        break;
                    case "E":
                        for (Map.Entry emap : maps.entrySet())
                            setData("E" + emap.getKey(), emap.getValue());
                        flag.put("EE", "E");
                        break;
                }
            }
        }
        for (String str : flag.keySet()) {
            switch (str) {
                case "AA":
                    setChecked("AD13A_box");
                    setData("AD13A", "1");
                    break;
                case "BB":
                    setChecked("AD13B_box");
                    setData("AD13B", "1");
                    break;
                case "CC":
                    setChecked("AD13C_box");
                    setData("AD13C", "1");
                    break;
                case "DD":
                    setChecked("AD13D_box");
                    setData("AD13D", "1");
                    break;
                case "EE":
                    setChecked("AD13E_box");
                    setData("AD13E", "1");
                    break;
            }
        }
        return new View("cardinalNumber/cardinalNumberAdd");
    }

    @Request.Post("save.do")
    public String save(Params params) throws Exception {
       process(params);
        return JSON;
    }
}
