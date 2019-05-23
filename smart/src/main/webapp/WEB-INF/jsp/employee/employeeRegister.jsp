<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:form method="post" url="employeeInsure/save.do" before="beforeSubmit">
    <ty:submit/>
    <ty:activitiBPMN/>
    <ty:panel id="box_employee" name="单位信息" cols="3">
        <ty:text id="ACA001" name="单位编号" readOnly="true"/>
        <ty:text id="ACA002" name="单位名称" required="required"/>
        <ty:selectInput id="ACA003" name="证照类型" colletions="ACA003"/>
        <ty:text id="ACA004" name="证照代码"/>
        <ty:selectInput id="ACA005" name="单位类型" colletions="ACA005"/>
        <ty:text id="ACA006" name="单位电话" inputType="number" maxLength="11" minLength="11"/>
        <ty:box id="ACA007_BOX" span="3" cols="4">
            <ty:selectInput id="ACA007_P" flex="false" name="单位地址" onchange="getABA014" colletions="AAA003"/>
            <ty:selectInput id="ACA007_C"  onchange="getACA007_C"/>
            <ty:selectInput id="ACA007_A"/>
        </ty:box>
        <ty:text span="2" id="ACA007_X" name="详细地址" width="400px"/>
    </ty:panel>
    <ty:panel id="panl_employee" cols="3" name="法人信息">
        <ty:text id="ABA002" name="法人姓名"/>
        <ty:text id="ABA004" name="法人身份证"/>
        <ty:text id="ABA009" name="法人电话"/>
    </ty:panel>
    <ty:hidden id="ACA007"/>
</ty:form>
<script type="text/javascript">

    function beforeSubmit() {
        var val = Base.getVal("ACA007_P") + Base.getVal("ACA007_C") + Base.getVal("ACA007_A") + Base.getVal("ACA007_X");
        Base.setData("ACA007", val);
        Base.setData("ACA001",getTime("YmdHis"))
    }

    function getABA014(e, id, value, index) {
        $("#ACA007_C").empty();
        $("#ACA007_A").empty();
        var info = {
            AAA001: "AAA004",
            aid: id
        }
        Base.submitA("publicQuery/getCities.do", function (data) {
            var json = data.data;
            Base.setSelectInput("ACA007_C", json);
        }, null, info);
    }

    function getACA007_C(e, id, value, index) {
        $("#ACA007_A").empty();
        var info = {
            AAA001: "AAA005",
            aid: id
        }
        Base.submitA("publicQuery/getCities.do", function (data) {
            var json = data.data;
            Base.setSelectInput("ACA007_A", json);
        }, null, info);
    }
</script>