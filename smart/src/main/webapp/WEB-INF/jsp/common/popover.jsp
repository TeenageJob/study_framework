<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("BASEPATH", "/smart");
%>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/bootstrap-iconpicker.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/bootstrap-iconpicker-iconset-all.min.js"></script>
<link href="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/css/bootstrap-iconpicker.min.css" rel="stylesheet"/>

<script>
    //首先是工具提示：
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });
    //然后是弹出框：
    $(function () {
        $("[data-toggle='popover']").popover();
    });
</script>
<%--//额外
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link href="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/jquery/1.11.1/jquery.min.js"></script>--%>
