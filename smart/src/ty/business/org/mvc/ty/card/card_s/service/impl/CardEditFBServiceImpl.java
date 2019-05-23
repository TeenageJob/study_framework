package org.mvc.ty.card.card_s.service.impl;

import org.mvc.ty.card.card_s.service.CardEditFBService;
import org.mvc.ty.card.card_s.service.CardEditSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;

@Service
public class CardEditFBServiceImpl implements CardEditFBService{

    @Inject
    private CardEditSService cardEditSService;
    @Override
    public void reportLoss(Map paramMap) throws Exception {
        cardEditSService.reportLoss(paramMap);
    }
}
