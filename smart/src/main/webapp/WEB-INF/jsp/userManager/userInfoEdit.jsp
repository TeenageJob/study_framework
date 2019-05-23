<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ty:form method="post" url="userManager/saveUserInfo.do">
    <ty:panel id="panl_1" name="用户信息" cols="4">
        <ty:box id="box_1" span="1"></ty:box>
        <ty:box id="box_2" span="2" >
            <ty:text id="username" name="账户"/>
            <ty:text id="email" name="邮箱"/>
            <ty:text id="phone" name="电话"/>
            <ty:text id="operator" name="姓名"/>
            <ty:text id="operator_id" name="经办id"/>
            <ty:text id="operator_organzation" name="经办机构"/>
            <ty:button id="btn_save" cssStyle="margin-left:100px" name="保存"/>
        </ty:box>
    </ty:panel>
</ty:form>