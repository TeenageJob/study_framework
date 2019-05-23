<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/bootstrap-tabel.jsp"/>
<ty:panel id="panl_1" value="所有模型" cssStyle="overflow-y:auto">
    <table width="80%" class="table table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th>任务ID</th>
            <th>任务名称</th>
            <th>流程实例ID</th>
            <th>流程定义ID</th>
            <th>任务创建时间</th>
            <th>办理人</th>
            <th>操作</th>
        </tr>
        </thead>
        <input type="hidden" value="${taskList}"/>
        <tbody>
        <c:forEach items="${taskList }" var="task">
            <tr>
                <td>${task.id }</td>
                <td>${task.name }</td>
                <td>${task.processInstanceId }</td>
                <td>${task.processDefinitionId }</td>
                <td>${task.createTime }</td>
                <td>${task.assignee }</td>
                <td>
                    <c:if test="${empty task.assignee }">
                        <ty:button id="calim" name="签收" onClick="calimTask('task/claim.do?taskId=${task.id}')"/>
                    </c:if>
                    <c:if test="${not empty task.assignee }">
                        <ty:button id="calim" name="办理" onClick="btnFun('task/getform.do?taskId=${task.id}')"/>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</ty:panel>
<%--<ty:panel id="pan_1" name="所有模型">
    <ty:button id="exper" name="导出" onClick="doExport()"/>
    <ty:grid id="grid_taskList" name="任务列表">
        <ty:gridItem field="id" title="任务ID"/>
        <ty:gridItem field="name" title="任务名称"/>
        <ty:gridItem field="processInstanceId" title="流程实例ID"/>
        <ty:gridItem field="processDefinitionId" title="流程定义ID"/>
        <ty:gridItem field="createTime" title="任务创建时间"/>
        <ty:gridItem field="assignee" title="办理人"/>
        <ty:gridItem field="grid_btn" title="操作" btnNameEdit="签收" funEdit="btnCalimTask"/>
    </ty:grid>
</ty:panel>--%>
<script type="text/javascript">

    function btnFun(data) {
        Base.submitA(data, function (html) {
            loadHtml(html);
        }, null, null, null, "html")
    }

    function calimTask(data) {
        Base.submitA(data, function () {
            Base.alert("成功！");
            Base.submitA("task/index.do", function (html) {
                loadHtml(html);
            }, null, null, null, "html");
        })
    }
</script>