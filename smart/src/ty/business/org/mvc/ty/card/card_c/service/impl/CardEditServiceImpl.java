package org.mvc.ty.card.card_c.service.impl;

import com.alibaba.fastjson.JSONArray;
import org.mvc.ty.card.card_c.service.CardEditService;
import org.mvc.ty.card.card_s.service.CardEditFBService;
import org.mvc.ty.card.card_s.service.CardEditFQService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.ObjectUtil;
import org.smart.plugin.common.BaseServiceImpl;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CardEditServiceImpl extends BaseServiceImpl implements CardEditService {

    @Inject
    private CardEditFQService cardEditFQService;

    @Inject
    private CardEditFBService cardEditFBService;

    public List<Map<String, String>> getAllCardInfo() throws Exception {
        return cardEditFQService.getAllCardInfo();
    }

    @Override
    public void reportLoss(Params params) throws Exception {
        JSONArray jsonArray = JSONArray.parseArray(params.getString("id"));
        Object[] ids = jsonArray.toArray();
        if(ObjectUtils.isEmpty(ids)){
            throw new Exception("没有需要更改的信息");
        }
        Map paramMap = new HashMap();
        paramMap.put("ids", ids);
        cardEditFBService.reportLoss(paramMap);
    }
}
