<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ty:panel id="panl_1" cols="6" cssStyle="overflow-y:auto">
    <ty:button id="btn_fuhe" name="审核" onClick="check()"/>
    <ty:button id="btn_rollback" name="回退" onClick="rollback()"/>
    <ty:button id="btn_cancel" name="撤销" onClick="cancel()"/>
</ty:panel>
<div id="context_fuhe">
    ${html}
    <input type="hidden" id="task_id" value="${taskId}"/>
    <input type="hidden" id="service" value="${service}"/>
</div>
<script>
    $(function () {
        $("#context_fuhe input:button").remove();
        $("#context_fuhe input:submit").remove();
        $("#context_fuhe").find("*").each(function () {
            $(this).attr("disabled", "disabled");
        });
        $("#context_fuhe").find("input:checkbox").each(function () {
            $(this).removeAttr("disabled");
        });
    })

    //审核通过
    function check() {
        var info = {
            service: Base.getVal("service"),
            taskId: Base.getVal("task_id")
        }
        Base.submitA("task/completeTask.do", function () {
            Base.alert("成功！");
            Base.setHide("btn_fuhe", "btn_rollback", "btn_cancel");
        }, null, info);
    }

    //回退
    function rollback() {
        var info = {
            service: Base.getVal("service"),
            taskId: Base.getVal("task_id")
        }
        Base.submitA("task/rollbackTask.do", function () {
            Base.alert("成功！");
            Base.setHide("btn_fuhe", "btn_rollback", "btn_cancel");
        }, null, info);
    }

    //撤销
    function cancel() {
        var info = {
            service: Base.getVal("service"),
            taskId: Base.getVal("task_id")
        }
        Base.submitA("task/cancelTask.do", function () {
            Base.alert("成功！");
            Base.setHide("btn_fuhe", "btn_rollback", "btn_cancel");
        }, null, info);
    }
</script>