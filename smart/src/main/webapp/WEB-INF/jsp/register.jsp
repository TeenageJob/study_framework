<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>

<ty:form url="common/registers.do" method="post">
    <ty:panel id="panl_1" cols="4" name="注册用户">
        <ty:box id="box"/>
        <ty:box id="box_1">
            <ty:text id="account" name="用户名" placeholder="请输入账户"/>
            <ty:text id="email" name="邮箱" placeholder="请输入邮箱"/>
            <ty:text name="密码" id="password" placeholder="请输入密码" type="password"/>
            <ty:text name="再输密码" id="passwords" type="password"
                     placeholder="请再输密码"/>
            <ty:button id="btn_save" cssStyle="margin-left:100px" type="submit" name="注册"/>
        </ty:box>
    </ty:panel>
</ty:form>