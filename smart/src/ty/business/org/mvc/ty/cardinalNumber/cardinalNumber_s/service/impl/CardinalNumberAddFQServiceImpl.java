package org.mvc.ty.cardinalNumber.cardinalNumber_s.service.impl;

import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddFQService;
import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardinalNumberAddFQServiceImpl implements CardinalNumberAddFQService {

    @Inject
    private CardinalNumberAddSService cardinalNumberAddSService;

    @Override
    public List<Map<String, String>> getAllCardinal() throws Exception {
        return cardinalNumberAddSService.getAllCardinal();
    }
}
