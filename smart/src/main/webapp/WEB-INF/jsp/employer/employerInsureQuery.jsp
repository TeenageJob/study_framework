<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<jsp:include page="../common/bootstrap-tabel.jsp"/>
<ty:panel id="panl_1" name="个人参保" cssStyle="overflow-y:auto">
    <ty:grid id="grid_AB11B" name="参保信息">
        <ty:gridItem field="" title="" checkbox="true"/>
        <ty:gridItem field="ABA001" title="个人编号" visible="false"/>
        <ty:gridItem field="ABC001" title="账户编号" visible="false"/>
        <ty:gridItem field="ABB001" title="参保编号"/>
        <ty:gridItem field="ABC002" title="银行账号"/>
        <ty:gridItem field="ABA002" title="姓名"/>
        <ty:gridItem field="ABB002" title="参保时间"/>
        <%--<ty:gridItem field="fsfsda" title="测试" type="text"/>--%>
        <ty:gridItem field="del" title="操作" btnNameDel="删除" btnNameEdit="编辑" funDel="del" funEdit="edit"/>
       <%-- <ty:gridItem field="del" title="操作" type="button"/>--%>
    </ty:grid>
</ty:panel>
<script type="text/javascript">
    function del(e, row, index) {

    }
    function edit(e, row, index) {
        Base.submitA("employerEdit/index.do",function(data){
            loadHtml(data);
        },null,{ABB001:row.ABB001},null,"html")
    }
</script>
