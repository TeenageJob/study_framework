<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:form method="post" url="role/save.do">
    <ty:submit/>
    <ty:panel id="panl_1" name="添加角色" cols="4">
        <ty:box id="box"/>
        <ty:box id="box_1">
            <ty:text id="role" name="角色名"/>
            <ty:text id="description" name="描述"/>
            <ty:text id="disabled" name="状态" readOnly="true" value="0"/>
        </ty:box>
    </ty:panel>
</ty:form>
