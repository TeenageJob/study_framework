<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:form method="post" url="employerInsure/save.do" before="funBefore">
    <ty:submit/>
    <ty:navbar/>
    <ty:activitiBPMN/>
    <ty:panel id="box_employee" name="单位信息" cols="3">
        <ty:text id="ACA001" name="单位编号" readOnly="true"/>
        <ty:text id="ACA002" name="单位名称"/>
    </ty:panel>
    <ty:panel id="box_employer" name="个人信息" cols="4">
        <ty:text id="ABA001" name="个人编号"/>
        <ty:text id="ABA002" name="个人姓名"/>
        <ty:selectInput id="ABA003" name="性别" colletions="ABA003"/>
        <ty:text id="ABA004" name="身份证"/>
        <ty:box id="box_ABA005" cols="2" span="2">
            <ty:selectInput name="籍贯" id="ABA005_P" flex="false" style="width:100px" onchange="getABA005"  colletions="AAA003"/>
            <ty:selectInput id="ABA005_C"/>
        </ty:box>
        <ty:selectInput id="ABA006" name="政治面貌" colletions="ABA006"/>
        <ty:text id="ABA007" name="出生年月"/>
        <ty:text id="ABA008" name="参加工作时间"/>
        <ty:text id="ABA009" name="电话"/>
        <ty:selectInput id="ABA010" name="民族" colletions="ABA010"/>
        <ty:selectInput id="ABA011" name="离退休状态" colletions="ABA011"/>
        <ty:text id="ABA012" name="电子邮箱"/>
        <ty:text id="ABA013" name="邮政编码"/>
        <ty:box id="box_ABA014" span="4" cols="4">
            <ty:selectInput id="ABA014_P" flex="false" name="通信地址" onchange="getABA014" colletions="AAA003"/>
            <ty:selectInput id="ABA014_C" onchange="getABA014_C"/>
            <ty:selectInput id="ABA014_A"/>
        </ty:box>
        <ty:text span="3" id="ABA014_X" name="详细地址" width="400px"/>
        <ty:hidden id="ABA014"/>
        <ty:hidden id="ABA005"/>
    </ty:panel>

</ty:form>
<script type="text/javascript">

    function funBefore(){
        Base.setData("ABA001",getTime());
        var addr=Base.getVal("ABA014_P")+Base.getVal("ABA014_C")+Base.getVal("ABA014_A")+Base.getVal("ABA014_X");
        Base.setData("ABA014",addr);
        addr=Base.getVal("ABA005_P")+Base.getVal("ABA005_C");
        Base.setData("ABA005",addr);
    }

    function getABA005(e, id, value, index){
        $("#ABA005_C").empty();
        var info={
            AAA001:"AAA004",
            aid:id
        }
        Base.submitA("publicQuery/getCities.do",function(data){
             var json=data.data;
            Base.setSelectInput("ABA005_C",json);
        },null,info);
    }
    function getABA014(e, id, value, index){
        $("#ABA014_C").empty();
        $("#ABA014_A").empty();
        var info={
            AAA001:"AAA004",
            aid:id
        }
        Base.submitA("publicQuery/getCities.do",function(data){
            var json=data.data;
            Base.setSelectInput("ABA014_C",json);
        },null,info);
    }
    function getABA014_C(e, id, value, index){
        $("#ABA014_A").empty();
        var info={
            AAA001:"AAA005",
            aid:id
        }
        Base.submitA("publicQuery/getCities.do",function(data){
            var json=data.data;
            Base.setSelectInput("ABA014_A",json);
        },null,info);
    }
</script>