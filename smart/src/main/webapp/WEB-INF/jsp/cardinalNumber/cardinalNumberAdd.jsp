<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:form method="post" url="cardinalNumberAdd/save.do" before="beforeFun">
    <ty:submit/>
    <ty:activitiBPMN/>
    <ty:panel id="panl_1" cols="5" name="选择险种">
        <ty:checkbox id="AD13A_box" value="AD13A" val="A" name="医疗保险"/>
        <ty:checkbox id="AD13B_box" value="AD13B" val="B" name="生育保险"/>
        <ty:checkbox id="AD13C_box" value="AD13C" val="C" name="失业保险"/>
        <ty:checkbox id="AD13D_box" value="AD13D" val="D" name="养老保险"/>
        <ty:checkbox id="AD13E_box" value="AD13E" val="E" name="工伤保险"/>
    </ty:panel>
    <ty:panel id="AD13A" cols="3" name="医疗保险">
        <ty:hidden id="AD13A" value="0"/>
        <ty:text id="AADA00A" name="险种编号" readOnly="true"/>
        <ty:hidden id="AADA00B" flag="险种类型" value="A"/>
        <ty:hidden id="AADA00J" flag="险种名称" value="医疗保险"/>
        <ty:text id="AADA00C" name="缴费基数上限" required="required" maxLength="3" inputType="number"/>
        <ty:text id="AADA00D" name="缴费基数下限" required="required" inputType="number"/>
        <ty:date id="AADA00E" name="基数开始时间" required="required" onChange="AADA00E" />
        <ty:date id="AADA00F" name="基数终止时间" required="required" onChange="AADA00F"/>
        <ty:text id="AADA00G" name="单位应缴比例" required="required" inputType="number"/>
        <ty:text id="AADA00H" name="个人应缴比例" required="required" inputType="number"/>
    </ty:panel>
    <ty:panel id="AD13B" cols="3" name="生育保险">
        <ty:hidden id="AD13B" value="0"/>
        <ty:text id="BADA00A" name="险种编号" readOnly="true"/>
        <ty:hidden id="BADA00B" flag="险种类型" value="B"/>
        <ty:hidden id="BADA00J" flag="险种名称" value="生育保险"/>
        <ty:text id="BADA00C" name="缴费基数上限" required="required"  inputType="number"/>
        <ty:text id="BADA00D" name="缴费基数下限" required="required" inputType="number"/>
        <ty:date id="BADA00E" name="基数开始时间" required="required"/>
        <ty:date id="BADA00F" name="基数终止时间" required="required"/>
        <ty:text id="BADA00G" name="单位应缴比例" required="required" inputType="number"/>
        <ty:text id="BADA00H" name="个人应缴比例" required="required" inputType="number"/>
    </ty:panel>
    <ty:panel id="AD13C" cols="3" name="失业保险">
        <ty:hidden id="AD13C" value="0"/>
        <ty:text id="CADA00A" name="险种编号" readOnly="true"/>
        <ty:hidden id="CADA00B" flag="险种类型" value="C"/>
        <ty:hidden id="CADA00J" flag="险种名称" value="失业保险"/>
        <ty:text id="CADA00C" name="缴费基数上限" required="required" inputType="number"/>
        <ty:text id="CADA00D" name="缴费基数下限" required="required" inputType="number"/>
        <ty:date id="CADA00E" name="基数开始时间" required="required"/>
        <ty:date id="CADA00F" name="基数终止时间" required="required"/>
        <ty:text id="CADA00G" name="单位应缴比例" required="required" inputType="number"/>
        <ty:text id="CADA00H" name="个人应缴比例" required="required" inputType="number"/>
    </ty:panel>
    <ty:panel id="AD13D" cols="3" name="养老保险">
        <ty:hidden id="AD13D" value="0"/>
        <ty:text id="DADA00A" name="险种编号" readOnly="true"/>
        <ty:hidden id="DADA00B" flag="险种类型" value="D"/>
        <ty:hidden id="DADA00J" flag="险种名称" value="养老保险"/>
        <ty:text id="DADA00C" name="缴费基数上限" required="required" inputType="number"/>
        <ty:text id="DADA00D" name="缴费基数下限" required="required" inputType="number"/>
        <ty:date id="DADA00E" name="基数开始时间" required="required"/>
        <ty:date id="DADA00F" name="基数终止时间" required="required"/>
        <ty:text id="DADA00G" name="单位应缴比例" required="required" inputType="number"/>
        <ty:text id="DADA00H" name="个人应缴比例" required="required" inputType="number"/>
    </ty:panel>
    <ty:panel id="AD13E" cols="3" name="工伤保险">
        <ty:hidden id="AD13E" value="0"/>
        <ty:text id="EADA00A" name="险种编号" readOnly="true"/>
        <ty:hidden id="EADA00B" flag="险种类型" value="E"/>
        <ty:hidden id="EADA00J" flag="险种名称" value="工伤保险"/>
        <ty:text id="EADA00C" name="缴费基数上限" required="required" inputType="number"/>
        <ty:text id="EADA00D" name="缴费基数下限" required="required" inputType="number"/>
        <ty:date id="EADA00E" name="基数开始时间" required="required"/>
        <ty:date id="EADA00F" name="基数终止时间" required="required"/>
        <ty:text id="EADA00G" name="单位应缴比例" required="required" inputType="number"/>
        <ty:text id="EADA00H" name="个人应缴比例" required="required" inputType="number"/>
    </ty:panel>

</ty:form>
<script type="text/javascript">



    function AADA00E(ev,value) {
        vaData(value,Base.getVal("AADA00F"));
    }

    function vaData(a,b){
        if(a>b){
            Base.alert("设置有误");
            Base.clearData(b);
        }
    }
    
    function beforeFun(){
        $("input:checkbox:checked").each(function(){
           var value= Base.getVal($(this).attr("val")+"ADA00A");
            if(value==null||value=="") {
                Base.setData($(this).attr("val") + "ADA00A", getTime());
            }
        });
    }

    $(function () {
        $("input:checkbox").each(function(){
            if(!$(this).get(0).checked){
                Base.setHide($(this).val())
            }
        });
    });
    $("input:checkbox").click(function () {
        if ($(this).get(0).checked) {
            Base.setShow($(this).val());
        } else {
            Base.setHide($(this).val());
        }
    });

</script> 