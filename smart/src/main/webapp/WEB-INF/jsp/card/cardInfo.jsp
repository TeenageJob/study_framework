<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<jsp:include page="../common/bootstrap-tabel.jsp"/>
<ty:panel id="pn_1" name="一卡通信息">
    <ty:grid id="gd_card" btnOne="挂失" name="卡信息">
        <ty:gridItem field="" title="" checkbox="true"/>
        <ty:gridItem field="AEA001" title="办理卡编号" visible="false"/>
        <ty:gridItem field="ABA001" title="个人编号"/>
        <ty:gridItem field="ABA002" title="姓名"/>
        <ty:gridItem field="AEA005" title="一卡通编号"/>
        <ty:gridItem field="AEA004" title="一卡通状态"/>
        <ty:gridItem field="AEA002" title="办理时间"/>
        <ty:gridItem field="AEA003" title="有效时间（年）"/>
        <ty:gridItem field="del" title="操作" btnNameDel="删除" btnNameEdit="编辑" funDel="del" funEdit="edit"/>
    </ty:grid>
</ty:panel>
<script type="text/javascript">
    function grid_btn_one() {
        var ids = []
        var data = $("#gd_card").bootstrapTable('getAllSelections');
        for (var key in data) {
            if (data[key].AEA004 == "正常") {
                ids.push(data[key].AEA001);
            }
        }
        var info = {
            id: JSON.stringify(ids)
        };
        Base.submitA("cardEdit/reportLoss.do", function () {
            Base.alert("选中正常的卡已挂失");
        }, function (data) {
            Base.alert("没有需要更改的信息");
        }, info);
    }
</script>
