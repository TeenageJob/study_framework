<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<jsp:include page="../common/bootstrap-tabel.jsp"/>
<ty:panel id="panl_1" name="参保单位">
    <ty:grid id="grid_ACB001" name="参保信息">
        <ty:gridItem field="ACA001" title="单位编号" visible="false"/>
        <ty:gridItem field="ABC001" title="账户编号" visible="false"/>
        <ty:gridItem field="ACB001" title="参保编号"/>
        <ty:gridItem field="ABC002" title="银行账号"/>
        <ty:gridItem field="ACA002" title="单位名称"/>
        <ty:gridItem field="ACB003" title="参保时间"/>
        <ty:gridItem field="del" title="操作" btnNameDel="删除" btnNameEdit="编辑" funDel="del" funEdit="edit"/>
    </ty:grid>
</ty:panel>
<script type="text/javascript">
    function del(e, row, index) {

    }

    function edit(e, row, index) {
        Base.submitA("employeeEdit/index.do",function(data){
            loadHtml(data);
        },null,{ACB001:row.ACB001},null,"html")
    }
</script>
