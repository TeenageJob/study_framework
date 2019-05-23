<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:form method="post" url="cardAdd/save.do" before="beforeFun">
    <ty:submit/>
    <ty:navbar/>
    <ty:activitiBPMN/>
    <ty:panel id="panl_1" name="基本信息" cols="3">
        <ty:text id="ACA001" name="单位编号" readOnly="true"/>
        <ty:text id="ACA002" name="单位名称" readOnly="true"/>
        <ty:text id="ABA001" name="个人编号" readOnly="true"/>
        <ty:text id="ABA002" name="姓名" readOnly="true"/>
        <ty:text id="ABC001" name="账户编号" readOnly="true"/>
    </ty:panel>
    <ty:panel id="panl_2" name="填写信息" cols="3">
        <ty:text id="AEA001" name="办理卡编号" readOnly="true"/>
        <ty:text id="AEA005" name="一卡通编号" required="required" inputType="number"/>
        <ty:text id="AEA003" name="有效时间" required="required" value="5" max="5"/>
        <ty:selectInput id="AEA004" name="一卡通状态" colletions="AEA004"/>
    </ty:panel>
</ty:form>
<script type="text/javascript">
    function beforeFun() {
        Base.setData("AEA001", getTime());
    }
</script>
