<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:form method="post" url="employeeEdit/save.do">
    <ty:submit/>
    <ty:activitiBPMN/>
    <ty:panel id="box_employee" name="单位信息" cols="3">
        <ty:text id="ACB001" name="单位参保编号" readOnly="true"/>
        <ty:text id="ACA001" name="单位编号" readOnly="true"/>
        <ty:text id="ACA002" name="单位名称" readOnly="true"/>
    </ty:panel>
    <ty:panel id="panl_2" name="险种选择" cols="5">
        <ty:checkbox name="养老保险" id="ACB134" value="已参加"/>
        <ty:checkbox name="医疗保险" id="ACB131" value="已参加"/>
        <ty:checkbox name="生育保险" id="ACB132" value="已参加"/>
        <ty:checkbox name="失业保险" id="ACB133" value="已参加"/>
        <ty:checkbox name="工伤保险" id="ACB135" value="已参加"/>
    </ty:panel>
    <ty:panel id="panl_3" name="银行信息" cols="3">
        <ty:text id="ABC001" name="账户编号" readOnly="true"/>
        <ty:text id="ABC002" name="银行账号"/>
        <ty:text id="ABC003" name="银行户名"/>
        <ty:text id="ABC004" name="银行名称"/>
        <ty:selectInput id="ABC005" name="银行类别" colletions="ABC005"/>
        <ty:text id="ABC006" name="银行行号"/>
        <ty:selectInput id="ACB002" name="征收方式" colletions="ACB002"/>
    </ty:panel>
</ty:form>
