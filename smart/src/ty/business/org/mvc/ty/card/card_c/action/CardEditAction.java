package org.mvc.ty.card.card_c.action;

import org.mvc.ty.card.card_c.service.CardEditService;
import org.mvc.ty.card.card_s.service.CardEditFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("cardEdit")
public class CardEditAction extends BaseAction{

    @Inject
    private CardEditService cardEditService;

    @Request.Post("index.do")
    public View execute(){
        try {
            setList("gd_card",cardEditService.getAllCardInfo());
        } catch (Exception e) {
            setMessage("没有一卡通信息","info");
        }
        return new View("card/cardInfo");
    }

    @Request.Post("reportLoss.do")
    public String reportLoss(Params params) throws Exception{
        cardEditService.reportLoss(params);
        return JSON;
    }
}
