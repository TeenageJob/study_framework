package org.mvc.ty.card.card_s.service.impl;

import org.mvc.ty.card.card_s.service.CardAddSService;
import org.mvc.ty.mybatis.card.Card;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;

import java.util.Map;

@Service
public class CardAddSServiceImpl implements CardAddSService{

    @MybatisInject
    Card card;

    @Override
    public void saveYw(Map paramMap) throws Exception {
        card.saveYw(paramMap);
    }

    @Override
    public void fuheYw(String buId) throws Exception {
        card.fuheYw(buId);
    }
}
