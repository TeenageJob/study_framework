<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/bootstrap-tabel.jsp"/>
<ty:panel id="panl_1" name="所有用户" >
    <ty:grid id="grid_1" name="测试">
        <ty:gridItem title="id" field="id"/>
        <ty:gridItem title="邮箱" field="email"/>
        <ty:gridItem title="账户" field="username"/>
        <ty:gridItem title="创建时间" field="create_time"/>
        <ty:gridItem title="最后登录时间" field="last_login_time"/>
        <ty:gridItem title="编辑" field="deal" btn="true" btnNameEdit="编辑" funEdit="table_btnEdit"/>
    </ty:grid>
</ty:panel>
<script type="text/javascript">
    function table_btnEdit(e, data, index) {
        var info={
            username:data.username
        }
        Base.submitA("userManager/getData.do",function (data) {
            loadHtml(data);
        },null,info,null,"html");
    }
</script>
