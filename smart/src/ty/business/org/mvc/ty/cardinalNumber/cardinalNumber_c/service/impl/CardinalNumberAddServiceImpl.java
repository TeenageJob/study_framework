package org.mvc.ty.cardinalNumber.cardinalNumber_c.service.impl;

import org.mvc.ty.cardinalNumber.cardinalNumber_c.service.CardinalNumberAddService;
import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddFBService;
import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.plugin.common.BaseService;

import java.util.List;
import java.util.Map;

@Service
public class CardinalNumberAddServiceImpl extends BaseService implements CardinalNumberAddService {

    @Inject
    private CardinalNumberAddFQService cardinalNumberAddFQService;

    @Inject
    private CardinalNumberAddFBService cardinalNumberAddFBService;

    @Override
    public void saveYw(Params params) throws Exception {
        saveProcess(params);
        Map paramMap = params.getFieldMap();
        paramMap.put("AAA00A", params.getString("businessId"));
        cardinalNumberAddFBService.saveYw(paramMap);
    }

    @Override
    public void checkYw(String processInstanceId) throws Exception {
        try {
            cardinalNumberAddFBService.fuheYw(fuheProcess(processInstanceId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void revocateYw(String processInstanceId) {

    }

    @Override
    public void rollbackYw(String processInstanceId) {

    }

    @Override
    public List<Map<String, String>> getAllCardinal() {
        try {
            return cardinalNumberAddFQService.getAllCardinal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
