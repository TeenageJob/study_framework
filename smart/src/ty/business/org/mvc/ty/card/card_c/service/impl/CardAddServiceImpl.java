package org.mvc.ty.card.card_c.service.impl;

import org.mvc.ty.card.card_c.service.CardAddService;
import org.mvc.ty.card.card_s.service.CardAddFBService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.Map;

@Service
public class CardAddServiceImpl extends BaseService implements CardAddService {

    @Inject
    private CardAddFBService cardAddFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        cardAddFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        cardAddFBService.fuheYw(fuheProcess(processInstanceId));
    }

    @Override
    public void revocateYw(String processInstanceId) throws Exception {

    }

    @Override
    public void rollbackYw(String processInstanceId) throws Exception {

    }
}
