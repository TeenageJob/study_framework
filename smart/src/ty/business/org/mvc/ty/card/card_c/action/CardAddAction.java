package org.mvc.ty.card.card_c.action;

import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.plugin.common.impl.BaseAction;
import org.smart.framework.mvc.bean.View;

@Action("cardAdd")
public class CardAddAction extends BaseAction {


    @Request.Post("index.do")
    public View execute() {
        initActiviti();
        return new View("card/registerCard");
    }

    @Request.Post("save.do")
    public String save(Params params) throws Exception {
       process(params);
        return JSON;
    }
}
