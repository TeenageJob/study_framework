package org.mvc.ty.card.card_s.service.impl;

import org.mvc.ty.card.card_s.service.CardAddFBService;
import org.mvc.ty.card.card_s.service.CardAddSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;

@Service
public class CardAddFBServiceImpl implements CardAddFBService {

    @Inject
    private CardAddSService cardAddSService;

    @Override
    public void saveYw(Map paramMap) throws Exception {
        cardAddSService.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String buId) throws Exception {
        cardAddSService.fuheYw(buId);
    }
}
