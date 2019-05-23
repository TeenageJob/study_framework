<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<jsp:include page="../common/bootstrap-tabel.jsp"/>
<ty:submit key="退款"/>
<ty:navbar/>
<ty:form method="post" url="employerATLBack/save.do">
    <ty:activitiBPMN/>
    <ty:panel id="panl_info" name="选择信息" cols="3">
        <ty:box id="box_1" span="3" cols="3">
            <ty:text id="ABA001" name="个人编号" readOnly="true"/>
            <ty:text id="ABA002" name="个人姓名" readOnly="true"/>
        </ty:box>
        <ty:date id="start" name="开始时间" format="yyyy-mm" required="required" onChange="getInfo"/>
        <ty:date id="end" name="结束时间" format="yyyy-mm" required="required" onChange="getInfo"/>
        <ty:selectInput id="ADA00J" colletions="ADA00J" name="险种" onchange="getInfo"/>
    </ty:panel>
    <ty:panel id="panl_2" name="缴费信息">
        <ty:grid id="panl_repair" name="险种缴费信息">
            <ty:gridItem field="001" title="保险编号"/>
            <ty:gridItem field="008" title="工资"/>
            <ty:gridItem field="009" title="上年平均工资"/>
            <ty:gridItem field="003" title="缴费时间"/>
            <ty:gridItem field="002" title="缴费基数"/>
            <ty:gridItem field="004" title="单位应缴"/>
            <ty:gridItem field="005" title="单位实缴"/>
            <ty:gridItem field="006" title="个人应缴"/>
            <ty:gridItem field="007" title="个人实缴"/>

        </ty:grid>
    </ty:panel>
</ty:form>
<script type="text/javascript">

    function noNull() {
        if (Base.getVal("ABA001") == null || Base.getVal("ABA001") == "" ||
            Base.getVal("ABA002") == null || Base.getVal("ABA002") == "" ||
            Base.getVal("start") == null || Base.getVal("start") == "" ||
            Base.getVal("end") == null || Base.getVal("end") == "" ||
            Base.getVal("ADA00J") == null || Base.getVal("ADA00J") == "") {
            return false;
        }
    }

    function getInfo(e, value) {
        if (noNull() == false) {
            return;
        }
        var info = {
            ABA001: Base.getVal("ABA001"),
            ABA002: Base.getVal("ABA002"),
            start: Base.getVal("start"),
            end: Base.getVal("end"),
            ADA00J: Base.getVal("ADA00J")
        }
        Base.submitA("employerATLBack/getEmployerPaymentInfo.do", null, null, info);
    }


</script>