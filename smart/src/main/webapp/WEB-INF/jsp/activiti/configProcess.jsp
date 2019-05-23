<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ty:form method="post" url="configProcess/saveProcess.do">
    <ty:panel id="panl_1" cols="3">
        <ty:box id="box_1">
            <ty:list id="li_page" cssStyle="overflow-y:auto" checkbox="false" onclick="fnlist(this)"/>
        </ty:box>
        <ty:box cssStyle="margin-top:100px" id="box_2">
            <ty:selectInput id="sl_model" name="模型"/>
            <ty:text id="txt_page" name="页面名称"/>
            <ty:text id="txt_service" name="service"/>
            <ty:text id="txt_action" name="action"/>
            <ty:button cssStyle="margin-left: 100px;" id="btn_save" name="保存"/>
        </ty:box>
    </ty:panel>
</ty:form>
<script type="text/javascript">

    $(function () {
        Base.setHide("btn_save");
    });

    function fnlist(node) {
        Base.clearData("txt_page","txt_service","txt_action");
        Base.setShow("btn_save");
        var value = $(node).attr("value");
        Base.setData("txt_page", value);
        var info = {
            page: value
        }
        Base.submitA("configProcess/getAction.do", function (data) {
            Base.setData("txt_action", data.data);
        }, null, info);
    }
</script>
