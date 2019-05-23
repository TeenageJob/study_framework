<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ty:form method="post" url="">
    <ty:panel id="panl_1" name="设置角色" cols="4">
        <ty:list id="lt_user" checkbox="false" cssStyle="overflow-y:auto" onclick="fnlist(this)"/>
        <ty:box id="box_1">
            <ty:text id="txt_user" name="用户名" readOnly="true"/>
            <ty:selectInput id="sl_role" name="角色选择"/>
            <ty:button id="setRole" name="保存" onClick="saveFn()" cssStyle="margin-left:100px"/>
        </ty:box>
    </ty:panel>
</ty:form>
<script type="text/javascript">
    function saveFn() {
        var info={
            user:Base.getVal("txt_user"),
            role:$('#sl_role').selectpicker('val')
        }
        Base.submitA("userManager/setUserRole.do",function () {
            Base.alert("保存成功！");
        },null,info);
        Base.hide("setRole");
    }

    function fnlist(node) {
        Base.clearData("txt_user");
        Base.setData("txt_user", $(node).attr("value"));
        Base.show("setRole")
    }
</script>

