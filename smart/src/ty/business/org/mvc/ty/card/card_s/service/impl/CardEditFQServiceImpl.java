package org.mvc.ty.card.card_s.service.impl;

import org.mvc.ty.card.card_s.service.CardEditFQService;
import org.mvc.ty.card.card_s.service.CardEditSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardEditFQServiceImpl implements CardEditFQService{

    @Inject
    private CardEditSService cardEditSService;
    @Override
    public List<Map<String, String>> getAllCardInfo() throws Exception {
        return cardEditSService.getAllCardInfo();
    }
}
