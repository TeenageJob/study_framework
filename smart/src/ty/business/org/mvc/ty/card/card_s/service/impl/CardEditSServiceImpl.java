package org.mvc.ty.card.card_s.service.impl;

import org.mvc.ty.card.card_s.service.CardEditSService;
import org.mvc.ty.mybatis.card.Card;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardEditSServiceImpl implements CardEditSService {

    @MybatisInject
    Card card;

    @Override
    public List<Map<String, String>> getAllCardInfo() throws Exception {
        return card.getAllCardInfo();
    }

    @MybatisSession
    @Override
    public void reportLoss(Map paramMap) throws Exception {
        card.reportLoss(paramMap);
        card.reportLossH(paramMap);
    }
}
