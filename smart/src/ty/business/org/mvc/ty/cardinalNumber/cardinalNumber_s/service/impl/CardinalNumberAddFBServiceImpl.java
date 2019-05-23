package org.mvc.ty.cardinalNumber.cardinalNumber_s.service.impl;

import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddFBService;
import org.mvc.ty.cardinalNumber.cardinalNumber_s.service.CardinalNumberAddSService;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.StringUtil;
import org.smart.plugin.common.BaseServiceImpl;

import java.util.HashMap;
import java.util.Map;

@Service
public class CardinalNumberAddFBServiceImpl extends BaseServiceImpl implements CardinalNumberAddFBService {


    @Inject
    private CardinalNumberAddSService cardinalNumberAddSService;

    @Override
    public void saveYw(Map<String, String> paramMap) throws Exception{
        //第一个险种
        if(StringUtil.isEmpty(paramMap.get("AD13A_box"))){//没有选中该险种，删除
            if(paramMap.get("AD13A").equals("1")){//该险种有数据，增加删除记录
                Map<String,String> value=new HashMap();
                value.put("AAA00A",paramMap.get("AAA00A"));
                value.put("ADA00A",paramMap.get("AADA00A"));
                value.put("ADA00K","3");
                cardinalNumberAddSService.delCardinal(value);
            }//没有就不管
        }else{
            Map<String,String> value=new HashMap();
            value.put("AAA00A",paramMap.get("AAA00A"));
            value.put("ADA00A",paramMap.get("AADA00A"));
            value.put("ADA00B",paramMap.get("AADA00B"));
            value.put("ADA00J",paramMap.get("AADA00J"));
            value.put("ADA00C",paramMap.get("AADA00C"));
            value.put("ADA00D",paramMap.get("AADA00D"));
            value.put("ADA00E",paramMap.get("AADA00E"));
            value.put("ADA00F",paramMap.get("AADA00F"));
            value.put("ADA00G",paramMap.get("AADA00G"));
            value.put("ADA00H",paramMap.get("AADA00H"));
            if(paramMap.get("AD13A").equals("1")){//该险种有数据，增加更新记录
                value.put("ADA00K","2");
                cardinalNumberAddSService.updateCardianl(value);
            }else{//没有数据则新增数据
                value.put("ADA00K","1");
                cardinalNumberAddSService.updateCardianl(value);
            }
        }
        //第二个险种
        if(StringUtil.isEmpty(paramMap.get("AD13B_box"))){//没有选中该险种，删除
            if(paramMap.get("AD13B").equals("1")){//该险种有数据，增加删除记录
                Map<String,String> value=new HashMap();
                value.put("AAA00A",paramMap.get("AAA00A"));
                value.put("ADA00A",paramMap.get("BADA00A"));
                value.put("ADA00K","3");
                cardinalNumberAddSService.delCardinal(value);
            }//没有就不管
        }else{
            Map<String,String> value=new HashMap();
            value.put("AAA00A",paramMap.get("AAA00A"));
            value.put("ADA00A",paramMap.get("BADA00A"));
            value.put("ADA00B",paramMap.get("BADA00B"));
            value.put("ADA00J",paramMap.get("BADA00J"));
            value.put("ADA00C",paramMap.get("BADA00C"));
            value.put("ADA00D",paramMap.get("BADA00D"));
            value.put("ADA00E",paramMap.get("BADA00E"));
            value.put("ADA00F",paramMap.get("BADA00F"));
            value.put("ADA00G",paramMap.get("BADA00G"));
            value.put("ADA00H",paramMap.get("BADA00H"));
            if(paramMap.get("AD13B").equals("1")){//该险种有数据，增加更新记录
                value.put("ADA00K","2");
                cardinalNumberAddSService.updateCardianl(value);
            }else{//没有数据则新增数据
                value.put("ADA00K","1");
                cardinalNumberAddSService.updateCardianl(value);
            }
        }
        //第三个险种
        if(StringUtil.isEmpty(paramMap.get("AD13C_box"))){//没有选中该险种，删除
            if(paramMap.get("AD13C").equals("1")){//该险种有数据，增加删除记录
                Map<String,String> value=new HashMap();
                value.put("AAA00A",paramMap.get("AAA00A"));
                value.put("ADA00A",paramMap.get("CADA00A"));
                value.put("ADA00K","3");
                cardinalNumberAddSService.delCardinal(value);
            }//没有就不管
        }else{
            Map<String,String> value=new HashMap();
            value.put("AAA00A",paramMap.get("AAA00A"));
            value.put("ADA00A",paramMap.get("CADA00A"));
            value.put("ADA00B",paramMap.get("CADA00B"));
            value.put("ADA00J",paramMap.get("CADA00J"));
            value.put("ADA00C",paramMap.get("CADA00C"));
            value.put("ADA00D",paramMap.get("CADA00D"));
            value.put("ADA00E",paramMap.get("CADA00E"));
            value.put("ADA00F",paramMap.get("CADA00F"));
            value.put("ADA00G",paramMap.get("CADA00G"));
            value.put("ADA00H",paramMap.get("CADA00H"));
            if(paramMap.get("AD13C").equals("1")){//该险种有数据，增加更新记录
                value.put("ADA00K","2");
                cardinalNumberAddSService.updateCardianl(value);
            }else{//没有数据则新增数据
                value.put("ADA00K","1");
                cardinalNumberAddSService.updateCardianl(value);
            }
        }
        //第四个险种
        if(StringUtil.isEmpty(paramMap.get("AD13D_box"))){//没有选中该险种，删除
            if(paramMap.get("AD13D").equals("1")){//该险种有数据，增加删除记录
                Map<String,String> value=new HashMap();
                value.put("AAA00A",paramMap.get("AAA00A"));
                value.put("ADA00A",paramMap.get("DADA00A"));
                value.put("ADA00K","3");
                cardinalNumberAddSService.delCardinal(value);
            }//没有就不管
        }else{
            Map<String,String> value=new HashMap();
            value.put("AAA00A",paramMap.get("AAA00A"));
            value.put("ADA00A",paramMap.get("DADA00A"));
            value.put("ADA00B",paramMap.get("DADA00B"));
            value.put("ADA00J",paramMap.get("DADA00J"));
            value.put("ADA00C",paramMap.get("DADA00C"));
            value.put("ADA00D",paramMap.get("DADA00D"));
            value.put("ADA00E",paramMap.get("DADA00E"));
            value.put("ADA00F",paramMap.get("DADA00F"));
            value.put("ADA00G",paramMap.get("DADA00G"));
            value.put("ADA00H",paramMap.get("DADA00H"));
            if(paramMap.get("AD13D").equals("1")){//该险种有数据，增加更新记录
                value.put("ADA00K","2");
                cardinalNumberAddSService.updateCardianl(value);
            }else{//没有数据则新增数据
                value.put("ADA00K","1");
                cardinalNumberAddSService.updateCardianl(value);
            }
        }
        //第五个险种
        if(StringUtil.isEmpty(paramMap.get("AD13E_box"))){//没有选中该险种，删除
            if(paramMap.get("AD13E").equals("1")){//该险种有数据，增加删除记录
                Map<String,String> value=new HashMap();
                value.put("AAA00A",paramMap.get("AAA00A"));
                value.put("ADA00A",paramMap.get("EADA00A"));
                value.put("ADA00K","3");
                cardinalNumberAddSService.delCardinal(value);
            }//没有就不管
        }else{
            Map<String,String> value=new HashMap();
            value.put("AAA00A",paramMap.get("AAA00A"));
            value.put("ADA00A",paramMap.get("EADA00A"));
            value.put("ADA00B",paramMap.get("EADA00B"));
            value.put("ADA00J",paramMap.get("EADA00J"));
            value.put("ADA00C",paramMap.get("EADA00C"));
            value.put("ADA00D",paramMap.get("EADA00D"));
            value.put("ADA00E",paramMap.get("EADA00E"));
            value.put("ADA00F",paramMap.get("EADA00F"));
            value.put("ADA00G",paramMap.get("EADA00G"));
            value.put("ADA00H",paramMap.get("EADA00H"));
            if(paramMap.get("AD13E").equals("1")){//该险种有数据，增加更新记录
                value.put("ADA00K","2");
                cardinalNumberAddSService.updateCardianl(value);
            }else{//没有数据则新增数据
                value.put("ADA00K","1");
                cardinalNumberAddSService.updateCardianl(value);
            }
        }
    }

    @Override
    public void fuheYw(String buId)throws Exception {
        cardinalNumberAddSService.fuheYw(buId);
    }
}
