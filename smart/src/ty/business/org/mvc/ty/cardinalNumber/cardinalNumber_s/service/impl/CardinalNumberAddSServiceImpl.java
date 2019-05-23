package org.mvc.ty.cardinalNumber.cardinalNumber_s.service.impl;

import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddSService;
import org.mvc.ty.mybatis.cardinalNumber.CardinalNumber;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardinalNumberAddSServiceImpl implements CardinalNumberAddSService {


    @MybatisInject
    CardinalNumber cardinalNumber;

    @Override
    public List<Map<String, String>> getAllCardinal() throws Exception{
        return cardinalNumber.getAllCardinal();
    }
    @Override
    public void delCardinal(Map paramMap)throws Exception{
        cardinalNumber.delCardinal(paramMap);
    }

    @Override
    public void updateCardianl(Map paramMap)throws Exception {
        cardinalNumber.updateCardianl(paramMap);
    }

    @MybatisSession
    @Override
    public void fuheYw(String buId) throws Exception {
        cardinalNumber.fuheDelete(buId);
        cardinalNumber.fuheInsert(buId);
        cardinalNumber.fuheUpdate(buId);
    }
}
