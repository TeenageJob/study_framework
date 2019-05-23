<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:submit/>
<ty:navbar/>
<ty:form method="post" url="employerPayment/save.do" before="beforeFun">
    <ty:activitiBPMN/>
    <ty:panel id="panl_baseInfo" cols="4" name="基本信息">
        <ty:text id="ACA001" name="单位编号" readOnly="true"/>
        <ty:text id="ACA002" name="单位名称" readOnly="true"/>
        <ty:text id="ABA001" name="个人编号" readOnly="true"/>
        <ty:text id="ABA002" name="个人姓名" readOnly="true"/>
        <ty:text id="009" name="上年平均工资" inputType="number" onChange="countInfo()" required="required"/>
        <ty:text id="008" name="工资" inputType="number" onChange="countInfo()" required="required"/>
    </ty:panel>
    <ty:panel id="panl_1" cols="5" name="选择缴费险种">
        <ty:checkbox id="AD13A_box" value="AD13A" val="ADA001" name="医疗保险"/>
        <ty:checkbox id="AD13B_box" value="AD13B" val="ADB001" name="生育保险"/>
        <ty:checkbox id="AD13C_box" value="AD13C" val="ADC001" name="失业保险"/>
        <ty:checkbox id="AD13D_box" value="AD13D" val="ADD001" name="养老保险"/>
        <ty:checkbox id="AD13E_box" value="AD13E" val="ADE001" name="工伤保险"/>
    </ty:panel>
    <ty:panel id="AD13A" cols="3" name="医疗保险">
        <ty:text id="ADA001" name="医疗保险编号" readOnly="true"/>
        <ty:text id="ADA006" name="个人应缴" readOnly="true"/>
        <ty:text id="ADA004" name="单位应缴" readOnly="true"/>
        <ty:text id="ADA002" name="缴费基数" readOnly="true"/>
        <ty:text id="ADA007" name="个人实缴" inputType="number" required="required"/>
        <ty:text id="ADA005" name="单位实缴" inputType="number" required="required"/>
    </ty:panel>
    <ty:panel id="AD13B" cols="3" name="生育保险">
        <ty:text id="ADB001" name="医疗保险编号" readOnly="true"/>
        <ty:text id="ADB006" name="个人应缴" readOnly="true"/>
        <ty:text id="ADB004" name="单位应缴" readOnly="true"/>
        <ty:text id="ADB002" name="缴费基数" readOnly="true"/>
        <ty:text id="ADB007" name="个人实缴" readOnly="true" value="0.0"/>
        <ty:text id="ADB005" name="单位实缴" inputType="number" required="required"/>
    </ty:panel>
    <ty:panel id="AD13C" cols="3" name="失业保险">
        <ty:text id="ADC001" name="医疗保险编号" readOnly="true"/>
        <ty:text id="ADC006" name="个人应缴" readOnly="true"/>
        <ty:text id="ADC004" name="单位应缴" readOnly="true"/>
        <ty:text id="ADC002" name="缴费基数" readOnly="true"/>
        <ty:text id="ADC007" name="个人实缴" inputType="number" required="required"/>
        <ty:text id="ADC005" name="单位实缴" inputType="number" required="required"/>
    </ty:panel>
    <ty:panel id="AD13D" cols="3" name="养老保险">
        <ty:text id="ADD001" name="医疗保险编号" readOnly="true"/>
        <ty:text id="ADD006" name="个人应缴" readOnly="true"/>
        <ty:text id="ADD004" name="单位应缴" readOnly="true"/>
        <ty:text id="ADD002" name="缴费基数" readOnly="true"/>
        <ty:text id="ADD007" name="个人实缴" inputType="number" required="required"/>
        <ty:text id="ADD005" name="单位实缴" inputType="number" required="required"/>
    </ty:panel>
    <ty:panel id="AD13E" cols="3" name="工伤保险">
        <ty:text id="ADE001" name="医疗保险编号" readOnly="true"/>
        <ty:text id="ADE006" name="个人应缴" readOnly="true"/>
        <ty:text id="ADE004" name="单位应缴" readOnly="true"/>
        <ty:text id="ADE002" name="缴费基数" readOnly="true"/>
        <ty:text id="ADE007" name="个人实缴" readOnly="true" value="0.0"/>
        <ty:text id="ADE005" name="单位实缴" inputType="number" required="required"/>
    </ty:panel>
</ty:form>
<script type="text/javascript">

    /**
     * 获取缴费基数和应缴金额
     */
    function countInfo() {
        if (Base.getVal("009") == null ||
            Base.getVal("009") == "" ||
            Base.getVal("008") == null ||
            Base.getVal("008") == "") {
            return;
        }
        var info = {
            '009': Base.getVal("009"),
            '008': Base.getVal("008")
        }
        Base.submitA("employerPayment/getBaseNumber.do", null, null, info);
    }

    /**
     * 提交前执行
     */
    function beforeFun() {
        if (Base.getVal("ACA001") == null || Base.getVal("ACA001") == "") {
            alert(Base.getVal("ACA001"));
            return false;
        }
        $("input:checkbox:checked").each(function () {//所有被选中的险种
            Base.setData($(this).attr("val"), getTime());//设置编码
        });
    }

    $(function () {
        $("input:checkbox").each(function () {
            if (!$(this).get(0).checked) {
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