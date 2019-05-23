package org.mvc.ty.cardinalNumber.cardinalNumber_c.action;

import org.smart.framework.mvc.annotation.Action;
import org.smart.framework.mvc.annotation.Request;
import org.smart.framework.mvc.bean.View;
import org.smart.plugin.common.impl.BaseAction;

@Action("cardinalNumberEdit")
public class CardinalNumberEditAction extends BaseAction {
    @Request.Post("index.do")
    public View execute() {
        return new View("");
    }

}
